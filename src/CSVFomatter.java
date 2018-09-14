
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CSVFomatter {

    public static String formatCSV(List<String> input){
        List<ArrayList<String>> formattedInput = new ArrayList<ArrayList<String>>();
        StringBuilder sb = new StringBuilder();
        int longest = 0;
        for (String s : input) {
            String[] strArr = s.split(",");
            if (strArr.length > longest)
                longest = strArr.length;
            ArrayList<String> row = new ArrayList<>(Arrays.asList(strArr));
            formattedInput.add(row);
        }

        for (List<String> row : formattedInput)
            while (row.size() < longest)
                row.add("");

        //max length for each column
        int[] maxCol = new int[formattedInput.get(0).size()];

        //find max length for each column
        for (int i = 0; i < formattedInput.size(); i++) {
            for (int j = 0; j < formattedInput.get(i).size(); j++) {
                if (maxCol[j] < formattedInput.get(i).get(j).trim().length()) {
                    maxCol[j] = formattedInput.get(i).get(j).trim().length();
                }
            }
        }

        //adding space to each column
        for (int i = 0; i < formattedInput.size(); i++) {
            for (int j = 0; j < formattedInput.get(i).size(); j++) {
                sb.append(String.format("%"+maxCol[j]+"s", formattedInput.get(i).get(j).trim()));
                if (j != formattedInput.get(i).size()-1)
                    sb.append(", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> input = new ArrayList<>();
        input.add("Name,Course, Percent, Letter Grade");
        input.add("Nick Zhao, Bio, 88,    B");
        input.add("Halal Guy, Arabic, 100, A");
        input.add("Dick Small,English, 83");
        input.add("Fudge,,I love eating McDonald's, E");
        input.add(",,,,");

        String[] list = "Fudge,EEEEEEEEEEEEEEEEE, E,".split(",");
        System.out.println("listlength "+list.length);

        int longest = 0;
        List<ArrayList<String>> formattedInput = new ArrayList<ArrayList<String>>();
        for(String s: input) {
            String[] strArr = s.split(",");
            if (strArr.length > longest)
                longest = strArr.length;

            ArrayList<String> row = new ArrayList<>(Arrays.asList(strArr));
            formattedInput.add(row);
        }

        for (List<String> row : formattedInput)
            while (row.size() < longest)
                row.add("");

        //max length for each column
        int[] maxCol = new int[formattedInput.get(0).size()];

        //find max length for each column
        for (int i = 0; i < formattedInput.size(); i++) {
            for (int j = 0; j < formattedInput.get(i).size(); j++) {
                if (maxCol[j] < formattedInput.get(i).get(j).trim().length()) {
                    maxCol[j] = formattedInput.get(i).get(j).trim().length();
                }
            }
        }

        for (int i : maxCol) {
            System.out.println(i);
        }
        System.out.println(CSVFomatter.formatCSV(input));
    }

}

