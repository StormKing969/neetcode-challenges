package Valid_Sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * NeetCode: Valid Sudoku
 * <a href="https://neetcode.io/problems/valid-sudoku/question?list=neetcode150">...</a>
 * <p>
 * You are given a 9 x 9 Sudoku board. A Sudoku board is valid if the
 * following rules are followed:
 * <p>
 *   1. Each row must contain the digits 1-9 without duplicates.
 *   2. Each column must contain the digits 1-9 without duplicates.
 *   3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits
 *      1-9 without duplicates.
 * <p>
 * Return true if the Sudoku board is valid, otherwise return false.
 * <p>
 * Note: A board does not need to be full or be solvable to be valid.
 * <p>
 * Example 1:
 *   Input: a board where each digit appears at most once per row, column and
 *          3 x 3 box (empty cells are ".")
 *   Output: true
 * <p>
 * Example 2:
 *   Input: the same board, except the top-left 3 x 3 box contains two 1's
 *   Output: false
 * <p>
 * Constraints:
 *   board.length == 9
 *   board[i].length == 9
 *   board[i][j] is a digit 1-9 or '.'.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if (board.length == 0) return true;

        // Check rows
        for (char [] ele : board) {
            Set<Character> validNumber = new HashSet<>();
            for (char character : ele) {
                if (Character.isDigit(character)) {
                    if (!validNumber.add(character)) {
                        return false;
                    }
                }
            }
        }

        // Check columns
        for (int i = 0; i < board.length; i++) {
            Set<Character> validNumber = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (Character.isDigit(board[j][i])) {
                    if (!validNumber.add(board[j][i])) {
                        return false;
                    }
                }
            }
        }

        // Check 3 x 3 sub-boxes
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                Set<Character> validNumber = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char c = board[boxRow + i][boxCol + j];
                        if (Character.isDigit(c)) {
                            if (!validNumber.add(c)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    static void main() {
        ValidSudoku solution = new ValidSudoku();

        char[][][] testInputs = {
                // Example 1: valid, partially filled board
                board(
                        "53..7....",
                        "6..195...",
                        ".98....6.",
                        "8...6...3",
                        "4..8.3..1",
                        "7...2...6",
                        ".6....28.",
                        "...419..5",
                        "....8..79"),
                // Example 2: top-left box has two 1's
                board(
                        "1........",
                        ".1.......",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        "........."),
                // Empty board is valid
                board(
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        "........."),
                // Row duplicate only (different columns and boxes)
                board(
                        "1.......1",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        "........."),
                // Column duplicate only (different rows and boxes)
                board(
                        "1........",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        "1........"),
                // Box duplicate only (different rows and columns)
                board(
                        "1........",
                        ".........",
                        "..1......",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        ".........")
        };

        String[] names = {
                "valid partial board",
                "box duplicate (top-left)",
                "empty board",
                "row duplicate",
                "column duplicate",
                "box duplicate (diagonal)"
        };

        boolean[] expected = {true, false, true, false, false, false};

        int passed = 0;
        for (int i = 0; i < testInputs.length; i++) {
            boolean result = solution.isValidSudoku(testInputs[i]);
            boolean ok = result == expected[i];
            if (ok) passed++;
            System.out.printf(
                    "Test %d: %s | expected=%b | got=%b | %s%n",
                    i + 1, names[i], expected[i], result, ok ? "PASS" : "FAIL");
        }
        System.out.printf("%n%d/%d tests passed.%n", passed, testInputs.length);
    }

    // Builds a 9 x 9 board from nine 9-character row strings.
    private static char[][] board(String... rows) {
        return Arrays.stream(rows).map(String::toCharArray).toArray(char[][]::new);
    }
}
