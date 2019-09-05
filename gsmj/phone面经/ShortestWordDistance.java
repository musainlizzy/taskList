package phone面经;

/**
 * Created by lizzie on 10/31/18.
 */
public class ShortestWordDistance {
    public static void main(String[] args) {

    }
    public static void split(String words, String word1, String word2) {
        String[] array = words.split(" ");
    }
    public int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int minDistance = words.length;
        int currentDistance;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            } else if (words[i].equals(word2)) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(i1 - i2));
            }
        }
        return minDistance;
    }
}
