package com.kj.力扣.mid;

import java.util.Stack;

class Solution_150_逆波兰表达式求值 {
    public static void main(String[] args) {

    }

    static class Solution {
        Stack<Integer> stack = new Stack<>();

        public int evalRPN(String[] tokens) {
            for (String token : tokens) {
                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    int calc = calc(a, b, token);
                    stack.push(calc);
                } else {
                    stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
        }

        private int calc(int a, int b, String operator) {
            switch (operator) {
                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "*":
                    return a * b;
                case "/":
                    return a / b;
                default:
                    return 0;
            }
        }
    }
}