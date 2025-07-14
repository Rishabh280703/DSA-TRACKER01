
public class SolveSudoku {

    static int check = 0; // Global flag to indicate if solution is found

    // Public method to start solving Sudoku
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0); // Start from cell (0,0)
        check = 0; // Reset for future reuse
    }

    // Recursive backtracking function
    private void solve(char[][] board, int row, int col) {
        // ✅ Base case: if all rows are processed, solution is found
        if (row == 9) {
            check = 1;
            return;
        }

        // ✅ If current cell is already filled, move to next cell
        if (board[row][col] != '.') {
            if (col == 8) {
                solve(board, row + 1, 0);
            } else {
                solve(board, row, col + 1);
            }
        } else {
            // ✅ Try placing digits from '1' to '9'
            for (char ch = '1'; ch <= '9'; ch++) {
                if (isValid(board, row, col, ch)) {
                    board[row][col] = ch; // Place digit

                    // Move to next cell
                    if (col == 8) {
                        solve(board, row + 1, 0);
                    } else {
                        solve(board, row, col + 1);
                    }

                    // ✅ If solution is found, exit recursion
                    if (check == 1) return;

                    // ❌ Backtrack if it didn't lead to a solution
                    board[row][col] = '.';
                }
            }
        }
    }

    // ✅ Check if placing num at (row, col) is valid
    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // Check 3x3 subgrid
        int sRow = (row / 3) * 3;
        int sCol = (col / 3) * 3;
        for (int i = sRow; i < sRow + 3; i++) {
            for (int j = sCol; j < sCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true; // Safe to place
    }
}
