/**
 * Created by lizzie on 9/13/18.
 */


//9 数组最大差值
//        求一个无序数组的a[j] - a[i] 最大差值 条件是
//        1 i < j
//2 a[i] < a[j]  . from: 1point3acres
//        3 a[i]奇数 a[j]偶数
//        思路是一个for循环 往前走的时候 一直记录之前的最小奇数 遇见偶数就和最小奇数求差 然后不断记录最大差值就好了

public class MaxDiff {
    public static void main(String[] args) {

    }
    public static int diff(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int minOdd = Integer.MAX_VALUE;
        int result = 1;
        for (int i=0; i < arr.length; i++) {
            if ((arr[i]%2 ==1 || arr[i]%2 == -1) && arr[i] < minOdd) {
                minOdd = arr[i];
            } else if (arr[i] % 2 == 0) {
                result = Math.max(arr[i] - minOdd, result);
            }
        }
        return result;
    }
}
