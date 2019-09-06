package phone面经;

/**
 * Created by lizzie on 9/5/19.
 */
//https://leetcode.com/submissions/detail/146972329/
public class SecondSmallestInteger {
    public static void main(String[] args) {

    }
    public static int secondSmallest(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= smallest) {
                second = smallest;
                smallest = arr[i];
            } else if (arr[i] <= second) {
                second = arr[i];
            }
        }
        return second;
    }
}
