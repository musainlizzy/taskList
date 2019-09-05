package phone面经;

/**
 * Created by lizzie on 11/8/18.
 */
public class ToThePowerOfTen {
    public static boolean check(int num) {
        while (num > 9 && num % 10 == 0) {
            num = num / 10;
        }
        return num == 1;
    }
}
