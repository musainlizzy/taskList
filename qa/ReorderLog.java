import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lizzie on 8/28/19.
 */
public class ReorderLog {
    /*
    You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.



Example 1:

Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]


Note:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.

Time Complexity: O(AlogA), where O(AlogA) is the total content of logs.
The sort process costs O( nlog(n)) time. The sorting algorithm is a modified mergesort (in which the merge is omitted if the highest element in the low sublist is less than the lowest element in the high sublist). This algorithm offers guaranteed n log(n) performance.
Space Complexity: O(A)
     */
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            String[] elements = log.split(" ");
            if (Character.isLetter(elements[1].charAt(0))) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }

        letterLogs.sort((o1, o2) -> {
            String[] s1 = o1.split(" ");
            String[] s2 = o2.split(" ");
            String id1 = s1[0];
            String id2 = s2[0];
            int len1 = s1.length;
            int len2 = s2.length;

            for (int i = 1; i < Math.min(len1, len2); i++) {
                if (!s1[i].equals(s2[i])) {
                    return s1[i].compareTo(s2[i]);
                } else if (i == Math.min(len1, len2) - 1 && s1[i].equals(s2[i])) {
                    return id1.compareTo(id2);
                }
            }
            return 0;
        });

        for (int i = 0; i < logs.length; i++) {
            if (i < letterLogs.size()) {
                logs[i] = letterLogs.get(i);
            } else {
                logs[i] = digitLogs.get(i - letterLogs.size());
            }
        }

        return logs;
    }
}
