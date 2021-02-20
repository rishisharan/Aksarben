package com.binarytree;

public class MaximumDepth {
    public static void main(String[] args) {
        Node root = new Node(9);
        Node node1 = new Node(7);
        root.setRightChild(node1);
        Node node2 = new Node(5);

        node1.setLeftChild(node2);
        node1.setRightChild(new Node(6));

        Node node4 = new Node(4);
        root.setLeftChild(node4);
        Node node5 = new Node(2);
        node4.setLeftChild(node5);
        Node node6 = new Node(3);
        node4.setRightChild(node6);
        Node node7 = new Node(1);
        node5.setLeftChild(node7);

        MaximumDepth depth = new MaximumDepth();
        System.out.println(depth.findMaximumDepth(root));
    }

    public int findMaximumDepth( Node root){
        if( root == null){
            return 0;
        }

        if( root.getLeftChild() == null && root.getLeftChild() == null)
            return 0;
        int leftDepth = 1 + findMaximumDepth(root.getLeftChild());
        int rightDepth = 1 + findMaximumDepth(root.getRightChild());

        return Math.max(leftDepth,rightDepth);
    }
}
