package phone面经;

import java.util.*;

/**
 * Created by lizzie on 10/30/18.
 */
public class HighAvg {
    public static void main(String[] args) {
        String[][] input = new String[][]{{"a","-2"},{"b","2"},{"a","-1"}};
        findHighestAvg(input);
    }
    public static int findHighestAvg(String[][] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        // student, total score
        Map<String, Integer> scoreMap = new HashMap<>();
        // student, number of score
        Map<String, Integer> freqMap = new HashMap<>();

        for (String[] student: array) {
            if (student.length != 2) {
                continue;
            }
            String studentName = student[0];
            int score = Integer.parseInt(student[1]); // string->integer
            if (scoreMap.containsKey(studentName)) {
                scoreMap.put(studentName, scoreMap.get(studentName) + score);
                freqMap.put(studentName, freqMap.get(studentName) + 1);
            } else {
                scoreMap.put(studentName, score);
                freqMap.put(studentName, 1);
            }
        }
        int max = Integer.MIN_VALUE;
        for (String name: scoreMap.keySet()) {
            int freq = freqMap.get(name);
            double avg = (double)scoreMap.get(name) / (double)freqMap.get(name);
            System.out.println(avg);
            System.out.println(Math.floor(avg)); // rounding it down
            if (avg > max) {
                max = (int)avg;
            }
        }
        return max;
    }
}
