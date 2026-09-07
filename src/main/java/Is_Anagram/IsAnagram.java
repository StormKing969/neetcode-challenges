package Is_Anagram;

import java.util.Arrays;

/**
 * Is Anagram
 * <a href="https://neetcode.io/problems/is-anagram">...</a>
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An anagram is a string that contains the exact same characters as another string,
 * but the order of the characters can be different.
 * <p>
 * Example 1:
 * Input: s = "racecar", t = "carrace"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "jar", t = "jam"
 * Output: false
 * <p>
 * Constraints:
 * - s and t consist of lowercase English letters only
 */
public class IsAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] firstString = s.toCharArray();
        char[] secondString = t.toCharArray();
        Arrays.sort(firstString);
        Arrays.sort(secondString);

        for (int i = 0; i < firstString.length; i++) {
            if (firstString[i] != secondString[i]) {
                return false;
            }
        }

        return true;
    }

    static void main() {
        runTest("racecar", "carrace", true);
        runTest("jar", "jam", false);
        runTest("anagram", "nagaram", true);
        runTest("rat", "car", false);
        runTest("a", "ab", false);
        runTest("", "", true);
        runTest("aacc", "ccac", false);
    }

    private static void runTest(String s, String t, boolean expected) {
        boolean actual = isAnagram(s, t);
        String status = (actual == expected) ? "PASS" : "FAIL";
        System.out.printf("[%s] s=\"%s\", t=\"%s\" -> expected=%b, actual=%b%n",
                status, s, t, expected, actual);
    }
}