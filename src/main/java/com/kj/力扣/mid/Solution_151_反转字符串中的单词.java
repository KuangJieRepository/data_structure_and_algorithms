package com.kj.力扣.mid;

class Solution_151_反转字符串中的单词 {
    public static void main(String[] args) {

    }

    static class Solution {
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();

            boolean flag = true;
            int cur = 0;

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != ' ') {
                    chars[cur++] = chars[i];
                    flag = false;
                } else if (flag == false) {
                    chars[cur++] = chars[i];
                    flag = true;
                }
            }

            int count = flag ? cur - 1 : cur;

            if (count < 1) return "";

            reverse(chars, 0, count - 1);

            int pre = 0;
            for (int i = 0; i < count; i++) {
                if (chars[i] != ' ') {
                    continue;
                }
                reverse(chars, pre, i - 1);
                pre = i + 1;
            }

            reverse(chars, pre, count - 1);

            return new String(chars, 0, count);
        }

        private void reverse(char[] chars, int l, int r) {
            while (l < r) {
                char tmp = chars[r];
                chars[r--] = chars[l];
                chars[l++] = tmp;
            }
        }
    }
}