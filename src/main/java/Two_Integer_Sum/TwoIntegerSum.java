package Two_Integer_Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Two Integer Sum
 * Link: <a href="https://neetcode.io/problems/two-integer-sum">...</a>
 * <p>
 * Given an array of integers nums and an integer target, return the indices
 * i and j such that nums[i] + nums[j] == target and i != j.
 * <p>
 * You may assume that every input has exactly one pair of indices i and j
 * that satisfy the condition.
 * <p>
 * Return the answer with the smaller index first.
 * <p>
 * Example:
 * Input: nums = [3,4,5,6], target = 7
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] == 7, so we return [0, 1].
 * <p>
 * Constraints:
 * 2 <= nums.length <= 1000
 * -10,000,000 <= nums[i] <= 10,000,000
 * -10,000,000 <= target <= 10,000,000
 */
public class TwoIntegerSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberLookup = new HashMap<>();
        numberLookup.put(target - nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (numberLookup.containsKey(nums[i])) {
                return new int[]{numberLookup.get(nums[i]), i};
            } else {
                numberLookup.put(remainder, i);
            }
        }

        return new int[]{};
    }

    static void main() {
        int[][] testInputs = {
                {3, 4, 5, 6},
                {4, 5, 6},
                {5, 5}
        };
        int[] targets = {7, 10, 10};
        int[][] expected = {
                {0, 1},
                {0, 2},
                {0, 1}
        };

        int passed = 0;
        for (int i = 0; i < testInputs.length; i++) {
            int[] result = twoSum(testInputs[i], targets[i]);
            boolean correct = Arrays.equals(result, expected[i]);
            System.out.println("Test " + (i + 1) + ": " +
                    (correct ? "PASS" : "FAIL") +
                    " | input=" + Arrays.toString(testInputs[i]) +
                    ", target=" + targets[i] +
                    ", expected=" + Arrays.toString(expected[i]) +
                    ", got=" + Arrays.toString(result));
            if (correct) passed++;
        }
        System.out.println(passed + "/" + testInputs.length + " tests passed");
    }
}