package phone面经;

/**
 * Created by lizzie on 10/31/18.
 */
public class minSizeSubarray {
    public static void main(String[] args) {
        System.out.println(minimumSize(new int[]{2,3,1,2,4,3}, 7));
    }
    public static int minimumSize(int[] input, int s) {
        if (input == null || input.length == 0) {
            return -1;
        }
        int[] sum = new int[input.length];
        sum[0] = input[0];
        for (int i = 1; i < input.length; i++) {
            sum[i] = sum[i - 1] + input[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                int sumSoFar = sum[j] - sum[i] + input[i];
                if (sumSoFar >= s) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min;
    }
}
