/**
 * Created by lizzie on 10/21/18.
 */
import java.util.*;
// two pointer O(n)
public class Substring {
    public static void main(String[] args) {
        List<String> l = substring("awaglknagawunagwkwagl", 4);
        for (String s:l) {
            System.out.println(s);
        }    }

    public static List<String> substring(String inputStr, int num) {
        if (inputStr == null || inputStr.length() < num) {
            return new ArrayList<>();
        }
        char[] sc = inputStr.toCharArray();
        Set<Character> set = new HashSet<>();
        Set<String> resultSet = new HashSet<>();
        int n = inputStr.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(inputStr.charAt(j)) && (j - i + 1) == num) {
                set.add(inputStr.charAt(j));
                resultSet.add(inputStr.substring(i, j + 1));
                set.remove(inputStr.charAt(i));
                i++;
                j++;
            } else if (!set.contains(inputStr.charAt(j)) && (j - i + 1) < num) {
                set.add(inputStr.charAt(j));
                j++;
            } else if (set.contains(inputStr.charAt(j))) {
                set.remove(inputStr.charAt(i));
                i++;
            }
        }
        List<String> result = new ArrayList<>(resultSet);

        return result;
    }
}
// abbbc