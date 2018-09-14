import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by lizzie on 9/13/18.
 */
public class FootballWorldCup {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(6);
        a.add(7);

        System.out.println(prob(a));
    }
    public static String prob(List<Integer> input) {
        if (input.size() < 2) {
            return "0.00";
        }
        if (input.size() == 2) {
            return "1.00";
        }
        double result = 0;
        int max = 0;
        int maxCount = 0;
        int secondMax = 0;
        int secondCount = 0;
        for (int num: input) {
            if (num > max) {
                secondMax = max;
                secondCount = maxCount;
                max = num;
                maxCount = 1;
            } else if (num == max) {
                maxCount++;
            } else if (num > secondMax) {
                secondMax = num;
                secondCount = 1;
            } else if (num == secondMax) {
                secondCount++;
            }
        }
        if (maxCount >= 2) {
            result = maxCount*(maxCount-1)/2.0;
        } else {
            result = maxCount * secondCount;
        }
        double sum = input.size() * (input.size() - 1) / 2.0;
        result = result / sum;
        String res = String.format("%.2f", result);
        return res;




        //        int sum = first + second;
//        HashMap<Integer, Integer> map = new HashMap<>(); // value, number
//        int count = 0;
//        for (int i = 0; i < input.size(); i++) {
//            if (map.containsKey(sum - input.get(i)) {
//
//            }
//            map.put(input.get(i), i);
//        }
    }
}
