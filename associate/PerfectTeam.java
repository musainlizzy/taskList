import java.util.*;

public class PerfectTeam {
    public static int differentTeams(String input) {
        Map<Character, Integer> count = new HashMap<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        if(count.size() < 5) {
            return 0;
        }
        for(Character c : count.keySet()) {
            min = Math.min(min, count.get(c));
        }
        return min;
    }

    public static void main(String[] argv) {
        System.out.println(differentTeams("pcmpcmbbbzz"));
    }
}
