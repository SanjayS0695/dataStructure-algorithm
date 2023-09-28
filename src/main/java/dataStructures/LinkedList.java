package dataStructures;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    // O(n)
    public int size() {
        var current = this.head;
        var size = 0;
        while (current != null) {
            size += 1;
            current = current.getNext();
        }
        return size;
    }

    //O(1)
    public <T> void prepend(T data) {
        var newNode = new Node<>(data);

        newNode.setNext(this.head);
        this.head = newNode;
    }

    //O(n)
    public <T> void append(T data) {
        var newNode = new Node<>(data);

        var current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    //O(n)
    public <T> void insert(T data, int index) {
        var newNode = new Node<>(data);
        var position = index;
        var current = this.head;

        if (index == 0) {
            //O(1)
            this.prepend(data);
        } else if (index > this.size()) {
            System.out.println(String.format("IndexOutOfBound Error: index %s not found", index));
        }
        else if (index == this.size()) {
            //O(n)
            this.append(data);
        } else {
            //O(n)
            while (position > 1) {
                current = current.getNext();
                position -= 1;
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    //O(n)
    public <T> Node remove(T data) {
        var current = this.head;
        var found = false;
        var prev = new Node<>(null);
        while (current != null && !found) {
            if (current.getData().equals(data) && current == this.head) {
                found = true;
                this.head = current.getNext();
            } else if (current.getData().equals(data)){
                found = true;
                prev.setNext(current.getNext());
            } else {
                prev = current;
                current = current.getNext();
            }
        }
        if (!found) {
            System.out.println(String.format("%s not found in the list", data));
        }
        return current;
    }

    //O(n)
    public <T> Integer search(T data) {
        var current = this.head;
        var position = 0;
        while(current != null) {
            if (current.getData().equals(data)) {
                return position;
            } else {
                current = current.getNext();
                position += 1;
            }
        }
        return null;
    }

    public Node atIndex(int index) {
        if (index == 0) {
            return this.head;
        } else {
            var current = this.head;
            var position = 0;
            while (position < index) {
                current = current.getNext();
                position += 1;
            }
            return current;
        }
    }

    //O(n)
    @Override
    public String toString() {
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

    public static void main (String[] args) {
        var linkedList = new LinkedList();
        System.out.println(linkedList.isEmpty());
        //true
        var node = new Node<>(1);
        var node1 = new Node<>(2);
        var node2 = new Node<>(3);
        node1.setNext(node2);
        node.setNext(node1);
        linkedList.setHead(node);
        System.out.println(linkedList);
        //[Head: 1] -> [2] -> [Tail: 3]
        System.out.println(linkedList.size());
        //3
        System.out.println(linkedList.isEmpty());
        //false

        linkedList.prepend(0);
        System.out.println(linkedList);
        //[Head: 0] -> [1] -> [2] -> [Tail: 3]

        linkedList.prepend(-1);
        System.out.println(linkedList);
        //[Head: -1] -> [0] -> [1] -> [2] -> [Tail: 3]

        linkedList.append(4);
        System.out.println(linkedList);
        //[Head: -1] -> [0] -> [1] -> [2] -> [3] -> [Tail: 4]

        linkedList.append(5);
        System.out.println(linkedList);
        //[Head: -1] -> [0] -> [1] -> [2] -> [3] -> [4] -> [Tail: 5]

        linkedList.insert(1.5, 3);
        System.out.println(linkedList);
        //[Head: -1] -> [0] -> [1] -> [1.5] -> [2] -> [3] -> [4] -> [Tail: 5]

        linkedList.insert(0.5, 2);
        System.out.println(linkedList);
        //[Head: -1] -> [0] -> [0.5] -> [1] -> [1.5] -> [2] -> [3] -> [4] -> [Tail: 5]

        linkedList.insert(-0.5, 1);
        System.out.println(linkedList);
        //[Head: -1] -> [-0.5] -> [0] -> [0.5] -> [1] -> [1.5] -> [2] -> [3] -> [4] -> [Tail: 5]

        linkedList.insert(9, 10);
        System.out.println(linkedList);
        //[Head: -1] -> [-0.5] -> [0] -> [0.5] -> [1] -> [1.5] -> [2] -> [3] -> [4] -> [5] -> [Tail: 9]

        linkedList.append(10);
        System.out.println(linkedList.size());
        //12

        linkedList.insert(9, 12);
        System.out.println(linkedList);
        //[Head: -1] -> [-0.5] -> [0] -> [0.5] -> [1] -> [1.5] -> [2] -> [3] -> [4] -> [5] -> [9] -> [10] -> [Tail: 9]

        System.out.println(linkedList.search(0.5));
        //3

        System.out.println(linkedList.search(-1));
        //0

        System.out.println(linkedList.search(10));
        //11

        System.out.println(linkedList.size());
        //13

        linkedList.remove(-1);
        System.out.println(linkedList);
        //[Head: -0.5] -> [0] -> [0.5] -> [1] -> [1.5] -> [2] -> [3] -> [4] -> [5] -> [9] -> [10] -> [Tail: 9]

        linkedList.remove(1.5);
        System.out.println(linkedList);
        //[Head: -0.5] -> [0] -> [0.5] -> [1] -> [2] -> [3] -> [4] -> [5] -> [9] -> [10] -> [Tail: 9]

        linkedList.remove(9);
        System.out.println(linkedList);
        //[Head: -0.5] -> [0] -> [0.5] -> [1] -> [2] -> [3] -> [4] -> [5] -> [10] -> [Tail: 9]

        linkedList.remove(9);
        System.out.println(linkedList);
        //[Head: -0.5] -> [0] -> [0.5] -> [1] -> [2] -> [3] -> [4] -> [5] -> [Tail: 10]

        linkedList.remove(11);
        //11 not found in the list

        linkedList.append("Sanjay");
        System.out.println(linkedList);
        //[Head: -0.5] -> [0] -> [0.5] -> [1] -> [2] -> [3] -> [4] -> [5] -> [10] -> [Tail: Sanjay]

        linkedList.append("Suresh");
        System.out.println(linkedList.remove("Sanjay"));
        //Node{data=Sanjay, next=Node{data=Suresh, next=null}}
        System.out.println(linkedList);
        //[Head: -0.5] -> [0] -> [0.5] -> [1] -> [2] -> [3] -> [4] -> [5] -> [10] -> [Tail: Suresh]
    }
}
