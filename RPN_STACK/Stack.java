package pl.michalbidzinski;

import java.util.EmptyStackException;

public class Stack {
    private  int[] stackElements;
    private int top;


    public Stack(int s) {
        stackElements = new int[s];
        top = -1;
    }
    public void expandStack() {
        int[] expandedElements = new int[stackElements.length * 2];
        System.arraycopy(stackElements, 0, expandedElements, 0, stackElements.length);
        stackElements = expandedElements;
    }
    public void push(int element) {
        if (isFull()) {
            expandStack();
        }
        stackElements[++top] = element;
    }
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();

        }
        return stackElements[top--];
    }
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackElements[top];
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == stackElements.length - 1 ;
    }


    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(50);
        stack.push(50);


        System.out.println(stack.pop());
        System.out.println(stack.peek());


    }

}