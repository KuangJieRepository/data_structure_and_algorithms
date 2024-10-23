package com.kj.树;

/**
 * 树实现
 *
 * @author kj
 * @date 2024/10/16
 */
public class BinaryTree<K extends Comparable<K>, V> {
    /**
     * 根节点
     */
    private Node root;
    /**
     * 节点数量
     */
    private int size;

    /**
     * 创建BinaryTree对象
     */
    public BinaryTree() {
        size = 0;
    }

    /**
     * 向树中插入一个键值对
     *
     * @param key k
     * @param value v
     */
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    /**
     * 给指定树x上,添加键一个键值对,并返回添加后的新树
     *
     * @param x node
     * @param key k
     * @param val v
     * @return node
     */
    private Node put(Node x, K key, V val) {
        if (x == null) {
            size++;
            return new Node(key, val, null, null);
        }

        int compare = key.compareTo(x.key);
        if (compare < 0) {
            x.left = put(x.left, key, val);
        } else if (compare > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.value = val;
        }

        return x;
    }

    /**
     * 根据key,从树中找出对应的值
     *
     * @param key k
     * @return v
     */
    public V get(K key) {
        return get(root, key);
    }

    /**
     * 从指定的树x中,找出key对应的值
     *
     * @param x node
     * @param key k
     * @return v
     */
    private V get(Node x, K key) {
        if (x == null) {
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            return get(x.left, key);
        } else if (compare > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    /**
     * 根据key,删除树中对应的键值对
     *
     * @param key k
     */
    public void delete(K key) {
        root = delete(root, key);
    }

    /**
     * 删除指定树x上的键为key的键值对,并返回删除后的新树
     *
     * @param x node
     * @param key k
     * @return node
     */
    private Node delete(Node x, K key) {
        if (x == null) {
            return null;
        }

        int compare = key.compareTo(x.key);
        if (compare < 0) {
            x.left = delete(x.left, key);
        } else if (compare > 0) {
            x.right = delete(x.right, key);
        } else {
            size--;
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }

            // 寻找右子树下的最小节点
            Node min = x.right;
            if (min.left == null) {
                // 没有左子树
                min.left = x.left;
            } else {
                Node minParent = x.right;
                while (min.left != null) {
                    // 将最小节点的父节点的 left = null;
                    if (min.left.left == null) {
                        minParent = min;
                    }
                    min = min.left;
                }

                minParent.left = null;

                min.left = x.left;
                min.right = x.right;
            }

            // 回到上一层，父节点会指向新的节点，而这个将被删除的 x 节点，没有对象指向它，便会被回收
            x = min;
        }

        return x;
    }

    /**
     * 获取树中元素的个数
     *
     * @return size
     */
    public int size() {
        return size;
    }

    public K getMinKey() {
        Node node = root;

        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }

        return node.key;
    }

    public K getMaxKey() {
        Node node = root;

        if (node == null) {
            return null;
        }

        while (node.right != null) {
            node = node.right;
        }

        return node.key;
    }

    public void preOrder() {
        if (root == null) {
            return;
        }
        root.preOrder();
    }

    public void midOrder() {
        if (root == null) {
            return;
        }
        root.midOrder();
    }

    public void suffixOrder() {
        if (root == null) {
            return;
        }
        root.suffixOrder();
    }

    /**
     * 内部类 Node，用于表示二叉树中的节点
     */
    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        /**
         * 先序遍历
         */
        public void preOrder() {
            System.out.println(this);

            if (this.left != null) {
                this.left.preOrder();
            }

            if (this.right != null) {
                this.right.preOrder();
            }
        }

        /**
         * 中序遍历
         */
        public void midOrder() {
            if (this.left != null) {
                this.left.midOrder();
            }

            System.out.println(this);

            if (this.right != null) {
                this.right.midOrder();
            }
        }

        /**
         * 后序遍历
         */
        public void suffixOrder() {
            if (this.left != null) {
                this.left.suffixOrder();
            }

            if (this.right != null) {
                this.right.suffixOrder();
            }

            System.out.println(this);
        }
    }
}