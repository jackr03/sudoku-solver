import java.lang.Math;

class SudokuSolver {
    public static final int gridSize = 9;
    public static void main(String[] args) {
        final int[][] sudokuGrid = {{0, 9, 6, 3, 0, 0,},
                            {2, 3, 0, 0},
                            {0, 0, 0, 3},
                            {0, 0, 0, 0}};

        /*
                            final int[][] sudokuGrid2 = {{0, 1, 3, 2},
                                {2, 3, 4, 1},
                                {1, 4, 2, 3},
                                {3, 2, 1, 4}};

                                */

        printGrid(sudokuGrid);
        solveGrid(sudokuGrid);

    }

    public static boolean solveGrid(int[][] grid) {
    for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == 0) {
                    for (int k = 1; k < 5; k++) {
                        grid[i][j] = k;
                        printGrid(grid);
                        if (checkSquare(grid, i, j, k) == true) {
                            break;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean checkSquare(int[][] grid, int row, int col, int value) {
        int instances = -1;

        // Check row
        for (int i = 0; i < 4; i++) {
            if (grid[row][i] == value) {
                instances++;
            }
        }

        if (instances > 0) {
            return false;
        } else {
            instances = -1;
        }

        // Check column
        for (int j = 0; j < 4; j++) {
            if (grid[j][col] == value) {
                instances++;          
            }
        }

        if (instances > 0) {
            return false;
        } else {
            instances = -1;
        }

        // Check box
        int boxSize = (int) Math.sqrt(grid.length);
        int boxStartingRow = 2 * ((int) row / boxSize);
        int boxStartingCol = 2 * ((int) col / boxSize);

        for (int k = boxStartingRow; k != boxStartingRow + boxSize; k++) {
            for (int l = boxStartingCol; l != boxStartingCol + boxSize; l++) {
                if (grid[k][l] == value) {
                    instances++; 
                }
            }
        }

        if (instances > 0) {
            return false;
        } else {
            // do nothing as of now
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