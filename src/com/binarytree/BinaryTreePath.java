package com.binarytree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(1);

        root.setLeftChild(new Node<>(2));
        root.setRightChild(new Node<>(3));
        root.getLeftChild().setRightChild(new Node<>(5));
        BinaryTreePath path = new BinaryTreePath();
        List<String> res = path.binaryTreePaths(root);
        for (String r: res
             ) {
            System.out.print(r+" ");
        }
    }


    public List<String> binaryTreePaths(Node root) {
        List<String> res = new ArrayList<>();
        if ( root == null)
            return res;

        return bst( root, new StringBuilder(), res);
    }

    private  List<String> bst( Node root, StringBuilder soFar, List<String> res){
        int size = soFar.length();
        soFar.append(root.getNode());
        if( root.getRightChild() == null && root.getLeftChild() == null)
            res.add(soFar.toString());
        soFar.append("-").append("->");
        if(root.getLeftChild() != null)
            bst(root.getLeftChild(), soFar, res);
        if( root.getRightChild() != null )
            bst( root.getRightChild(), soFar, res );
        soFar.delete(size, soFar.length());
        return res;
    }

}
