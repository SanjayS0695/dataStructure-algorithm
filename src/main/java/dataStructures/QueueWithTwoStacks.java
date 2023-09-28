package dataStructures;

public class QueueWithTwoStacks {

    public static void main(String[] args) {
        var queue = new Queue();
        System.out.println(queue.stackOne);
        //[]
        System.out.println(queue.stackTwo);
        //[]
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.stackOne);
        //[Head: 5] -> [4] -> [3] -> [2] -> [1] -> [Tail: 0]
        System.out.println(queue.stackTwo);
        //[]
        System.out.println(queue.dequeue());
        //0
        System.out.println(queue.stackOne);
        //[]
        System.out.println(queue.stackTwo);
        //[Head: 1] -> [2] -> [3] -> [4] -> [Tail: 5]
        System.out.println(queue.dequeue());
        //1
        System.out.println(queue.stackOne);
        //[]
        System.out.println(queue.stackTwo);
        //[Head: 2] -> [3] -> [4] -> [Tail: 5]
        queue.enqueue(10);
        System.out.println(queue.stackOne);
        //[Head: 10]
        System.out.println(queue.stackTwo);
        //[Head: 2] -> [3] -> [4] -> [Tail: 5]
        System.out.println(queue.dequeue());
        //2
        System.out.println(queue.stackOne);
        //[Head: 10]
        System.out.println(queue.stackTwo);
        //[Head: 3] -> [4] -> [Tail: 5]
        System.out.println(queue.dequeue());
        //3
        System.out.println(queue.dequeue());
        //4
        System.out.println(queue.dequeue());
        //5
        System.out.println(queue.stackOne);
        //[Head: 10]
        System.out.println(queue.stackTwo);
        //0
        System.out.println(queue.dequeue());
        //10
        System.out.println(queue.stackOne);
        //[]
        System.out.println(queue.stackTwo);
        //[]
    }

    public static class Queue {
        private StackWithLinkedList.Stack stackOne = new StackWithLinkedList.Stack();
        private StackWithLinkedList.Stack stackTwo = new StackWithLinkedList.Stack();

        private void enqueue(int value) {
            stackOne.push(value);
        }

        private int dequeue() {
            if (stackOne.isEmpty() && stackTwo.isEmpty()) {
                return -1;
            } else {
                if (stackTwo.isEmpty()) {
                    while(!stackOne.isEmpty()) {
                        stackTwo.push(stackOne.pop());
                    }
                }
            }
            return (int)stackTwo.pop();
        }
    }
}
