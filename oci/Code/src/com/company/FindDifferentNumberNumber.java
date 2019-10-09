package com.company;
import java.util.*;
public class FindDifferentNumberNumber {
    public static int findDiffNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return -1;
    }
}
