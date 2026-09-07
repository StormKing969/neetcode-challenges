package Top_K_Elements_In_List;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Top K Elements in List (Top K Frequent Elements)
 * Link: <a href="https://neetcode.io/problems/top-k-elements-in-list?list=neetcode150">...</a>
 * <p>
 * Given an integer array nums and an integer k, return the k most frequent
 * elements within the array.
 * <p>
 * The test cases are generated such that the answer is always unique.
 * <p>
 * You may return the output in any order.
 * <p>
 * Example 1:
 *   Input: nums = [1,2,2,3,3,3], k = 2
 *   Output: [2,3]
 *   Explanation: Element 3 appears 3 times, element 2 appears 2 times, and
 *   element 1 appears once. The 2 most frequent are 3 and 2.
 * <p>
 * Example 2:
 *   Input: nums = [7,7], k = 1
 *   Output: [7]
 *   Explanation: Element 7 appears twice and is the only distinct element.
 * <p>
 * Constraints:
 *   1 <= nums.length <= 10^4
 *   -1000 <= nums[i] <= 1000
 *   1 <= k <= number of distinct elements in nums
 * <p>
 * Recommended complexity: O(n) time and O(n) space.
 */
public class TopKElementsInList {

    public static int[] topKFrequent(int[] nums, int k) {
        // TODO: implement
        return new int[]{};
    }

    static void main() {
        int passed = 0;
        int total = 0;

        total++;
        if (checkResult(
                topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 2),
                new int[]{2, 3})) {
            passed++;
        }

        total++;
        if (checkResult(
                topKFrequent(new int[]{7, 7}, 1),
                new int[]{7})) {
            passed++;
        }

        total++;
        if (checkResult(
                topKFrequent(new int[]{1, 1, 2, 2, 3}, 3),
                new int[]{1, 2, 3})) {
            passed++;
        }

        total++;
        if (checkResult(
                topKFrequent(new int[]{-1, -1, -2, 3, 3, 3}, 1),
                new int[]{3})) {
            passed++;
        }

        total++;
        if (checkResult(
                topKFrequent(new int[]{5}, 1),
                new int[]{5})) {
            passed++;
        }

        System.out.println(passed + "/" + total + " test cases passed");
    }

    // Compares result against expected, ignoring order of elements.
    private static boolean checkResult(int[] actual, int[] expected) {
        Set<Integer> actualSet = new HashSet<>();
        for (int n : actual) {
            actualSet.add(n);
        }

        Set<Integer> expectedSet = new HashSet<>();
        for (int n : expected) {
            expectedSet.add(n);
        }

        boolean pass = actualSet.equals(expectedSet);
        System.out.println((pass ? "PASS" : "FAIL")
                + " | expected: " + Arrays.toString(expected)
                + " | actual: " + Arrays.toString(actual));
        return pass;
    }
}
