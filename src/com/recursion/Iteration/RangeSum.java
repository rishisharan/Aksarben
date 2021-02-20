package com.recursion.Iteration;

public class RangeSum {

    static int res = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        RangeSum rangeSum = new RangeSum();

        rangeSum.rangeSumBST(root, 7, 15);
        System.out.println(res);
    }


    public void rangeSumBST(TreeNode root, int low, int high){
        if( root == null)
            return;
        if( root.val >= low && root.val <= high ) {
            res += root.val;

        }

        rangeSumBST(root.left, low, high);
        rangeSumBST(root.right, low, high);

    }
}
