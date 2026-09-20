package Products_Of_Array_Except_Self;

import java.util.Arrays;

/**
 * PRODUCTS OF ARRAY EXCEPT SELF
 * <a href="https://neetcode.io/problems/products-of-array-discluding-self/question?list=neetcode150">...</a>
 * <p>
 * Given an integer array nums, return an array output where output[i] is the
 * product of all the elements of nums except nums[i].
 * <p>
 * Each product is guaranteed to fit in a 32-bit integer.
 * <p>
 * Follow-up: Could you solve it in O(n) time without using the division operation?
 * <p>
 * Example 1:
 *   Input: nums = [1,2,4,6]
 *   Output: [48,24,12,8]
 * <p>
 * Example 2:
 *   Input: nums = [-1,0,1,2,3]
 *   Output: [0,-6,0,0,0]
 * <p>
 * Constraints:
 *   2 <= nums.length <= 100000
 *   -30 <= nums[i] <= 30
 */
public class ProductsOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // prefix pass
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        // suffix pass
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }

    static void main() {
        int passed = 0;
        int total = 0;

        total++;
        if (check(new int[]{1, 2, 4, 6}, new int[]{48, 24, 12, 8})) {
            passed++;
        }

        total++;
        if (check(new int[]{-1, 0, 1, 2, 3}, new int[]{0, -6, 0, 0, 0})) {
            passed++;
        }

        // Two elements: each output is the other element
        total++;
        if (check(new int[]{3, 5}, new int[]{5, 3})) {
            passed++;
        }

        // Two zeros: every product is 0
        total++;
        if (check(new int[]{0, 0, 4}, new int[]{0, 0, 0})) {
            passed++;
        }

        // Negatives
        total++;
        if (check(new int[]{-2, -3, 4}, new int[]{-12, -8, 6})) {
            passed++;
        }

        System.out.println(passed + "/" + total + " test cases passed");
    }

    private static boolean check(int[] nums, int[] expected) {
        int[] actual = productExceptSelf(nums.clone());
        boolean pass = Arrays.equals(actual, expected);
        System.out.println((pass ? "PASS" : "FAIL")
                + " | input: " + Arrays.toString(nums)
                + " | expected: " + Arrays.toString(expected)
                + " | actual: " + Arrays.toString(actual));
        return pass;
    }
}
