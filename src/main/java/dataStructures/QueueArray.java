package dataStructures;

import java.lang.reflect.Array;

public class QueueArray {

    public static void main(String[] args) {
        var queue = new Queue<>(Integer.class, 2);
        System.out.println(queue);
        //[]
        System.out.println(queue.isEmpty());
        //true
        System.out.println(queue.size());
        //0
        queue.enqueue(Integer.class, 0);
        System.out.println(queue);
        //[ 0, null,  ]
        queue.enqueue(Integer.class, 1);
        System.out.println(queue);
        //[ 0, 1,  ]
        queue.enqueue(Integer.class, 2);
        System.out.println(queue);
        //[ 0, 1, 2, null,  ]
        queue.enqueue(Integer.class, 3);
        System.out.println(queue);
        //[ 0, 1, 2, 3,  ]
        queue.enqueue(Integer.class, 4);
        System.out.println(queue);
        //[ 0, 1, 2, 3, 4, null, null, null,  ]
        System.out.println(queue.dequeue(Integer.class));
        //0
        System.out.println(queue);
        //[ null, 1, 2, 3, 4, null, null, null,  ]
        System.out.println(queue.size());
        //4
        System.out.println(queue.dequeue(Integer.class));
        //1
        System.out.println(queue.dequeue(Integer.class));
        //2
        System.out.println(queue.size());
        //2
        System.out.println(queue);
        System.out.println(queue.dequeue(Integer.class));
        //3
        System.out.println(queue.dequeue(Integer.class));
        //4
        System.out.println(queue);
        //[ null, null,  ]
        queue.dequeue(Integer.class);
        //Empty queue
        queue.enqueue(Integer.class, 0);
        System.out.println(queue);
        //[ 0, null,  ]
        queue.enqueue(Integer.class, 1);
        queue.enqueue(Integer.class, 2);
        queue.enqueue(Integer.class, 3);
        queue.enqueue(Integer.class, 4);
        System.out.println(queue.size());
        //5
        System.out.println(queue);
        //[ 0, 1, 2, 3, 4, null, null, null,  ]
        queue.dequeue(Integer.class);
        queue.dequeue(Integer.class);
        queue.dequeue(Integer.class);
        queue.dequeue(Integer.class);
        System.out.println(queue);
        //[ null, 4, null, null,  ]
        System.out.println(queue.size());
        //1
        queue.dequeue(Integer.class);
        System.out.println(queue);
        //[ null, null,  ]
        System.out.println(queue.size());
        //0
        queue.enqueue(Integer.class, 3);
        System.out.println(queue);
    }

    public static class Queue<T> {
        private T[] array;
        private int N = 0;

        private int head = 0;

        private int tail = 0;

        Queue(Class<T> cls, int size) {
            this.array = (T[]) Array.newInstance(cls, size);
        }

        public int size() {
            return N;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public void enqueue(Class<T> cls, T value) {
            if (N >= array.length) {
                this.expand(cls, 2*N);
            }
            this.array[tail++] = value;
            N++;
        }

        public T dequeue(Class<T> cls) {
            if (this.isEmpty()) {
                System.out.println("Empty queue");
                this.head = 0;
                this.tail = 0;
            } else {
                if (N > 0 && N == this.array.length/4) {
                    this.compress(cls, this.array.length / 2);
                }
                var value = this.array[head];
                this.array[head++] = null;
                --N;
                if (N==0) {
                    this.head = 0;
                    this.tail = 0;
                }
                return value;
            }
            return null;
        }

        private void expand(Class<T> cls, int size) {
            var copy = (T[]) Array.newInstance(cls, size);
            for (int i=0; i<N;i++) {
                copy[i] = this.array[i];
            }
            this.array = copy;
        }

        private void compress(Class<T> cls, int size) {
            var copy = (T[]) Array.newInstance(cls, size);
            var j = 0;
            for (int i=this.head; i<this.tail;i++) {
                copy[j++] = this.array[i];
            }
            this.head = 0;
            this.tail = N;
            this.array = copy;
        }

        @Override
        public String toString() {
            var string = new StringBuilder();
            string.append("[ ");
            for (T value: this.array) {
                string.append(value+ ", ");
            }
            string.append(" ]");
            return string.toString();
        }
    }
}
