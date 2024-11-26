package com.kj.力扣.easy;

class Solution_226_翻转二叉树 {
    public static void main(String[] args) {

    }

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return root;
            }

            // 下一步操作会对左子树进行更新，所以保存一份副本
            TreeNode tmpLeft = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(tmpLeft);

            return root;
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