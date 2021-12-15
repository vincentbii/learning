package io.bii.geeks.Trees;

class Node {
    int key;
    Node left, right;

    public Node(int key) {
        this.key = key;
        left = right = null;
    }
}

public class BinaryTree {
    private static boolean l = false;
    private static boolean r = false;

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int lca = LCA(root, 4, 1).key;
        System.out.println(lca);
        System.out.println(l && r);
//        System.out.println(LCA(root, 2, 3).key);
    }

    private static Node LCA(Node node, int i, int j) {

        if (node == null) return null;

        Node temp = null;

        if (node.key == i) {
            temp = node;
            l = true;
        }

        if (node.key == j) {
            temp = node;
            r = true;
        }

        Node left = LCA(node.left, i, j);
        Node right = LCA(node.right, i, j);

        if (temp != null) return temp;

        if (left != null && right != null) return node;

        if (left == null) return right;
        else return left;
    }
}
