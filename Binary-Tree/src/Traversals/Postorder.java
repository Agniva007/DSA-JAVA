package Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Postorder {
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

    public static List<Integer> iterative(TreeNode root) {
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode temp = stack.peek().right;
                if(temp == null) {
                    temp = stack.pop();
                    list.add(temp.val);
                    while(!stack.isEmpty() && temp ==  stack.peek().right) {
                        temp = stack.pop();
                        list.add(temp.val);
                    }
                } else {
                    root = temp;
                }
            }
        }

        return list;
    }

    public static List<Integer> rec(TreeNode root){
        List<Integer> list = new ArrayList<>();
        dfs(root, list);

        return list;
    }

    public static void dfs(TreeNode root, List<Integer> list){
        if(root==null) return;

        dfs(root.left, list);
        dfs(root.right, list);
        list.add(root.val);
    }
}
