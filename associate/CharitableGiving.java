import java.util.*;

public class CharitableGiving {
    public static String[] charitableGiving(int[] input) {
        int[] donation = new int[3];
        String[] name = new String[] {"A", "B", "C"};
        String[] res = new String[input.length];
        for(int i = 0; i < input.length; i++) {
            int index = findMinIndex(donation);
            res[i] = name[index];
            donation[index] += input[i];
        }
        return res;
    }

    private static int findMinIndex(int[] donation) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < donation.length; i++) {
            if(donation[i] < min) {
                min = donation[i];
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] argv) {
        int[] input = new int[] {25,8,2,35,15,120,55,42};
        String[] res = charitableGiving(input);
        for(String s : res) {
            System.out.println(s);
        }
    }
}
