package String_Encode_And_Decode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Encode and Decode Strings
 * Link: <a href="https://neetcode.io/problems/string-encode-and-decode?list=neetcode150">...</a>
 * <p>
 * Design an algorithm to encode a list of strings into a single string. This
 * encoded string is then decoded back into the original list of strings.
 * <p>
 * Machine 1 (sender) has the string list and encodes it into a single string
 * to send to Machine 2 (receiver). Machine 2 decodes the single string back
 * into the original list.
 * <p>
 * Please implement encode and decode.
 * <p>
 * Example 1:
 *   Input: strs = ["Hello","World"]
 *   Output: ["Hello","World"]
 * <p>
 * Example 2:
 *   Input: strs = [""]
 *   Output: [""]
 * <p>
 * Constraints:
 *   0 <= strs.length < 100
 *   0 <= strs[i].length < 200
 *   strs[i] contains only valid ASCII characters (256 possible values).
 * <p>
 * Recommended complexity: O(m) time per encode/decode call, where m is the
 * sum of all string lengths. O(m + n) space, where n is the number of strings.
 */
public class StringEncodeAndDecode {

    public static String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String ele : strs) {
            encodedString.append(ele.length()).append('#').append(ele);
        }

        return encodedString.toString();
    }

    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            j++;
            String word = str.substring(j, j + length);
            result.add(word);
            i = j + length;
        }

        return result;
    }

    static void main() {
        int passed = 0;
        int total = 0;

        total++;
        if (checkRoundTrip(List.of("Hello", "World"))) {
            passed++;
        }

        total++;
        if (checkRoundTrip(List.of(""))) {
            passed++;
        }

        total++;
        if (checkRoundTrip(List.of())) {
            passed++;
        }

        total++;
        if (checkRoundTrip(List.of("abc"))) {
            passed++;
        }

        total++;
        if (checkRoundTrip(Arrays.asList("", "", ""))) {
            passed++;
        }

        total++;
        if (checkRoundTrip(List.of("4#3", "3#4", "#"))) {
            passed++;
        }

        total++;
        if (checkRoundTrip(List.of("one", "two", "three", "four"))) {
            passed++;
        }

        System.out.println(passed + "/" + total + " test cases passed");
    }

    // Encodes then decodes the given list and checks the round trip matches
    // the original, order and contents included.
    private static boolean checkRoundTrip(List<String> original) {
        String encoded = encode(original);
        List<String> decoded = decode(encoded);

        boolean pass = original.equals(decoded);
        System.out.println((pass ? "PASS" : "FAIL")
                + " | original: " + original
                + " | encoded: " + encoded
                + " | decoded: " + decoded);
        return pass;
    }
}
