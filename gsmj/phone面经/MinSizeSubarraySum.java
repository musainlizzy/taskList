package phone面经;

/**
 * Created by lizzie on 9/5/19.
 */
import java.util.*;
public class MinSizeSubarraySum {
    public int MinSubArrayLen(int s, int[] nums) {
        int minLen = nums.length +1;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++)
        {
            sum += nums[right];
            while (sum >= s && left <=right)
            {
//decrease till get smallest subarray possible in current window
                minLen = Math.min(minLen, right -left + 1);
                sum -= nums[left++];
            }
        }

        return minLen == nums.length + 1 ? 0 : minLen;

    }
}
