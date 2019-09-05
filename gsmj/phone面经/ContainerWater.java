package phone面经;

/**
 * Created by lizzie on 10/31/18.
 */
class ContainerWater{
    public int maxArea(int[] height) {
        /*
        1 2 3 4


      4 |        |
      3 |     |  |
      2 |  |  |  |
      1 |__|__|__|____
        0  1  2  3

        从两端到中间移动，

        */
        int left = 0, right = height.length - 1;
        int result = 0;
        while (left < right) {
            result = Math.max(result, findArea(height, left, right));
            if (height[left] < height[right]) { // 目前面积已left为高，如果找更大的，必须移动left, 否则面积永远更小
                left++;
            } else {
                right--;
            }
        }
        return result;



    }
    private int findArea(int[] height, int left, int right) {
        return (right - left) * Math.min(height[left], height[right]);
    }
}
