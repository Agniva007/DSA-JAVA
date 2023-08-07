package Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
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

        System.out.println(bfs(tree.root));
    }

    public static List<Integer> bfs(TreeNode root){
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            root = q.poll();
            list.add(root.val);
            if(root.left!=null) q.add(root.left);
            if(root.right!=null) q.add(root.right);
        }

        return list;
    }
}
