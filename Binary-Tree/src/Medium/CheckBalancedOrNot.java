package Medium;

import Traversals.TreeNode;

public class CheckBalancedOrNot {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(10);
        tree.root.right.left = new TreeNode(9);
        tree.root.right.right = new TreeNode(10);
        tree.root.left.left.right = new TreeNode(5);

        System.out.println(isBalanced(tree.root));
    }

    public static boolean isBalanced(TreeNode root){
        return dfs(root)!=-1;
    }

    public static int dfs(TreeNode root){
        if(root==null) return 0;

        int lh = dfs(root.left);
        if(lh==-1) return -1;

        int rh = dfs(root.right);
        if(rh==-1) return -1;

        if(Math.abs(lh-rh)>1) return -1;

        return 1+Math.max(lh, rh);
    }
}
