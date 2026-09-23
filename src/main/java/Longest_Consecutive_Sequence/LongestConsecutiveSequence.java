package Longest_Consecutive_Sequence;

import java.util.Arrays;

/**
 * NeetCode: Longest Consecutive Sequence
 * <a href="https://neetcode.io/problems/longest-consecutive-sequence/question?list=neetcode150">...</a>
 * <p>
 * Given an array of integers nums, return the length of the longest
 * consecutive sequence of elements that can be formed.
 * <p>
 * A consecutive sequence is a sequence of elements in which each element is
 * exactly 1 greater than the previous element. The elements do not have to be
 * consecutive in the original array.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * Example 1:
 *   Input: nums = [2,20,4,10,3,4,5]
 *   Output: 4
 *   Explanation: The longest consecutive sequence is [2, 3, 4, 5].
 * <p>
 * Example 2:
 *   Input: nums = [0,3,2,5,4,6,1,1]
 *   Output: 7
 * <p>
 * Constraints:
 *   0 <= nums.length <= 100000
 *   -1000000000 <= nums[i] <= 1000000000
 */
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Arrays.sort(nums);
        int counter = 1;
        int maxLength = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == 0) {
                continue;
            }

            if (nums[i + 1] - nums[i] == 1) {
                counter++;
            } else {
                maxLength = Math.max(maxLength, counter);
                counter = 1;
            }
        }

        return Math.max(maxLength, counter);
    }

    static void main() {
        int passed = 0;
        int total = 0;

        total++;
        if (check(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}, 7)) passed++;

        total++;
        if (check(new int[]{2, 20, 4, 10, 3, 4, 5}, 4)) passed++;

        total++;
        if (check(new int[]{0, 3, 2, 5, 4, 6, 1, 1}, 7)) passed++;

        total++;
        if (check(new int[]{}, 0)) passed++;

        total++;
        if (check(new int[]{5}, 1)) passed++;

        total++;
        if (check(new int[]{7, 7, 7}, 1)) passed++;

        total++;
        if (check(new int[]{-2, -1, 0, 1, 10}, 4)) passed++;

        total++;
        if (check(new int[]{1000000000, -1000000000}, 1)) passed++;

        System.out.println(passed + "/" + total + " test cases passed");
    }

    private static boolean check(int[] nums, int expected) {
        int actual = longestConsecutive(nums);
        boolean pass = actual == expected;
        System.out.println((pass ? "PASS" : "FAIL")
                + " | expected: " + expected
                + " | actual: " + actual);
        return pass;
    }
}
