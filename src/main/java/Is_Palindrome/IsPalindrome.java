package Is_Palindrome;

/**
 * NeetCode: Valid Palindrome
 * <a href="https://neetcode.io/problems/is-palindrome/question?list=neetcode150">...</a>
 * <p>
 * Given a string s, return true if it is a palindrome, otherwise return false.
 * <p>
 * A palindrome is a string that reads the same forward and backward. It is
 * also case-insensitive and ignores all non-alphanumeric characters.
 * <p>
 * Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).
 * <p>
 * Example 1:
 *   Input: s = "Was it a car or a cat I saw?"
 *   Output: true
 *   Explanation: After considering only alphanumerical characters we have
 *                "wasitacaroracatisaw", which is a palindrome.
 * <p>
 * Example 2:
 *   Input: s = "tab a cat"
 *   Output: false
 *   Explanation: "tabacat" is not a palindrome.
 * <p>
 * Constraints:
 *   1 <= s.length <= 1000
 *   s is made up of only printable ASCII characters.
 */
public class IsPalindrome {

    public static boolean isPalindrome(String s) {
        String word = s.replace(" ", "").replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int right = word.length() - 1;
        int left = 0;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }

    static void main() {
        int passed = 0;
        int total = 0;

        total++;
        if (check("Was it a car or a cat I saw?", true)) passed++;

        total++;
        if (check("tab a cat", false)) passed++;

        total++;
        if (check("a", true)) passed++;

        total++;
        if (check(" ", true)) passed++;

        total++;
        if (check(".,!?", true)) passed++;

        total++;
        if (check("Aa", true)) passed++;

        total++;
        if (check("0P", false)) passed++;

        total++;
        if (check("12321", true)) passed++;

        total++;
        if (check("ab_a", true)) passed++;

        total++;
        if (check("race a car", false)) passed++;

        System.out.println(passed + "/" + total + " test cases passed");
    }

    private static boolean check(String s, boolean expected) {
        boolean actual = isPalindrome(s);
        boolean pass = actual == expected;
        System.out.println((pass ? "PASS" : "FAIL")
                + " | s: \"" + s + "\""
                + " | expected: " + expected
                + " | actual: " + actual);
        return pass;
    }
}
