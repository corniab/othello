import java.util.LinkedList;

/**
 * The PlayerQueue represents the state of the player's turns.
 * There are always two boolean values in the queue.
 * With each play of the game a new boolean value is enqueued
 * and an old value is dequeued.
 *
 * The boolean values represent each player's current ability to move.
 * As long as one of the players can move the game continues.
 * Here is an example of how this plays out.
 *
 * Player       Ability             Queue
 * -------------------------------------------
 * player 1     can move        →   [True, True]
 * player 2     can move        →   [True, True]
 * player 1     can't move      →   [False, True]
 * player 2     can move        →   [True, False]
 * player 1     can't move      →   [False, True]
 * player 2     can't move      →   [False, False]
 */
public class PlayerQueue extends Queue {

    /**
     * Constructor for PlayerQueue
     */
    public PlayerQueue() {
        this.add(true);
        this.add(true);
    }

    /**
     * Returns the current ability of the players to move.
     * @return true | false
     */
    public boolean checkQueue() {
        return this.getFirst() || this.getLast();
    }


    /**
     * Updates the queue.
     * Enqueues a new value and dequeues an old one
     * @param value
     */
    public void updateQueue(boolean value) {
        this.enqueue(value);
        this.dequeue();
    }


}