import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Search represents the ability of the game to search for
 * valid moves by players. This class provides essential logic
 * for gameplay to happen.
 */
public class Search {
    String[][] grid;
    private ArrayList<int[]> dirs;
    public Search(Board board) {
        this.grid = board.getGrid();
        this.dirs = new ArrayList<>();
        this.dirs.add(new int[]{-1, 0});     // N
        this.dirs.add(new int[]{-1, 1});     // NE
        this.dirs.add(new int[]{0, 1});      // E
        this.dirs.add(new int[]{1, 1});      // SE
        this.dirs.add(new int[]{1, 0});      // S
        this.dirs.add(new int[]{1, -1});     // SW
        this.dirs.add(new int[]{0, -1});     // W
        this.dirs.add(new int[]{-1, -1});    // NW
    }

    /**
     * Tests if the next position in the search is valid.
     * @param pos           starting cell of search [y, x]
     * @param color         players color "white" | "black"
     * @param grid          8x8 2d array
     * @param stack         builds the path of coords we are searching
     * @return              true | false
     */
    private boolean valid_move(
            int[]               pos,
            String              color,
            String[][]          grid,
            LinkedList<int[]>   stack
    ) {
        // Assign position values
        int currY = pos[0]; int currX = pos[1];

        // Must stay within boundaries of grid
        int size = grid.length - 1;
        if (!(currY >= 0 && currY <= size && currX >=0 && currX <= size)){
            return false;
        }

        // First move must be an empty cell
        if (stack.size() < 1 && !" ".equals(grid[currY][currX])) {
                return false;
            }


        // Adjacent cell must be opposite color
        if (stack.size() == 1 && color.equals(grid[currY][currX])){
            return false;
        }

        // No empty spaces after first move
        if (stack.size() > 0 && " ".equals(grid[currY][currX])){
            return false;
        }

        return true;
    }

    /**
     * Modifies coordinates array in place.
     * Performs recursive search of grid.
     * @param pos           starting cell of search [y, x]
     * @param color         players color "W" | "B"
     * @param grid          8x8 2d array
     * @param dirs          list of cardinal directions relative to grid
     * @param coordinates   stores potential paths for a move
     * @param stack         builds the path of coords we are searching
     * @return              stack
     */
    private LinkedList<int[]> searchGrid(
            int[]                           pos,
            String                          color,
            String[][]                      grid,
            ArrayList<int[]>                dirs,
            ArrayList<LinkedList<int[]>>    coordinates,
            LinkedList<int[]>               stack
    ) {
        // Assign position values
        int currY = pos[0]; int currX = pos[1];

        // Base Case 1: Invalid Move
        if (!valid_move(pos, color, grid, stack)) {
            // Return an empty linked list
            return new LinkedList<>();
        }

        // Base Case 2: End on a valid color
        if (color.equals(grid[currY][currX])) {
            // Return a copy of the stack
            LinkedList<int[]> stackCopy;
            stackCopy = (LinkedList<int[]>) stack.clone();
            return stackCopy;
        }

        // Add position to stack
        stack.add(pos);

        // Recursive Case: Update position
        for (int[] dir : dirs) {
            int dirY = dir[0]; int dirX = dir[1];
            int nextY = currY + dirY;
            int nextX = currX + dirX;

            // Search next position
            pos = new int[]{nextY, nextX};
            dirs = new ArrayList<int[]>();
            dirs.add(dir);
            LinkedList<int[]> returnStack = searchGrid(pos, color, grid, dirs, coordinates, stack);

            // Append returnStack to coordinates if it contains values
            if (returnStack.size() > 1) {
                coordinates.add(returnStack);
            }
        }
        // Backtrack
        stack.removeLast();
        return new LinkedList<>();
    }

    /**
     * Modifies coordinates array in place using recursive search
     * @param pos           starting cell of search [y, x]
     * @param color         players color "white" | "black"
     * @param coordinates   stores potential paths for a move
     */
    public void makeMove(
            int[]                           pos,
            String                          color,
            ArrayList<LinkedList<int[]>> coordinates
    ) {
        // Create stack
        LinkedList<int[]> stack = new LinkedList<>();

        // Begin recursive search
        searchGrid(pos, color, this.grid, this.dirs, coordinates, stack);
    }

    /**
     * Determines if player has available moves.
     * @return true | false
     */
    public boolean moveAvailable(String color) {

        // Begin search from first empty cell
        // Return true at first available match
        int currY = 0;
        for (String[] row : this.grid) {
            int currX = 0;
            for (String cell : row) {
                if (cell.equals(" ")) {
                    // Initialize parameters
                    int[] pos = {currY, currX};
                    LinkedList<int[]> stack = new LinkedList<>();
                    ArrayList<LinkedList<int[]>> coordinates = new ArrayList<>();

                    // Perform recursive search
                    this.searchGrid(pos, color, this.grid, this.dirs, coordinates, stack);

                    // Check if there is an available path for current player to move
                    if (coordinates.size() > 0) {
                        return true;
                    }
                }
                // Increment x index
                currX++;
            }
            // Increment y index
            currY++;
        }
        // No available moves
        return false;
    }
}
