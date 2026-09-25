package Three_Integer_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * THREE INTEGER SUM (3Sum)
 * <a href="https://neetcode.io/problems/three-integer-sum/question?list=neetcode150">...</a>
 * <p>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.
 * <p>
 * The output should not contain any duplicate triplets. You may return the output
 * and the triplets in any order.
 * <p>
 * Example 1:
 *   Input: nums = [-1,0,1,2,-1,-4]
 *   Output: [[-1,-1,2],[-1,0,1]]
 * <p>
 * Example 2:
 *   Input: nums = [0,1,1]
 *   Output: []
 * <p>
 * Example 3:
 *   Input: nums = [0,0,0]
 *   Output: [[0,0,0]]
 * <p>
 * Constraints:
 *   3 <= nums.length <= 3000
 *   -10^5 <= nums[i] <= 10^5
 */
public class ThreeIntegerSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3 || nums[nums.length - 1] < 0) return new ArrayList<>();

        Set<List<Integer>> returnList = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            if (first > 0) break;

            for (int j = i + 1; j < nums.length - 1; j++) {
                int second = nums[j];
                int targetValue = (first + second) * -1;
                if (targetValue > nums[nums.length - 1]) continue;
                if (second > 0 && targetValue < 0) break;

                for (int k = nums.length - 1; k > j; k--) {
                    int third = nums[k];
                    if (third == targetValue) {
                        returnList.add(Arrays.asList(first, second, third));
                        break;
                    }
                }
            }
        }

        return returnList.stream().toList();
    }

    static void main() {
        int[][] testInputs = {
                {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4},
                {-1, 0, 1, 2, -1, -4},
                {0, 1, 1},
                {0, 0, 0},
                {0, 0, 0, 0},
                {-2, 0, 1, 1, 2},
                {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6},
                {1, 2, 3}
        };
        int[][][] expected = {
                {{-4, 0, 4}, {-4, 1, 3}, {-3, -1, 4}, {-3, 0, 3}, {-3, 1, 2}, {-2, -1, 3}, {-2, 0, 2}, {-1, -1, 2}, {-1, 0, 1}},
                {{-1, -1, 2}, {-1, 0, 1}},
                {},
                {{0, 0, 0}},
                {{0, 0, 0}},
                {{-2, 0, 2}, {-2, 1, 1}},
                {{-4, -2, 6}, {-4, 0, 4}, {-4, 1, 3}, {-4, 2, 2}, {-2, -2, 4}, {-2, 0, 2}},
                {}
        };

        int passed = 0;
        for (int i = 0; i < testInputs.length; i++) {
            List<List<Integer>> result = threeSum(testInputs[i].clone());
            boolean correct = normalize(result).equals(normalize(expected[i]));
            System.out.println("Test " + (i + 1) + ": " +
                    (correct ? "PASS" : "FAIL") +
                    " | input=" + Arrays.toString(testInputs[i]) +
                    ", expected=" + Arrays.deepToString(expected[i]) +
                    ", got=" + result);
            if (correct) passed++;
        }
        System.out.println(passed + "/" + testInputs.length + " tests passed");
    }

    // Sorts each triplet and then the list of triplets, so order doesn't matter.
    // Duplicate triplets are kept, so returning the same triplet twice is a FAIL.
    private static List<List<Integer>> normalize(List<List<Integer>> triplets) {
        List<List<Integer>> out = new ArrayList<>();
        for (List<Integer> t : triplets) {
            List<Integer> copy = new ArrayList<>(t);
            copy.sort(null);
            out.add(copy);
        }
        out.sort(Comparator.comparing((List<Integer> t) -> t.getFirst())
                .thenComparing(t -> t.get(1))
                .thenComparing(t -> t.get(2)));
        return out;
    }

    private static List<List<Integer>> normalize(int[][] triplets) {
        List<List<Integer>> out = new ArrayList<>();
        for (int[] t : triplets) {
            out.add(Arrays.stream(t).boxed().toList());
        }
        return normalize(out);
    }
}
