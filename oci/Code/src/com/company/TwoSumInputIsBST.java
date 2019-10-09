package com.company;
import java.util.*;

public class TwoSumInputIsBST {
    /*
    Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True


Example 2:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
     */
    public class Solution {
        public boolean findTarget(TreeNode root, int k) {
            Set < Integer > set = new HashSet();
            return find(root, k, set);
        }
        public boolean find(TreeNode root, int k, Set < Integer > set) {
            if (root == null)
                return false;
            if (set.contains(k - root.val))
                return true;
            set.add(root.val);
            return find(root.left, k, set) || find(root.right, k, set);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

}
