package assignments;

import dataStructures.Node;

import java.util.Random;

public class ShufflingLinkedList {
    static Random random = new Random();

    public static void main(String[] args) {
        var node = new Node<>(1);
        var node1 = new Node<>(5);
        var node2 = new Node<>(4);
        var node3 = new Node<>(6);
        var node4 = new Node<>(2);
        var node5 = new Node<>(3);
        Node head = new Node<>(9);
        head.setNext(node);
        node.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        System.out.println(shuffle(head, 7));
    }

    private static Node shuffle(Node head, int N) {
        if (N == 1) {
            return head;
        }

        int mid = N/2;
        int k = 1;
        var leftNode = head;
        while (k < mid) {
            leftNode = leftNode.getNext();
            k++;
        }

        var rightNode = leftNode.getNext();
        leftNode.setNext(null);
        var left = shuffle(head, N/2);
        var right = shuffle(rightNode, N- mid);

        return merge(left, right);
    }

    private static Node merge(Node left, Node right) {
        Node aux = new Node();
        Node l = left;
        Node r = right;
        Node current = aux;
        while (l != null && r != null) {
            if (random.nextInt(10) % 2 == 0) {
                current.setNext(l);
                l = l.getNext();
            } else {
                current.setNext(r);
                r = r.getNext();
            }
            current = current.getNext();
        }
        if (l != null) {
            current.setNext(l);
        } else if (r != null) {
            current.setNext(r);
        }
        return aux.getNext();
    }


}
