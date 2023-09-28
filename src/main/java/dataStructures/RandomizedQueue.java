package dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue <T> implements Iterable {

    private Node head;

    RandomizedQueue() {};

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        var current = head;
        var size = 0;
        while (current != null) {
            current = current.getNext();
            size++;
        }
        return size;
    }

    public void enqueue(T data) {
        var newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            var current = head;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (size() == 1) {
            var value = head.getData();
            head = null;
            return (T)value;
        } else {
            Random r = new Random();
            var randomPosition = r.nextInt(size());
            int i = 0;
            var current = head;
            while (i < randomPosition && current.getNext().getNext() != null) {
                current = current.getNext();
                i++;
            }
            var value = current.getNext().getData();
            if (current.getNext().getNext() != null) {
                current.setNext(current.getNext().getNext());
            } else {
                current.setNext(null);
            }
            return (T)value;
        }
    }

    public T sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (size() == 1) {
            var value = head.getData();
            return (T)value;
        } else {
            Random r = new Random();
            var randomPosition = r.nextInt(size());
            int i = 0;
            var current = head;
            while (i < randomPosition && current.getNext().getNext() != null) {
                current = current.getNext();
                i++;
            }
            var value = current.getNext().getData();
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
        return null;
    }

    public static void main(String[] args) {
        var randomQueue = new RandomizedQueue<Integer>();
        System.out.println(randomQueue);
        //[]
        randomQueue.enqueue(0);
        System.out.println(randomQueue);
        //[Head: 0]
        randomQueue.enqueue(1);
        randomQueue.enqueue(2);
        randomQueue.enqueue(3);
        randomQueue.enqueue(4);
        randomQueue.enqueue(5);
        System.out.println(randomQueue);
        //[Head: 0] -> [1] -> [2] -> [3] -> [4] -> [Tail: 5]
        System.out.println(randomQueue.dequeue());
        //2
        System.out.println(randomQueue);
        //[Head: 0] -> [1] -> [3] -> [4] -> [Tail: 5]
        System.out.println(randomQueue.sample());
        //5
        System.out.println(randomQueue);
        //[Head: 0] -> [1] -> [3] -> [4] -> [Tail: 5]
        System.out.println(randomQueue.dequeue());
        //3
        System.out.println(randomQueue);
        //[Head: 0] -> [1] -> [4] -> [Tail: 5]
        System.out.println(randomQueue.dequeue());
        //5
        System.out.println(randomQueue);
        //[Head: 0] -> [1] -> [Tail: 4]
    }
}
