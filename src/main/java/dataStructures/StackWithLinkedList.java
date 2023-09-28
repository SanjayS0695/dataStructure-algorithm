package dataStructures;

import java.util.Iterator;

public class StackWithLinkedList {

    public static void main(String[] args) {
        var stack = new Stack<Integer>();
        System.out.println(stack);
        //[]
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack);
        //[Head: 6] -> [5] -> [4] -> [3] -> [2] -> [Tail: 1]

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

        System.out.println(stack.size());
        //6
        System.out.println(stack.pop());
        //6
        System.out.println(stack);
        //[Head: 5] -> [4] -> [3] -> [2] -> [Tail: 1]
        stack.pop();
        stack.pop();
        System.out.println(stack);
        //[Head: 3] -> [2] -> [Tail: 1]
        System.out.println(stack.size());
        //3
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack);
        //[]
        stack.pop();
        //Empty Stack
        System.out.println(stack.isEmpty());
        //true
    }

        public static class Stack<T> implements Iterable<T>{
            private Node head;

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
                return this.head == null;
            }

            public void push(T value) {
                var newNode = new Node(value);
                newNode.setNext(head);
                this.head = newNode;
            }

            public T pop() {
                if (this.head == null) {
                    System.out.println("Empty Stack");
                    return null;
                } else {
                    var value = (T) this.head.getData();
                    this.head = this.head.getNext();
                    return value;
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
            public Iterator<T> iterator() {
                return new StackIterator();
            }

            public class StackIterator implements Iterator<T>{

                private Node current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    var value = (T)current.getData();
                    current = current.getNext();
                    return value;
                }
            }
        }
}
