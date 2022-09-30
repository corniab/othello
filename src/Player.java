import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Player class represents a player.
 * Though this implementation really should be a PlayerController with a separate player class.
 */
public class Player {
    // Declare objects
    public Search search;
    private Board board;
    private final String player1;
    private final String player2;

    String current;
    String next;
    public Player(Board board) {
        this.board = board;
        this.search = new Search(this.board);
        player1 = "B";
        player2 = "W";
        current = player1;
        next = player2;
    }

    /**
     * Updates the current player.
     */
    public void nextPlayer () {
        if (Objects.equals(current, player1)) {
            next = current;
            current = player2;
        } else {
            next = current;
            current = player1;
        }
    }

    /**
     * Takes a potential coordinate to play.
     * If there is a path found then the board is updated
     * Otherwise it returns false.
     * @param pos position of players move
     * @return true | false
     */
    public boolean play(int[] pos) {

        // Create coordinates array to store paths
        ArrayList<LinkedList<int[]>> coordinates = new ArrayList<>();

        // Begin recursive search
        search.makeMove(pos, current, coordinates);

        // Check if a path was found
        if (coordinates.size() > 0) {
            this.board.updateBoard(coordinates, current);
            return true;
        }
        return false;
    }

    /**
     * Checks if a move is available for the current player.
     * @return
     */
    public boolean canMove(){
        return search.moveAvailable(current);
    }
}
