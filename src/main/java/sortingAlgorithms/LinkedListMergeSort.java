package sortingAlgorithms;


import dataStructures.LinkedList;
import dataStructures.Node;

public class LinkedListMergeSort {

    public static void main(String[] args) {
        var linkedList = new LinkedList();
        var node = new Node<>(6);
        linkedList.setHead(node);
        linkedList.append(5);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(2);
        linkedList.append(1);
        linkedList.append(0);
        System.out.println(linkedList);
        //[Head: 6] -> [5] -> [4] -> [3] -> [2] -> [1] -> [Tail: 0]

        System.out.println(mergeSort(linkedList));
        //[Head: 0] -> [1] -> [2] -> [3] -> [4] -> [5] -> [Tail: 6]
    }

    // O(kn log n)
    public static LinkedList mergeSort(LinkedList linkedList) {
        if (linkedList.size() == 1) {
            return linkedList;
        } else if (linkedList.getHead() == null) {
            return linkedList;
        }

        var leftList = new LinkedList();
        var rightList = new LinkedList();
        //O(klogn)
        if (linkedList == null || linkedList.getHead() == null) {
            leftList = linkedList;
            rightList = null;
        } else {
            var size = linkedList.size();
            var mid = size/2;
            var midNode = linkedList.atIndex(mid-1);
            leftList = linkedList;
            rightList = new LinkedList();
            rightList.setHead(midNode.getNext());
            midNode.setNext(null);
        }

        var left = mergeSort(leftList);
        var right = mergeSort(rightList);
        return merge(left, right);
    }

    private static LinkedList merge(LinkedList left, LinkedList right) {
        var mergedList = new LinkedList();
        var node = new Node<>(0);
        mergedList.setHead(node);

        //O(n)
        var current = mergedList.getHead();

        var leftHead = left.getHead();
        var rightHead = right.getHead();

        while (leftHead != null || rightHead != null) {
            if (leftHead == null) {
                current.setNext(rightHead);
                rightHead = rightHead.getNext();
            } else if (rightHead == null) {
                current.setNext(leftHead);
                leftHead = leftHead.getNext();
            } else {
                var leftData = (int)leftHead.getData();
                var rightData = (int)rightHead.getData();
                if (leftData < rightData) {
                    current.setNext(leftHead);
                    leftHead = leftHead.getNext();
                } else {
                    current.setNext(rightHead);
                    rightHead = rightHead.getNext();
                }
            }
            current = current.getNext();
        }
        var head = mergedList.getHead().getNext();
        mergedList.setHead(head);
        return mergedList;
    }
}
