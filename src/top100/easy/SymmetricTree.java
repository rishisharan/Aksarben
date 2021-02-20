package top100.easy;

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return false;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode( 1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTree tree = new SymmetricTree();
        System.out.println(tree.isSymmetric(root));
    }
}
