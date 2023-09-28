package dataStructures;

public class QueueLinkedList {

    public static void main(String[] args) {
        var queue = new Queue<Integer>();
        System.out.println(queue);
        //[]
        System.out.println(queue.isEmpty());
        //true
        System.out.println(queue.size());
        //0
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue);
        //[Head: 0] -> [1] -> [2] -> [3] -> [Tail: 4]
        System.out.println(queue.isEmpty());
        //false
        System.out.println(queue.size());
        //5
        System.out.println(queue.dequeue());
        //0
        System.out.println(queue.dequeue());
        //1
        System.out.println(queue.size());
        //3
        System.out.println(queue);
        //[Head: 2] -> [3] -> [Tail: 4]
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        //Empty queue
    }

    public static class Queue<T> {
        private Node head;
        private Node last;

        public int size() {
            var current = head;
            var size = 0;
            while (current != null) {
                current = current.getNext();
                size++;
            }
            return size;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void enqueue(T value) {
            var current = head;
            var newNode = new Node<>(value);
            if (this.size() == 0) {
                head = newNode;
            } else {
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newNode);
            }
            last = newNode;
        }

        public T dequeue() {
            if (isEmpty()) {
                System.out.println("Empty queue");
            } else if (this.size() == 1) {
                var value = this.head.getData();
                this.head = null;
                this.last = null;
                return (T)value;
            } else {
                var current = this.head;
                this.head = this.head.getNext();
                return (T)current.getData();
            }
            return null;
        }

        @Override
        public String toString() {
            if (this.head == null) {
                return "[]";
            }
            var string = new StringBuilder();
            var current = this.head;
            while (current != null) {
                if (current == this.head) {
                    string.append(String.format("[Head: %s]", current.getData()));
                } else if (current.getNext() == null) {
                    string.append(String.format(" -> [Tail: %s]", current.getData()));
                } else {
                    string.append(String.format(" -> [%s]", current.getData()));
                }
                current = current.getNext();
            }
            return string.toString();
        }
    }
}
