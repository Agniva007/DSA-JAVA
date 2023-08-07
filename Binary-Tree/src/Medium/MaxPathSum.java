package Medium;

import Traversals.TreeNode;

public class MaxPathSum {

    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.root = new TreeNode(-10);
        tree.root.left = new TreeNode(9);
        tree.root.right = new TreeNode(20);
//        tree.root.left.left = new TreeNode(4);
//        tree.root.left.right = new TreeNode(10);
        tree.root.right.left = new TreeNode(15);
        tree.root.right.right = new TreeNode(7);
//        tree.root.left.left.right = new TreeNode(5);

        maxSum(tree.root);
        System.out.println(max);
    }

    public static int maxSum(TreeNode root){
        if(root==null) return 0;

        int left = Math.max(0, maxSum(root.left));
        int right = Math.max(0, maxSum(root.right));

        int sum = left + right + root.val;

        max = Math.max(max, sum);

        return Math.max(left, right)+root.val;
    }
}
