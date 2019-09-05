package phone面经;

/**
 * Created by lizzie on 10/31/18.
 */
import java.util.*;
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // iterate 先进先出，两两一组
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return true;
        }
        queue.offer(root.left);
        queue.offer(root.right);// 把要被比较的点放在一起加
        while (queue.size() != 0) {// linkedlist 有这个接口
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null ^ right == null) { // 有一个是null，一个不是
                return false;
            }
            if (left == null && right == null) {
                continue;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;

    }


}

