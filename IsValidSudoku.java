
public class IsValidSudoku {

    // ✅ Check if placing num at (row, col) is valid according to Sudoku rules
    public boolean isvalid(char[][] board, int row, int col, char num) {
        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }

        // Check 3x3 sub-grid
        int srow = row / 3 * 3;
        int scol = col / 3 * 3;
        for (int i = srow; i < srow + 3; i++) {
            for (int j = scol; j < scol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    // ✅ Main function to validate entire Sudoku board
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    board[i][j] = '.'; // Temporarily remove the number
                    if (!isvalid(board, i, j, num)) return false;
                    board[i][j] = num; // Restore the number
                }
            }
        }
        return true;
    }
}
