package Duplicate_Integer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * NeetCode: Contains Duplicate (Duplicate Integer)
 * <a href="https://neetcode.io/problems/duplicate-integer">...</a>
 * <p>
 * Given an integer array nums, return true if any value appears more than
 * once in the array, otherwise return false.
 * <p>
 * Example 1:
 *   Input: nums = [1, 2, 3, 3]
 *   Output: true
 * <p>
 * Example 2:
 *   Input: nums = [1, 2, 3, 4]
 *   Output: false
 * <p>
 * Constraints:
 *   1 <= nums.length <= 10^5
 *   -1000 <= nums[i] <= 1000
 */
public class DuplicateInteger {

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numberSet = new HashSet<>();
        for (int ele : nums) {
            if (!numberSet.add(ele)) {
                return true;
            }
        }

        return false;
    }

    static void main() {
        DuplicateInteger solution = new DuplicateInteger();

        int[][] testInputs = {
                {1, 2, 3, 3},
                {1, 2, 3, 4},
                {1, 1},
                {5},
                {-1, -2, -3, -2}
        };

        boolean[] expected = {
                true,
                false,
                true,
                false,
                true
        };

        int passed = 0;
        for (int i = 0; i < testInputs.length; i++) {
            boolean result = solution.hasDuplicate(testInputs[i]);
            boolean ok = result == expected[i];
            if (ok) passed++;
            System.out.printf(
                    "Test %d: input=%s | expected=%b | got=%b | %s%n",
                    i + 1,
                    Arrays.toString(testInputs[i]),
                    expected[i],
                    result,
                    ok ? "PASS" : "FAIL"
            );
        }
        System.out.printf("%n%d/%d tests passed.%n", passed, testInputs.length);
    }
}