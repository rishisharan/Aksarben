package com.binarytree;

import com.queue.Queue;

import java.util.Collection;
import java.util.Iterator;

public class BFSTree {
    public static void main(String[] args) throws Queue.QueueUnderflowException, Queue.QueueOverflowException {
        Node<Integer> root = new Node<Integer>(12);

        root.setLeftChild(new Node<>(9));
        root.setRightChild(new Node<>(18));

        root.getLeftChild().setLeftChild(new Node<>(7));
        root.getLeftChild().setRightChild(new Node<>(10));

        root.getRightChild().setLeftChild(new Node<>(15));
        root.getRightChild().setRightChild(new Node<>(19));

//        root.getLeftChild().getLeftChild().getLeftChild().setLeftChild(new Node<>(4));
//        root.getLeftChild().getLeftChild().getLeftChild().setRightChild(new Node<>(6));


        root.getRightChild().getLeftChild().setLeftChild(new Node<>(14));
        root.getRightChild().getLeftChild().setRightChild(new Node<>(16));

        root.getRightChild().getRightChild().setRightChild(new Node<>(20));
        root.getRightChild().getRightChild().setLeftChild(new Node<>(18));

        BFSTree tree = new BFSTree();
        System.out.println("Breadth first search ");
        tree.breadthFirstSearch( root );
        System.out.println("\nPreorder traversal ");
        tree.preOrderTraversal( root );
        System.out.println("\nIn order traversal ");
        tree.inOrderTraversal( root );
        System.out.println("\nPost order traversal ");
        tree.postOrderTraversal( root );
        System.out.println("\nBinary search tree insertion ");
        Node nd = new Node(13);
        tree.insertInBst( root, nd );
        Node nd1 = new Node(8);
        tree.insertInBst( root, nd1  );
        System.out.println("Breadth first search after insertion.");
        tree.breadthFirstSearch( root );
        System.out.println("\nLook up for BST.");
        System.out.println(tree.lookUpInBst( root, new Node<>(100) ));
    }

    public boolean lookUpInBst(Node<Integer> root, Node<Integer> node){
        if( root == null)
            return false;
        if( root.getNode() == node.getNode())
            return true;
        else if( node.getNode() >= root.getNode())
            return lookUpInBst(root.getRightChild(),node);
        else
            return lookUpInBst(root.getLeftChild(),node);

    }

    public Node<Integer>  insertInBst(Node<Integer> root, Node<Integer> node){
        if(root == null)
            return node;

        if( node.getNode() >= root.getNode())
            root.setRightChild(insertInBst(root.getRightChild(),node));
        if( node.getNode() <= root.getNode())
            root.setLeftChild(insertInBst(root.getLeftChild(), node));

        return root;
    }

    public void postOrderTraversal( Node root ){
        if( root == null )
            return;
        if( root.getLeftChild() != null )
            postOrderTraversal(root.getLeftChild());
        if( root.getRightChild() != null)
            postOrderTraversal(root.getRightChild());
        System.out.print(root.getNode()+" ");
    }

    public void inOrderTraversal( Node root ){
        if( root == null){

            return;
        }

        if( root.getLeftChild() != null)
            inOrderTraversal(root.getLeftChild());
        System.out.print(root.getNode()+" ");
        if( root.getRightChild() != null)
            inOrderTraversal(root.getRightChild());

    }

    public void preOrderTraversal(Node root ){
        if( root == null)
            return;
        System.out.print(root.getNode()+" ");
        preOrderTraversal(root.getLeftChild());
        preOrderTraversal(root.getRightChild());
    }

    public void breadthFirstSearch( Node root ) throws Queue.QueueOverflowException, Queue.QueueUnderflowException {
        if( root == null )
            return;
        com.queue.Queue queue = new com.queue.Queue<>(Node.class);
        queue.enqueue(root);
        while (!queue.isEmpty()){
            Node node = (Node) queue.dequeue();
            System.out.print(node.getNode() + " ");
            if( node.getLeftChild() != null)
                queue.enqueue(node.getLeftChild());
            if( node.getRightChild() != null)
                queue.enqueue(node.getRightChild());
        }
    }
}
