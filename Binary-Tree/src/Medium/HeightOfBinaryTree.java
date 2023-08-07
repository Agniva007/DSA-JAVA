package Medium;

import Traversals.TreeNode;

public class HeightOfBinaryTree {
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

        System.out.println(height(tree.root));
    }

    public static int height(TreeNode root){
        if(root==null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        return 1+Math.max(left, right);
    }
}
