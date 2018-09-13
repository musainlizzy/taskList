/**
 * Created by lizzie on 9/11/18.
 */
public class WholeMinuteDilemma {
    public static void main(String[] args) {
        int[] arr = new int[]{5,30,20,150,100,40,30,30};
        int a = findNumber(arr);
        System.out.println(a);

        int[] arr2 = new int[]{4};
        int b = findNumber(arr2);
        System.out.println(b);


    }
    public static int findNumber(int[] input) {
        int[] remainMap = new int[60];
        for (int minute:input) {
            remainMap[minute % 60]++;
        }
        int result = (int)combination(remainMap[0],2);
        int index = 1;
        while (index < 30) {
            result += remainMap[index] * remainMap[60 - index];
            index++;
        }
        result += (int)combination(remainMap[30], 2);
        return result;
    }
    private static int factorial(int n) {
        return (n > 1) ? n * factorial(n - 1) : 1;
    }
    public static int combination(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
    }
}
