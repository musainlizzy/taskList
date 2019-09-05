package phone面经;

/**
 * Created by lizzie on 10/31/18.
 */
public class climbingStairs {
    public static int climStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            // final step
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(climStairs(5));
    }
}
