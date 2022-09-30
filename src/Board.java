import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Board represents the 8x8 game board in Othello.
 */
public class Board {
    private String[][] grid;
    public Board (){
        grid = new String[][]{
                //0    1    2    3    4    5    6    7    //
                {" ", " ", " ", " ", " ", " ", " ", " "}, // 0
                {" ", " ", " ", " ", " ", " ", " ", " "}, // 1
                {" ", " ", " ", " ", " ", " ", " ", " "}, // 2
                {" ", " ", " ", "B", "W", " ", " ", " "}, // 5
                {" ", " ", " ", "W", "B", " ", " ", " "}, // 4
                {" ", " ", " ", " ", " ", " ", " ", " "}, // 3
                {" ", " ", " ", " ", " ", " ", " ", " "}, // 6
                {" ", " ", " ", " ", " ", " ", " ", " "}  // 7
        };
    };

    /**
     * Sets the value of a cell by position
     * @param pos
     * @param color
     */
    private void setGrid(int[] pos, String color) {
        grid[pos[0]][pos[1]] = color;
    }

    /**
     * Getter for the grid
     * @return
     */
    public String[][] getGrid() {
        return grid;
    }

    /**
     * Prints the game board to the console.
     */
    public void printGrid() {
        // Print the x-axis identifiers
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("            A   B   C   D   E   F   G   H");
        System.out.println("          ┌───┬───┬───┬───┬───┬───┬───┬───┐");

        // Print the board
        int i = 1;
        for (String[] row : grid) {
            // Print the y-axis identifiers
            System.out.print("        " + i + " ");
            i++;
            for (String cell: row) {
                System.out.print("│ " + cell + " ");
            }
            System.out.print("│");
            System.out.println();
            if (i < 9){
                System.out.println("          ├───┼───┼───┼───┼───┼───┼───┼───┤");
            } else {
                System.out.println("          └───┴───┴───┴───┴───┴───┴───┴───┘");
            }
        }
    }

    /**
     * Updates the board with a set of coordinates.
     * @param coordinates
     * @param color
     */
    public void updateBoard(ArrayList<LinkedList<int[]>> coordinates, String color) {
        // Visit all the paths in coordinates
        for (LinkedList<int[]> path : coordinates) {
            for (int[] pos : path) {
                setGrid(pos, color);
            }
        }
    }

}
