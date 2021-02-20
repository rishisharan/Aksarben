package com.recursion.Iteration;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(6);
        stack.push(9);
        ReverseStack reverseStack = new ReverseStack();
        reverseStack.reverse(stack);
    }

    public void reverse(Stack<Integer> stack){
        if( stack.isEmpty())
            return;
        reverse(stack);
    }
}
