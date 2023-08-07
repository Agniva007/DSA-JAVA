package Medium;

import Traversals.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvgOfLevels {
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

        System.out.println(avg(tree.root));
    }

    public static List<Double> avg(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> avg = new ArrayList<>();

        if(root == null) return avg;

        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            double ans = 0;
            for(int i=0; i<size; i++){
                if(q.peek().left != null)
                    q.offer(q.peek().left);
                if(q.peek().right != null)
                    q.offer(q.peek().right);

                list.add(q.poll().val);
            }

            for(int i=0; i<list.size(); i++){
                ans += list.get(i);
            }

            avg.add(ans/list.size());
        }

        return avg;
    }
}
