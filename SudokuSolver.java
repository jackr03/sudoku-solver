import java.lang.Math;

class SudokuSolver {

    public static final int[][] sudokuBoard = {{4, 0, 0, 7, 3, 0, 0, 9, 0},
    {0, 0, 0, 0, 5, 0, 0, 0, 6},
    {0, 0, 0, 0, 0, 0, 8, 3, 0},
    {0, 0, 7, 4, 0, 0, 3, 1, 0},
    {0, 0, 2, 0, 0, 0, 6, 0, 0},
    {0, 5, 3, 0, 0, 1, 9, 0, 0},
    {0, 8, 1, 0, 0, 0, 0, 0, 0},
    {7, 0, 0, 0, 6, 0, 0, 0, 0},
    {0, 9, 0, 0, 2, 7, 0, 0, 8}};

    public static final int boardSize = sudokuBoard.length;
    public static void main(String[] args) {
        printGrid(sudokuBoard);
        if (solveGrid(sudokuBoard)) {
            System.out.println("Sudoku board solved.");
        } else {
            System.out.println("No possible solutions.");
        }
    }

    public static boolean solveGrid(int[][] grid) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (grid[i][j] == 0) {
                    for (int k = 1; k < boardSize + 1; k++) {
                        grid[i][j] = k;
                        printGrid(grid);

                        if (checkSquare(grid, i, j, k)) { // current square + value works
                            if (solveGrid(grid)) { // call this method recursively, which will check the next square
                                return true;
                            }
                        } else if (!checkSquare(grid, i, j, k) && (k == boardSize)) { // no values have worked, must backtrack
                            grid[i][j] = 0; // reset the current square to 0,
                            return false;
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
        for (int i = 0; i < boardSize; i++) {
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
        for (int j = 0; j < boardSize; j++) {
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
        int boxSize = (int) Math.sqrt(boardSize);
        int boxStartingRow = boxSize * ((int) row / boxSize);
        int boxStartingCol = boxSize * ((int) col / boxSize);

        for (int k = boxStartingRow; k != boxStartingRow + boxSize; k++) {
            for (int l = boxStartingCol; l != boxStartingCol + boxSize; l++) {
                if (grid[k][l] == value) {
                    instances++; 
                }
            }
        }

        if (instances > 0) {
            return false;
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