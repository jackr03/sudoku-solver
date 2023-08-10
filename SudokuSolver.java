import java.lang.Math;
import java.util.Scanner;

class SudokuSolver {

    public static final int[][] sudokuBoard =

    public static final int gridSize = sudokuBoard.length;
    public static void main(String[] args) {
        printGrid(sudokuBoard);
        if (solveGrid(sudokuBoard)) {
            System.out.println("Sudoku board solved.");
        } else {
            System.out.println("No possible solutions.");
        }
    }

    public static boolean solveGrid(int[][] grid) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == 0) {
                    for (int k = 1; k < gridSize + 1; k++) {
                        grid[i][j] = k;
                        printGrid(grid);

                        if (checkSquare(grid, i, j, k)) { // current square + value works
                            if (solveGrid(grid)) { // call this method recursively, which will check the next square
                                return true;
                            }
                        } else if (!checkSquare(grid, i, j, k) && (k == gridSize)) { // no values have worked, must backtrack
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
        for (int i = 0; i < gridSize; i++) {
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
        for (int j = 0; j < gridSize; j++) {
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
        int boxSize = (int) Math.sqrt(gridSize);
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