package Medium;

import Traversals.TreeNode;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
//        tree.root.right.left = new TreeNode(9);
//        tree.root.right.right = new TreeNode(10);
//        tree.root.left.left.right = new TreeNode(5);
        int[] diameter = new int[1];
        diameter(tree.root, diameter);
        System.out.println(diameter[0]);
    }

    public static int diameter(TreeNode root, int[] diameter){
        if(root==null) return 0;

        int left = diameter(root.left, diameter);
        int right = diameter(root.right, diameter);

        diameter[0] = Math.max(diameter[0], left+right);

        return 1+Math.max(left, right);
    }
}
