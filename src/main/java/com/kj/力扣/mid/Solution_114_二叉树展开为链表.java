package com.kj.力扣.mid;

import java.util.ArrayList;
import java.util.List;

class Solution_114_二叉树展开为链表 {
    public static void main(String[] args) {

    }

    static class Solution {
        public void flatten(TreeNode root) {
            if (root == null) return;

            List<TreeNode> list = new ArrayList<>();

            dfs(root, list);

            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).left = null;
                list.get(i).right = list.get(i + 1);
            }

            list.get(list.size() - 1).left = null;
        }

        private void dfs(TreeNode node, List<TreeNode> list) {
            if (node == null) return;
            list.add(node);
            dfs(node.left, list);
            dfs(node.right, list);
        }
    }

    static public class TreeNode {
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