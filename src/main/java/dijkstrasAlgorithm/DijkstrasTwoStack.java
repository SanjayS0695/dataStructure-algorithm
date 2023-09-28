package dijkstrasAlgorithm;

import dataStructures.StackWithLinkedList;

public class DijkstrasTwoStack {

    public static void main (String[] args) {
        var algorithm = new TwoStackAlgo();
        System.out.println(algorithm.evaluate("(1+((2+3)*(4*5)))"));
        //101
    }

    public static class TwoStackAlgo {
        private StackWithLinkedList.Stack valueStack = new StackWithLinkedList.Stack();
        private StackWithLinkedList.Stack opStack = new StackWithLinkedList.Stack();

        private Double evaluate(String expression) {
            for (int i=0; i< expression.length(); i++) {
                if (expression.charAt(i) == '(') {
                    continue;
                } else if (expression.charAt(i) == '+') {
                    opStack.push(expression.charAt(i));
                } else if (expression.charAt(i) == '-') {
                    opStack.push(expression.charAt(i));
                } else if (expression.charAt(i) == '*') {
                    opStack.push(expression.charAt(i));
                } else if (expression.charAt(i) == '/') {
                    opStack.push(expression.charAt(i));
                } else if (expression.charAt(i) == ')') {
                    char operator = (char)opStack.pop();
                    if (operator == '+') {
                        valueStack.push((Double)valueStack.pop() + (Double)valueStack.pop());
                    } else if (operator == '-'){
                        valueStack.push((Double)valueStack.pop() - (Double)valueStack.pop());
                    } else if (operator == '*'){
                        valueStack.push((Double)valueStack.pop() * (Double)valueStack.pop());
                    } else if (operator == '/'){
                        valueStack.push((Double)valueStack.pop() / (Double)valueStack.pop());
                    }
                } else {
                    valueStack.push(Double.parseDouble(String.valueOf(expression.charAt(i))));
                }
            }
            return (Double) valueStack.pop();
        }
    }
}
