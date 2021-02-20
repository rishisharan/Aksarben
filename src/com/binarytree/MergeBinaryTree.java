package com.binarytree;

public class MergeBinaryTree {
    public static void main(String[] args) {
         TreeNode root1 = new TreeNode(1);
         root1.left = new TreeNode(3);
         root1.left.left = new TreeNode(5);
         root1.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root1.right = new TreeNode(3);
        root1.right.right = new TreeNode(7);

        MergeBinaryTree mergeBinaryTree = new MergeBinaryTree();
        TreeNode result = mergeBinaryTree.mergeTrees(root1, root2);
        mergeBinaryTree.printTree(result);
    }

    public void printTree( TreeNode treeNode){
        if( treeNode == null)
            return;

        System.out.println(treeNode.val);
        printTree(treeNode.left);
        printTree(treeNode.right);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        TreeNode result = null;
        if( root1 == null && root2 == null)
            return result;

        recursiveWay(root1, root2, result);
        return result;
    }

    public void recursiveWay(TreeNode root1, TreeNode root2, TreeNode result){
        if( root1 == null || root2 == null)
            return;

        if( root1 != null && root2 != null){
            int res = root1.val + root2.val;

        }
        if( root1 == null && root2 != null )
            result = new TreeNode(root2.val);
        else if( root1 != null && root2 == null )
            result = new TreeNode(root1.val);

        recursiveWay(root1.left, root2.left, result);
        recursiveWay(root1.right, root2.right, result);
    }
}
