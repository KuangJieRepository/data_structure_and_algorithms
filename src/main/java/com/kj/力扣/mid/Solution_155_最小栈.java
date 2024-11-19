package com.kj.力扣.mid;

import java.util.Stack;

class Solution_155_最小栈 {
    public static void main(String[] args) {

    }

    static class MinStack {
        Stack<Integer> stack;
        Stack<Integer> min;

        public MinStack() {
            stack = new Stack<>();
            min = new Stack<>();
        }

        public void push(int val) {
            if (min.isEmpty()) {
                min.push(val);
            } else {
                min.push(Math.min(min.peek(), val));
            }
            stack.push(val);
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}