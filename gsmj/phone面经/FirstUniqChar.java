package phone面经;

/**
 * Created by lizzie on 10/31/18.
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        //if the string contains any characters which are represented by ASCII, we’d better use int[256].
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        for(int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;

    }
}
