package com.kj.力扣.easy;

class Solution_LCR_181_单词反转 {
    public static void main(String[] args) {
        String message = "the sky is blue";

        String rs = new Solution_LCR_181_单词反转().reverseMessage(message);

        System.out.println(rs);
    }

    public String reverseMessage(String message) {
        if (message.isEmpty()) {
            return "";
        }

        char[] chars = message.toCharArray();

        int cur = 0;

        boolean flag = true;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[cur++] = chars[i];
                flag = false;
            } else if (flag == false) {
                chars[cur++] = ' ';
                flag = true;
            }
        }

        int count = flag ? cur - 1 : cur;

        if (count < 1) {
            return "";
        }

        int pre = 0;
        for (int i = 0; i < count; i++) {
            if (chars[i] != ' ') {
                continue;
            }
            reverseWord(chars, pre, i - 1);
            pre = i + 1;
        }

        reverseWord(chars, pre, count - 1);

        return new String(chars, 0, count);
    }

    private void reverseWord(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[right];
            chars[right] = chars[left];
            chars[left] = tmp;
            right--;
            left++;
        }
    }
}