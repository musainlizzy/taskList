//package phone面经;
//
///**
// * Created by lizzie on 11/9/18.
// */
//import java.util.*;
//import java.util.function.*;
//public class Prefix {
//    static String _document = String.join("",
//            "In publishing and graphic design, lorem ipsum is a ",
//            "filler text commonly used to demonstrate the graphic elements of a ",
//            "document or visual presentation. Replacing meaningful content that ",
//            "could be distracting with placeholder text may allow viewers to focus ",
//            "on graphic aspects such as font, typography, and page layout. It also ",
//            "reduces the need for the designer to come up with meaningful text, as ",
//            "they can instead use hastily generated lorem ipsum text. The lorem ",
//            "ipsum text is typically a scrambled section of De finibus bonorum et ",
//  "malorum, a 1st-century BC Latin text by Cicero, with words altered, ",
//          "added, and removed to make it nonsensical, improper Latin. A variation ",
//          "of the ordinary lorem ipsum text has been used in typesetting since ",
//          "the 1960s or earlier, when it was popularized by advertisements for ",
//          "Letraset transfer sheets. It was introduced to the Information Age in ",
//          "the mid-1980s by Aldus Corporation, which employed it in graphics and ",
//          "word processing templates for its desktop publishing program, ",
//          "PageMaker, for the Apple Macintosh. A common form of lorem ipsum ",
//          "reads: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do ",
//          "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad ",
//          "minim veniam, quis nostrud exercitation ullamco laboris nisi ut ",
//          "aliquip ex ea commodo consequat. Duis aute irure dolor in ",
//          "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla ",
//          "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in ",
//  "culpa qui officia deserunt mollit anim id est laborum.");
//
//    class MyPrefixSearch {
//        String doc;
//        public MyPrefixSearch(String doc) {
//            this.doc = doc;
//        }
//        public List<Integer> findAll(String input) {
//            // word, localtion
////            Map<String, List<Integer>> map = new HashMap<String, List<Integer>>;
////            char[] charA = doc.toCharArray();
////            int start = 0;
////            int end = 0;
////            for (int i = 0; i < charA.length; i++) {
////                if (charA[i] != ' ') {
////
////                }
////                if (charA[i] == ' ') {
////                    end = i - 1;
////                }
////            }
//
//            input = input.toLowerCase();
//            String sub = doc.toLowerCase();
//            List<Integer> result = new ArrayList<>();
//            if (doc.indexOf(input) == 0) {
//                result.add(0);
//            }
//            int start = 0;
//            while (doc.indexOf(" "+input) != -1) {
//                int index = doc.indexOf(" "+input, start);
//                result.add(index + 1);
//                start = index + 1;
//            }
//            return result;
//
//        }
//    }
//    public static void doTestsPass() {
//        MyPrefixSearch prefixSearch = new MyPrefixSearch(_document);
//
//        BiFunction<List<?>, List<?>, Boolean> resultMatches = (actual, expected) ->
//                actual != null && expected.equals(actual);
//        if( resultMatches.apply(
//                prefixSearch.findAll("demonstrate"), Arrays.asList( 80 ))
//                && resultMatches.apply(prefixSearch.findAll("pub"), Arrays.asList( 3, 988 ))
//                && resultMatches.apply(prefixSearch.findAll("publishing"), Arrays.asList( 3, 988 ))
//                && resultMatches.apply(prefixSearch.findAll("lab"), Arrays.asList( 1173, 1263, 1517 ))
//                && resultMatches.apply(prefixSearch.findAll("laborum"), Arrays.asList( 1517 ))
//                && resultMatches.apply(prefixSearch.findAll("in"),
//                Arrays.asList( 0, 404, 717, 839, 857, 873, 930, 1159, 1334, 1351, 1468))
//                && resultMatches.apply(prefixSearch.findAll("lor"),
//                Arrays.asList( 34, 434, 456, 686, 1061, 1080 ))
//     && resultMatches.apply(prefixSearch.findAll("l"),
//                Arrays.asList( 34, 309, 434, 456, 557, 651, 686, 806, 1061, 1080, 1173, 1263, 1517))
//                && prefixSearch.findAll("").size() == 0
//                && prefixSearch.findAll("hamburger").size() == 0)
//        System.out.println("All tests pass");
//  else
//        System.out.println("Test failed");
//    }
//
//
//    public static void main(String[] args) {
//        doTestsPass();
//
//    }
//}
