package com.kj.力扣.easy;

class Solution_13_罗马数字转整数 {
    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("LVIII"));
    }

    static class Solution {

        public int romanToInt(String s) {
            char[] chars = s.toCharArray();

            int ans = 0;

            for (int i = 0; i < chars.length - 1; i++) {

                if (getValue(chars[i]) < getValue(chars[i + 1])) {
                    ans -= getValue(chars[i]);
                } else {
                    ans += getValue(chars[i]);
                }
            }

            ans += getValue(chars[chars.length - 1]);

            return ans;
        }

        private int getValue(char ch) {
            switch (ch) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    return 0;
            }
        }
    }
}