package com.kj.题;

/**
 * 单词单词反转
 * 输入：  are  you  ok
 * 输出：ok you are
 * 前后不能有空格，中间只保留一个空格
 *
 * 核心在于：空格的去除
 * 然后进行逆序，在用空格为分割，在次逆序
 *
 * @author kj
 * @date 2024/10/29
 */
public class ReverseWord_单词反转 {

    public static String reverse(String input) {
        input = trimSpace(input);

        return input;
    }

    /**
     * 去除空格
     */
    private static String trimSpace(String input) {
        char[] chars = input.toCharArray();

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

        // 去除空格后进行逆序
        reversedWord(chars, 0, count - 1);

        // 空格为分割，在进行逆序
        int preLeft = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                continue;
            }
            reversedWord(chars, preLeft, i - 1);
            preLeft = i + 1;
        }
        // 末尾没有空格，需要对最后一个单词进行逆序处理
        reversedWord(chars, preLeft, count - 1);

        return new String(chars, 0, count);
    }

    /**
     * 逆序
     * [1,2,3] -->  [3,2,1]
     *
     * @param chars source
     * @param left 左指针
     * @param right 右指针
     */
    private static void reversedWord(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[right];
            chars[right] = chars[left];
            chars[left] = tmp;
            left++;
            right--;
        }
    }
}
