import java.util.*;
public class ReverseExpression {
    public static String reverseExpression(String input) {
        char[] letters = input.toCharArray();
        swap(letters, 0, letters.length - 1);
        int start = 0;
        int end = 0;
        while(end < letters.length) {
            if(end == letters.length - 1) {
                swap(letters, start, end);
                break;
            }
            else if(!isOperator(letters[end])){
                end++;
            } else {
               swap(letters, start, end - 1);
               start = end + 1;
               end++;
            }
        }
        return new String(letters);
    }

    private static boolean isOperator(char num) {
        if(num == '+' || num =='-' || num == '*' || num == '/') {
            return true;
        }
        return false;
    }

    private static void swap(char[] letters, int a, int b) {
        while (a < b) {
            char temp = letters[a];
            letters[a] = letters[b];
            letters[b] = temp;
            a++;
            b--;
        }
    }

    public static void main(String[] argv) {
        String input = "10.4*32.7/12";
        String output = reverseExpression(input);
        System.out.println(output);
    }
}
