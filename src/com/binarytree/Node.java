package com.binarytree;

public  class Node<T> {

    private T Node;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T node) {
        Node = node;
    }

    public T getNode() {
        return Node;
    }

    public void setNode(T node) {
        Node = node;
    }

    public com.binarytree.Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(com.binarytree.Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public com.binarytree.Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(com.binarytree.Node<T> rightChild) {
        this.rightChild = rightChild;
    }




}
