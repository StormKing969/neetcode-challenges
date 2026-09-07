package Anagram_Groups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ANAGRAM GROUPS (Group Anagrams)
 * <a href="https://neetcode.io/problems/anagram-groups?list=neetcode150">...</a>
 * <p>
 * Given an array of strings strs, group all anagrams together into sublists.
 * You may return the output in any order.
 * <p>
 * An anagram is a string that contains the exact same characters as another
 * string, but the order of the characters can be different.
 * <p>
 * Example 1:
 *   Input: strs = ["act","pots","tops","cat","stop","hat"]
 *   Output: [["hat"],["act","cat"],["stop","pots","tops"]]
 * <p>
 * Example 2:
 *   Input: strs = ["x"]
 *   Output: [["x"]]
 * <p>
 * Example 3:
 *   Input: strs = [""]
 *   Output: [[""]]
 * <p>
 * Constraints:
 *   1 <= strs.length <= 1000
 *   0 <= strs[i].length <= 100
 *   strs[i] is made up of lowercase English letters.
 */
public class AnagramGroups {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            map.computeIfAbsent(key, _ -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    static void main() {
        int passed = 0;
        int total = 0;

        total++;
        if (checkResult(
                groupAnagrams(new String[]{"act", "pots", "tops", "cat", "stop", "hat"}),
                new String[][]{{"hat"}, {"act", "cat"}, {"stop", "pots", "tops"}})) {
            passed++;
        }

        total++;
        if (checkResult(
                groupAnagrams(new String[]{"x"}),
                new String[][]{{"x"}})) {
            passed++;
        }

        total++;
        if (checkResult(
                groupAnagrams(new String[]{""}),
                new String[][]{{""}})) {
            passed++;
        }

        total++;
        if (checkResult(
                groupAnagrams(new String[]{"bat", "tab", "cat"}),
                new String[][]{{"bat", "tab"}, {"cat"}})) {
            passed++;
        }

        System.out.println(passed + "/" + total + " test cases passed");
    }

    // Compares result against expected groups, ignoring order of groups
    // and order of elements within each group.
    private static boolean checkResult(List<List<String>> actual, String[][] expected) {
        Set<Set<String>> actualSet = new HashSet<>();
        for (List<String> group : actual) {
            actualSet.add(new HashSet<>(group));
        }

        Set<Set<String>> expectedSet = new HashSet<>();
        for (String[] group : expected) {
            expectedSet.add(new HashSet<>(Arrays.asList(group)));
        }

        boolean pass = actualSet.equals(expectedSet);
        System.out.println((pass ? "PASS" : "FAIL")
                + " | expected groups: " + expectedSet
                + " | actual groups: " + actualSet);
        return pass;
    }
}