import java.util.*;

public class CapsLock {
    public static String pressAForCapsLock(String input) {
        StringBuilder sb = new StringBuilder();
        char[] letters = input.toCharArray();
        boolean isCap = false;
        for(char c : letters) {
            if(c == 'a' || c == 'A') {
                isCap = !isCap;
                continue;
            } else if(isCap) {
                sb.append(reverse(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static char reverse(char c) {
        if(c >= 'b' && c <= 'z') {
            return Character.toUpperCase(c);
        } else if(c >= 'B' && c <= 'Z') {
            return Character.toLowerCase(c);
        } else {
            return c;
        }
    }

    public static void main(String[] argv) {
        String input1 = "My keyboard is broken";
        String input2 = "'Baa, Baa!' said the sheep";
        System.out.println(pressAForCapsLock(input1));
        System.out.println(pressAForCapsLock(input2));
    }
}
