package phone面经;

/**
 * Created by lizzie on 9/5/19.
 */
import java.util.*;

public class ThreeSum {
        /*
    The idea is to sort an input array and then run through all indices of a possible first element of a triplet. For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array. Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
    */
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new LinkedList<>();
            for (int i = 0; i < nums.length-2;i++) {
                if ((i == 0) || (i>0&& nums[i] != nums[i-1])) { // nums[i] != nums[i-1] avoid repeated list
                    int lo = i+1;
                    int hi = nums.length - 1;
                    int sum = 0 - nums[i];
                    while (lo < hi) {
                        if (nums[lo] + nums[hi] == sum) {
                            res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                            while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                            while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                            lo++;
                            hi--;

                        } else if (nums[lo] + nums[hi] < sum) lo++;
                        else hi--;
                    }
                }

            }
            return res;

        }

}
