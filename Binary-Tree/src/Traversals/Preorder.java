package Traversals;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Preorder {
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
        System.out.println(iterative(tree.root));
        System.out.println(rec(tree.root));
    }

    public static List<Integer> iterative(TreeNode root){
        List<Integer> list = new ArrayList();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if(root.right != null)
                stack.add(root.right);
            if(root.left != null)
                stack.add(root.left);
        }

        return list;
    }

    public static List<Integer> rec(TreeNode root){
        List<Integer> list = new ArrayList<>();
        dfs(root, list);

        return list;
    }

    public static void dfs(TreeNode root, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
