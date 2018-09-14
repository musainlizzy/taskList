import java.util.*;

public class WholeMinDilemma {
    public static int numOfWholeMinSongs(List<Integer> input) {
        Collections.sort(input);
        int count = 0;
        int start = 0;
        int end = input.size() - 1;
        while(start < end) {
            int sum = input.get(start) + input.get(end);
            if(sum == 60) {
                count++;
                start++;
                end--;
            } else if(sum > 60) {
                end--;
            } else {
                start++;
            }
        }
        return count;
    }

    public static void main(String[] argv){
        List<Integer> input = Arrays.asList(10,20,60,50,40);
        int output = numOfWholeMinSongs(input);
        System.out.println(output);
    }
}
