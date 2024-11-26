package com.kj.力扣.easy;

class Solution_101_对称二叉树 {
    public static void main(String[] args) {

    }

    /**
     * 中序遍历
     */
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;

            return circle(root.left, root.right);
        }

        private boolean circle(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;

            if (left == null || right == null) return false;

            if (left.val != right.val) return false;

            // 两边需要同时判断
            return circle(left.left, right.right) && circle(left.right, right.left);
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