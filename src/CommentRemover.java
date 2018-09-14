import java.util.*;
/**
 * Created by lizzie on 9/11/18.
 */
public class CommentRemover {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("// a\n");
        input.add("public class Example {\n");
        input.add("    public static void main(String[] args){\n");
        input.add("        System.out.println(\"/* */\"); // single line\n");
        input.add("        /* a\n");
        input.add("        b\n");
        input.add("        b\n");
        input.add("         c*/\n");
        input.add("    }\n");
        input.add("}*/\n");
        System.out.println(removeComment(input));
    }
    public static String removeComment(List<String> input) {
        StringBuilder result = new StringBuilder();
        StringBuilder pending = new StringBuilder();
        int commentOpen = 0; // normal:0, // 1, /* 2
        int numOfNewLine = 0;
        for (String line : input) {
            commentOpen = processSingleLine(line, commentOpen, result, pending, numOfNewLine);
            if (commentOpen == 2) {
                numOfNewLine++;
            } else {
                numOfNewLine = 0;
            }
        }
        result.append(pending);
        return new String(result);
    }
    private static int processSingleLine(String line, int commentOpen, StringBuilder result, StringBuilder pending, int numOfNewLine) {
        char[] arr = line.toCharArray();
        for (int i = 0; i <arr.length; i++) {
            if (commentOpen == 0 && (i > 0 && arr[i] == '/' && arr[i - 1] == '*')) { // 前面没有open 的close
                result.append(arr[i]);
            } else if (i > 0 && arr[i] == '/' && arr[i - 1] == '*') { // find close
                // delete pending
                // add /n to result
                commentOpen = 0;
                pending.setLength(0);
                for (int j = 0; j <= numOfNewLine; j++) {
                    result.append('\n');
                }
                continue;

            } else if (commentOpen != 0) { // open 后的东西
                pending.append(arr[i]);
            } else if (i <arr.length - 1 && arr[i] == '/' && arr[i + 1] == '*') { // before no open find a open
                commentOpen = 2;
                pending.append(arr[i]).append('*');
                i++;
            } else if (i <arr.length - 1 && arr[i] == '/' &&  arr[i + 1] == '/') {
                commentOpen = 1;
                pending.append(arr[i]).append('/');
                i++;
            } else {
                result.append(arr[i]);
            }

            if (commentOpen == 1 && i == arr.length - 1) {
                commentOpen = 0;
                pending.setLength(0);
            }

        }
        return commentOpen;

        // if open, 找close
        // if close, 找第一个open
    }
}
