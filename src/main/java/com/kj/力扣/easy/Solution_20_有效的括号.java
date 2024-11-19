package com.kj.力扣.easy;

import java.util.Stack;

class Solution_20_有效的括号 {
    public static void main(String[] args) {

    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ('(' == c || '[' == c || '{' == c) {
                    stack.push(c);
                }

                if (')' == c) {
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '(') return false;
                }
                if (']' == c) {
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '[') return false;
                }
                if ('}' == c) {
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '{') return false;
                }
            }

            return stack.isEmpty();
        }
    }
}