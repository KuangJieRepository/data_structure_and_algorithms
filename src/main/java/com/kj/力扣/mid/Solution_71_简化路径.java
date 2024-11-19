package com.kj.力扣.mid;

import java.util.Stack;

class Solution_71_简化路径 {
    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/../"));
    }

    static class Solution {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();

            stack.push("/");

            for (String p : path.split("/")) {
                if ("".equals(p) || ".".equals(p)) continue;
                if ("..".equals(p)) {
                    if (stack.size() != 1) {
                        stack.pop();
                        stack.pop();
                    }
                    continue;
                }
                stack.push(p);
                stack.push("/");
            }

            if (stack.size() > 1 && "/".equals(stack.peek())) stack.pop();

            StringBuilder sb = new StringBuilder();

            for (String string : stack) {
                sb.append(string);
            }

            return sb.toString();
        }
    }
}