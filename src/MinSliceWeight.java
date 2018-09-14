import java.lang.reflect.Array;
import java.util.*;
/**
 * Created by lizzie on 9/11/18.
 */
public class MinSliceWeight {
    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,2,3};
        List<Integer> b = new ArrayList<>();
        b = Arrays.asList(a);
        Integer[] a1 = new Integer[]{4,5,6};
        List<Integer> b1 = new ArrayList<>();
        b1 = Arrays.asList(a1);
        Integer[] a2 = new Integer[]{7,8,9};
        List<Integer> b2 = new ArrayList<>();
        b2 = Arrays.asList(a2);

        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(b);
        matrix.add(b1);
        matrix.add(b2);
        matrix.forEach(System.out::println);

        System.out.println(FindMinSlice(matrix));

    }
    public static int FindMinSlice (List<List<Integer>> Matrix) {
        int rows=Matrix.size(); // number of rows in the matrix
        if(rows==0) {
            return 0;
        }
        int columns=Matrix.get(0).size(); // number of columns in the matrix

        if(columns==0) {
            return 0;
        }

        int sliceSum[]=new int[columns]; // maintains the current minimum slice sum starting form column j, we build this array bottom up
        for(int i=0;i<columns;i++)
            sliceSum[i]=Matrix.get(rows-1).get(i); // fill the sliceSum array with the values in the last row
        for(int i=rows-2;i>=0;i--) // iterate through the rows upward starting from the second-last row
        {
            for(int j=columns-1;j>=0;j--) { // iterate through the columns leftward starting from the last column
// sliceSum[j] = Matrix[i][j]+ min(sliceSum[j-1], sliceSum[j], sliceSum[j+1]) if the required indices exists in sliceSum
                if(j==columns-1)
                    sliceSum[j]=Math.min(sliceSum[j-1],sliceSum[j])+Matrix.get(i).get(j);
                else if(j==0)
                    sliceSum[j]=Math.min(sliceSum[j],sliceSum[j+1])+Matrix.get(i).get(j);
                else
                    sliceSum[j]=Math.min(sliceSum[j-1],Math.min(sliceSum[j],sliceSum[j+1]))+Matrix.get(i).get(j);
            }
        }
        int minSliceSum=sliceSum[0]; // current minimum sliceSum
        for(int i=1;i<columns;i++)
            minSliceSum=Math.min(minSliceSum,sliceSum[i]); // update the minimum sliceSum if required
        return minSliceSum;
    }
}
