package phone面经;

/**
 * Created by lizzie on 10/31/18.
 */
import java.util.*;
public class Skyline {
    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>();
        System.out.println(price.get(1));
    }
//    public List<int[]> getSkyline(int[][] buildings) {
//        List<Integer> price = new ArrayList<>();
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        for (int[] line: buildings) {
//            int left = line[0];
//            int right = line[1];
//            if (left < min) {
//                min = left;
//            }
//            if (right > max) {
//                max = right;
//            }
//
//        }
//        for (int i = 0 ; i <= max; i++) {
//            price.add(-1);
//        }
//        // if there is a price in the range, find min price
//        for (int[] line: buildings) {
//            int left = line[0];
//            int right = line[1];
//            int curPrice = line[2];
//            for (int i = left; i <= right; i++) {
//                int curt = price.get(i);
//            }
//        }
//    }
}
