package com.company;
import java.util.*;
/*
https://leetcode.com/problems/permutations/
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Permutation {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(subset);
            return result;
        }
        helper(result, subset, 0, nums);
        return result;

    }
    private void helper(List<List<Integer>> result, List<Integer> subset, int start, int[] nums) {
        result.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) { // 从start 起向set中添加元素
            subset.add(nums[i]);
            helper(result, subset, i + 1, nums); // 注意是i + 1
            subset.remove(subset.size() - 1);

        }
    }
}
