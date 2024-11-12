package com.kj.力扣.mid;

import java.util.LinkedHashMap;
import java.util.Map;

class Solution_12_整数转罗马数字 {
    public static void main(String[] args) {

    }

    /**
     * 建立一个更加完整的映射表
     */
    static class Solution {
        public String intToRoman(int num) {
            Map<Integer, String> map = new LinkedHashMap<>();
            map.put(1000, "M");
            map.put(900, "CM");
            map.put(500, "D");
            map.put(400, "CD");
            map.put(100, "C");
            map.put(90, "XC");
            map.put(50, "L");
            map.put(40, "XL");
            map.put(10, "X");
            map.put(9, "IX");
            map.put(5, "V");
            map.put(4, "IV");
            map.put(1, "I");

            String ans = "";

            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                while (num >= entry.getKey()) {
                    num -= entry.getKey();
                    ans += entry.getValue();
                }
            }

            return ans;
        }
    }
}