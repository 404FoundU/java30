package DSA.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.youtube.com/watch?v=92zdLCeiumk&list=PLKYEe2WisBTH48RzVCL_LQrGW-ahPY44S&index=11

/*
Mario has to go through 2 levels in bfs
Each level will have a loop pipeline.
 */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                sum += current.val;

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            double average = sum / levelSize;
            result.add(average);
        }

        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        AverageOfLevels solution = new AverageOfLevels();
        List<Double> averages = solution.averageOfLevels(root);
        System.out.println("Averages of each level: " + averages);
    }
}
