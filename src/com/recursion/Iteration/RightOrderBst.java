package com.recursion.Iteration;

public class RightOrderBst {
    public static void main(String[] args) {
        RightOrderBst bst = new RightOrderBst();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(18);
        TreeNode res = bst.increasingBST(root);
        while ( res != null){
            System.out.println(res.val);
            res = res.right;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = new TreeNode();
        if( root == null){
            return head;
        }
        performDfs(root, head, root.val);
        return head.right;
    }

    void performDfs(TreeNode root, TreeNode head, int val){
        if( root == null ){
            if( head == null )
                head = new TreeNode(val);
            else
                head.right = new TreeNode(val);
            return;
        }
        performDfs(root.left, head, root.val);
        performDfs(root.right, head,root.val);

    }
}
