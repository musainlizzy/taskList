package phone面经;

/**
 * Created by lizzie on 10/31/18.
 */
// Keep track of the maximum height from both forward directions backward directions, call them leftmax and rightmax.

public class TrappingWater {
    public int trap(int[] height) {
        int leftIndex=0;
        int rightIndex=height.length-1;
        int max = 0;

        int leftmax = 0;
        int rightmax=0;
        // two pointers
        // if leftmax < rightmax， 对于leftIndex 水量确定 leftmax - height[leftIndex]
        while(leftIndex<rightIndex) {
            leftmax = Math.max(leftmax,height[leftIndex]);
            rightmax=Math.max(rightmax,height[rightIndex]);
            if (leftmax < rightmax) {
                max+=(leftmax-height[leftIndex]); // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                leftIndex++;
            } else {
                max+=(rightmax-height[rightIndex]);
                rightIndex--;
            }
        }
        return max;

    }
}
