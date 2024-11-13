package com.kj.力扣.mid;

import java.util.ArrayList;
import java.util.List;

class Solution_6_Z字形变换 {
    public static void main(String[] args) {

    }

    static class Solution {
        public String convert(String s, int numRows) {
            if (numRows < 2) return s;

            List<StringBuilder> list = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                list.add(new StringBuilder());
            }

            int i = 0;
            int flag = -1;
            for (int j = 0; j < s.length(); j++) {
                list.get(i).append(s.charAt(j));
                if (i == 0 || i == numRows - 1) flag = -flag;
                i += flag;
            }

            StringBuilder res = new StringBuilder();
            for (StringBuilder builder : list) {
                res.append(builder);
            }

            return res.toString();
        }
    }
}