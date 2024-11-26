package com.kj.力扣.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution_100_相同的树 {
    public static void main(String[] args) {

    }

    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            List<Integer> pList = new ArrayList<>();
            midSort(p, pList);
            List<Integer> qList = new ArrayList<>();
            midSort(q, qList);

            return Objects.equals(pList, qList);
        }

        /**
         * 中序遍历
         */
        private void midSort(TreeNode node, List<Integer> list) {
            if (node == null) {
                list.add(null);
                return;
            }
            list.add(node.val);
            midSort(node.left, list);
            midSort(node.right, list);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}