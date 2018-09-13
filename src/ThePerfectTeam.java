import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizzie on 9/11/18.
 */
public class ThePerfectTeam {
    public static void main(String[] args) {
        int a = diffTeam("pcmbzpcmbz");
        System.out.println(a);
    }
    public static int diffTeam(String input) {
        Map<Character, Integer> map = new HashMap<>();
        char[] array = input.toCharArray();
        for (char c:array) {
            map.put(c, 1 + map.getOrDefault(c,0));
        }
        if (map.size() < 5) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int a:map.values()) {
            if (a < min) {
                min = a;
            }
        }
        return min;

    }
}
