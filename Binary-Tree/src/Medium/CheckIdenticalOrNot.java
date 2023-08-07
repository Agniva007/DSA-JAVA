package Medium;

import Traversals.TreeNode;

public class CheckIdenticalOrNot {
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

        System.out.println(isSameTree(tree.root, tree.root));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null || q==null) return p==q;

        return p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
