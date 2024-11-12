package com.kj.力扣.mid;

import java.util.*;

class Solution_380_O1时间插入删除和获取随机元素 {
    public static void main(String[] args) {
        RandomizedSet2 set = new RandomizedSet2();
        set.insert(0);
        set.insert(1);
        set.remove(0);
        set.insert(2);
        set.remove(1);

        System.out.println(set.getRandom());
    }

    static class RandomizedSet {

        private Map<Integer, Integer> map;

        public RandomizedSet() {
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }

            map.put(val, val);
            return true;
        }

        public boolean remove(int val) {
            return map.remove(val, val);
        }

        public int getRandom() {
            Integer[] array = map.values().toArray(new Integer[0]);

            if (array.length == 1) {
                return array[0];
            }

            Random random = new Random();
            return array[random.nextInt(array.length)];
        }
    }

    static class RandomizedSet2 {

        private Map<Integer, Integer> map;
        private List<Integer> list;
        private Integer idx = -1;
        Random random = new Random();

        public RandomizedSet2() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }

            list.add(val);
            idx++;
            map.put(val, idx);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            Integer i = map.get(val);
            map.remove(val);
            list.remove(i);
            idx--;
            return true;
        }

        public int getRandom() {
            if (list.size() <= 1) {
                return list.get(0);
            }

            return list.get(random.nextInt(list.size()));
        }
    }
}