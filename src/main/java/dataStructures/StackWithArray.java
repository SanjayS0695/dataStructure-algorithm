package dataStructures;

import java.lang.reflect.Array;
import java.util.Iterator;

public class StackWithArray {

    public static void main(String[] args) {
        var stack = new Stack<>(Integer.class, 5);
        System.out.println(stack);
        //[ null, null, null, null, null, null, null, null, null, null,  ]
        stack.push(Integer.class,1);
        stack.push(Integer.class,2);
        stack.push(Integer.class,3);
        stack.push(Integer.class,4);
        System.out.println(stack);

        var stackIterator = stack.iterator();
        while(stackIterator.hasNext()) {
            System.out.println(stackIterator.next());
        }
        //6
        //5
        //4
        //3
        //2
        //1

        stack.push(Integer.class,5);
        System.out.println(stack);
        stack.push(Integer.class,6);
        System.out.println(stack);
        //[ 1, 2, 3, 4, 5, 6, null, null, null, null,  ]
        stack.pop(Integer.class);
        stack.pop(Integer.class);
        stack.pop(Integer.class);
        stack.pop(Integer.class);
        stack.pop(Integer.class);
        stack.pop(Integer.class);
        System.out.println(stack);
        //[ null, null,  ]
        System.out.println(stack.size());
        //2
        stack.push(Integer.class,10);
        System.out.println(stack);
        //[ 1, 2, 10, null, null, null, null, null, null, null,  ]
        System.out.println(stack.size());
        //3
    }

    public static class Stack<T> implements Iterable<T>{
        private T[] array;
        private int N = 0;

        private Stack(Class<T> cls,  int size) {
            this.array = (T[]) Array.newInstance(cls, size);
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public void push(Class<T> cls, T value) {
            if (N >= this.array.length) {
                this.resize(cls, 2*N);
            }
            this.array[N++] = value;
        }

        public T pop(Class<T> cls) {
            if (N > 0 && N == this.array.length/4) {
                this.resize(cls, this.array.length/2);
            }
            if (N == 0) {
                System.out.println("Empty Stack");
                return null;
            } else {
                var value = this.array[--N];
                this.array[N] = null;
                return value;
            }
        }

        private void resize(Class<T> cls, int size) {
            var copy = (T[]) Array.newInstance(cls, size);
            for (int i=0; i<N;i++) {
                copy[i] = this.array[i];
            }
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

        @Override
        public Iterator<T> iterator() {
            return new StackIterator();
        }

        public class StackIterator implements Iterator<T>{

            private int i = N;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public T next() {
                return array[--i];
            }
        }
    }
}
