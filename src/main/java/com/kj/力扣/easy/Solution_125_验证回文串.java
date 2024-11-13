package com.kj.力扣.easy;

class Solution_125_验证回文串 {
    public static void main(String[] args) {

    }

    static class Solution {
        public boolean isPalindrome(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'A' && c <= 'Z') sb.append(Character.toLowerCase(c));
                if (c >= 'a' && c <= 'z') sb.append(Character.toLowerCase(c));
                if (c >= '0' && c <= '9') sb.append(Character.toLowerCase(c));
            }

            String clean = sb.toString();

            String reverse = sb.reverse().toString();

            return clean.equals(reverse);
        }
    }
}