import java.util.*;
/**
 * Created by lizzie on 9/13/18.
 */
public class Stock {
    public static void main(String[] args) {

    }
    public static int findWorstPerf(List<List<Integer>> stocks) {
        if (stocks == null || stocks.size() == 0) {
            return 0;
        }
        int result = 0;
        double profit = Integer.MAX_VALUE;
        for (List<Integer> a: stocks) {
            if ((double)(a.get(2) - a.get(1)) / a.get(1) < profit) {
                profit = (double)(a.get(2) - a.get(1))/a.get(1);
                result = a.get(0);
            }
        }
        return result;
    }
}
