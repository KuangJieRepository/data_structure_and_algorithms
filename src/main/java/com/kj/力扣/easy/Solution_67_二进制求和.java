package com.kj.力扣.easy;

class Solution_67_二进制求和 {
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "1"));
    }

    static class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();

            int i = a.length() - 1;
            int j = b.length() - 1;

            // 进位
            int carry = 0;
            while (i >= 0 || j >= 0 || carry > 0) {
                int vi = 0;
                int vj = 0;
                if (i >= 0) {
                    vi = Integer.parseInt(a.charAt(i) + "");
                    i--;
                }
                if (j >= 0) {
                    vj = Integer.parseInt(b.charAt(j) + "");
                    j--;
                }

                int sum = vi + vj + carry;

                int newVal = sum % 2;
                sb.append(newVal);

                carry = sum / 2;
            }

            return sb.reverse().toString();
        }
    }
}