package dataStructures;

public class PriorityQueue {

    public static void main(String[] args) {
        PQBinaryHeapMax<Character> pq = new PQBinaryHeapMax<Character>(7);
        pq.insert('A');
        pq.insert('B');
        pq.insert('C');
        pq.insert('H');
        pq.insert('S');
        pq.insert('J');
        System.out.println(pq);
        pq.delMax();
    }
}
