import java.lang.Math;

class SudokuSolver {
    public static final int gridSize = 4;
    public static void main(String[] args) {
        final int[][] sudokuGrid = {{0, 4, 0, 1},
                            {3, 0, 4, 0},
                            {1, 0, 0, 4},
                            {0, 2, 1, 0}};

        final int[][] completedGrid = {{0, 1, 3, 2},
                                {2, 3, 4, 1},
                                {1, 4, 2, 3},
                                {3, 2, 1, 4}};

        if (solveGrid(completedGrid)) {
            printGrid(completedGrid);
        } else {
            System.out.println("The given sudoku grid has no possible solutions.");
        }
    }

    public static boolean solveGrid(int[][] grid) {
        return true;
    }

    public static boolean checkSquare(int[][] grid, int row, int col, int value) {
        // Check row
        for (int i = 0; i < 4; i++) {
            if (grid[row][i] == value) {
                return false;
            }
        }

        // Check column
        for (int j = 0; j < 4; j++) {
            if (grid[j][col] == value) {
                return false;
            }
        }

        // Check box
        int boxSize = (int) Math.sqrt(grid.length);
        int boxStartingRow = (int) row / boxSize;
        int boxStartingCol = (int) col / boxSize;

        for (int k = boxStartingRow; k == boxStartingRow + boxSize; k++) {
            for (int l = boxStartingCol; l == boxStartingCol + boxSize; l++) {
                if (grid[k][l] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printGrid(int[][] grid) {
        for (int[] i : grid) {
            for (int j : i) {
                System.out.print(j);
                System.out.print(" ");
            }
            
            System.out.println();
        }
            System.out.println();
    }
}