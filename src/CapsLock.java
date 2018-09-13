/**
 * Created by lizzie on 9/13/18.
 */
public class CapsLock {
    public static void main(String[] args) {
        String a= transfer("My keyboard is broken!");
        System.out.println(a);
        String b = transfer("\"Baa, Baa!\" said the sheep");
        System.out.println(b);

    }
    public static String transfer(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        boolean toUppercase = false;
        // transfer
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'a' || array[i] == 'A') {
                toUppercase = !toUppercase;
                continue;
            }
            if (toUppercase && Character.isLetter(array[i]) && Character.isLowerCase(array[i])) {
                array[i] = Character.toUpperCase(array[i]);
                continue;
            }
            if (toUppercase && Character.isLetter(array[i]) && Character.isUpperCase(array[i])) {
                array[i] = Character.toLowerCase(array[i]);
            }
        }
        // remove a
        String result = remove(array);
        return result;
    }
    private static String remove(char[] array) {
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] != 'a' && array[fast] != 'A') {
                array[slow++] = array[fast];
            }
        }
        return new String(array, 0, slow);
    }
}
