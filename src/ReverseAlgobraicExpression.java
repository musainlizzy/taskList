/**
 * Created by lizzie on 9/11/18.
 */
public class ReverseAlgobraicExpression {
    public static void main(String[] args) {
        String a = reverseWords("1*2.4+-9.6-23.89");
        System.out.println(a);
        String b = reverseWords("1*2.4+9.6-23.89");
        System.out.println(b);

    }
    public static String reverseWords(String input) {
        char[] array = input.toCharArray();
        reverse(array,0,array.length-1);
        int start = 0;
        // reverse each of words
        for (int i = 0; i < array.length; i++) {
            // the start index of the word.
            if (!isOprand(array[i])  && (i == 0 || isOprand(array[i - 1]))) {
                start = i;
            }
            // the end index of the operand
            if (i == array.length - 1 || (isOprand(array[i + 1]) && !isOprand(array[i + 2]))) {
                reverse(array, start, i);
            }

        }
        return  new String(array);

    }
    private static boolean isOprand(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        }
        return false;
    }
    private static void reverse(char[] array, int left, int right) {
        while(left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
