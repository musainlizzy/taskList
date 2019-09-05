package phone面经;

/**
 * Created by lizzie on 10/31/18.
 */
import java.util.*;
public class BinaryTreeLevelOrder {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> level = new ArrayList<>();
                for (int i =0; i < size; i++) {
                    TreeNode curt = queue.poll();
                    level.add(curt.val);
                    if(curt.left != null) {
                        queue.offer(curt.left);
                    }
                    if (curt.right != null) {
                        queue.offer(curt.right);
                    }
                }
                result.add(level);
            }
            return result;

        }
    }
}
