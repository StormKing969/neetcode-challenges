package Two_Integer_Sum_II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Two Integer Sum II
 * Link: <a href="https://neetcode.io/problems/two-integer-sum-ii">...</a>
 * <p>
 * Given an array of integers numbers that is sorted in non-decreasing order,
 * return the indices (1-indexed) of two numbers, [index1, index2], such that
 * they add up to a given target number target and index1 < index2.
 * <p>
 * The indices cannot be equal, so you may not use the same element twice.
 * There will always be exactly one valid solution.
 * <p>
 * Your solution must use O(1) additional space.
 * <p>
 * Example:
 * Input: numbers = [1,2,3,4], target = 3
 * Output: [1,2]
 * Explanation: The sum of 1 and 2 is 3. With 1-indexing, index1 = 1 and index2 = 2.
 * <p>
 * Constraints:
 * 2 <= numbers.length <= 30,000
 * -1,000 <= numbers[i] <= 1,000
 * -1,000 <= target <= 1,000
 */
public class TwoIntegerSumII {

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> targetIndex = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (targetIndex.containsKey(numbers[i])) {
                return new int[]{targetIndex.get(numbers[i]), i + 1};
            } else {
                targetIndex.put(target - numbers[i], i + 1);
            }
        }

        return new int[]{};
    }

    static void main() {
        int[][] testInputs = {
                {1, 2, 3, 4},
                {-5, -3, 0, 2, 7},
                {2, 2, 3},
                {1, 3, 4, 6, 10},
                {-1, 0}
        };
        int[] targets = {3, -1, 4, 11, -1};
        int[][] expected = {
                {1, 2},
                {2, 4},
                {1, 2},
                {1, 5},
                {1, 2}
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
