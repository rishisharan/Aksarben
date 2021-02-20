package com.binarytree;



public class MinimumValue {
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



        MinimumValue minimumValue = new MinimumValue();
        System.out.println(minimumValue.findMinimum(root).getNode());
    }

    public Node findMinimum( Node root){

        if( root == null){
            return root;
        }

        if( root.getLeftChild() == null)
            return root;
        return findMinimum(root.getLeftChild());

    }
}
