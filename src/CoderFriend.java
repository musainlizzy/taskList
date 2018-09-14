import java.util.*;
/**
 * Created by lizzie on 9/13/18.
 */
public class CoderFriend {
    public static void main(String[] args) {

    }
    public static String helper(String erica, String bob) {
        if (erica == null && bob == null) {
            return "Tie";
        }
        if (erica == null || bob == null) {
            return erica == null? "Bob" : "Erica";
        }
        int[] ericaCounts = new int[3];
        int[] bobCounts = new int[3];
        char[] ericaArr = erica.toCharArray();
        char[] bobArr = bob.toCharArray();
        int ericaScore = countScore(ericaCounts, ericaArr);
        int bobScore = countScore(bobCounts,bobArr);
        if (ericaScore == bobScore) {
            if (ericaCounts[2] != bobCounts[2]) {
                return ericaCounts[2] > bobCounts[2] ? "Erica" : "Bob";
            } else if (ericaCounts[1] != bobCounts[1]) {
                return ericaCounts[1] > bobCounts[1] ? "Erica" : "Bob";
            } else if (ericaCounts[0] != bobCounts[0]) {
                return ericaCounts[0] > bobCounts[0] ? "Erica" : "Bob";
            } else {
                return "Tie";
            }
        } else if (ericaScore > bobScore) {
            return "Erica";
        }
        return "Bob";
    }
    private static int countScore(int[] counts, char[] arr) {
        int score = 0;
        for (char question:arr) {
            if (question == 'E') {
                counts[0]++;
                score +=1;
            } else if (question == 'M') {
                counts[1]++;
                score += 3;
            } else if (question == 'H') {
                counts[2]++;
                score += 5;
            }
        }
        return score;

    }
}
