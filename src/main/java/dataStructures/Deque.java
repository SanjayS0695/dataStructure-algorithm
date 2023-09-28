package dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Deque<T> implements Iterable{

        private Node head;

        public Deque() {}

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            var current = head;
            var size = 0;
            while(current != null) {
                current = current.getNext();
                size++;
            }
            return size;
        }

        public void addFirst(T value) {
            if (Objects.isNull(value)) {
                throw new IllegalArgumentException();
            }
            var newNode = new Node<>(value);
            if (head == null) {
                head = newNode;
            } else {
                var current = head;
                head = newNode;
                head.setNext(current);
            }
        }

        public void addLast(T value) {
            if (Objects.isNull(value)) {
                throw new IllegalArgumentException();
            }
            var newNode = new Node<>(value);
            if (head == null) {
                head = newNode;
            } else {
                var current = head;
                while(current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newNode);
            }
        }

        public T removeFirst() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            } else if (size() == 1) {
                var value = head.getData();
                head = null;
                return (T) value;
            } else {
                var value = head.getData();
                head = head.getNext();
                return (T) value;
            }
        }

        public T removeLast() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            } else if (size() == 1) {
                var value = head.getData();
                head = null;
                return (T) value;
            }  else {
                var current = head;
                while(current.getNext().getNext() != null) {
                    current = current.getNext();
                }
                var value = current.getNext().getData();
                current.setNext(null);
                return (T)value;
            }
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

        @Override
        public Iterator iterator() {
            return new DequeIterator();
        }

        public class DequeIterator implements Iterator {

            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Object next() {
                var value = (T)current.getData();
                current = current.getNext();
                return value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        public static void main(String[] args) {
            var deque = new Deque<Integer>();
            System.out.println(deque);
            //[]
            deque.addFirst(0);
            System.out.println(deque);
            //[Head: 0]
            deque.addFirst(1);
            System.out.println(deque);
            //[Head: 0] -> [Tail: 1]
            deque.addFirst(2);
            System.out.println(deque);
            //[Head: 0] -> [1] -> [Tail: 2]
            deque.addLast(-1);
            System.out.println(deque);
            //[Head: -1] -> [0] -> [1] -> [Tail: 2]
            //dequeue.addLast(null);
            //Exception in thread "main" java.lang.IllegalArgumentException
            System.out.println(deque.removeFirst());
            //2
            System.out.println(deque);
            //[Head: 1] -> [0] -> [Tail: -1]
            System.out.println(deque.removeLast());
            //-1
            System.out.println(deque);
            //[Head: 1] -> [Tail: 0]

            var iterator = deque.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            //1
            //0

            iterator.remove();
            //Exception in thread "main" java.lang.UnsupportedOperationExceptionx
        }
    }
