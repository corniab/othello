import java.util.LinkedList;

/**
 * Abstract class that extends the linked list.
 */
abstract class Queue extends LinkedList<Boolean> {
    /**
     * Adds a boolean value to the first position of the queue
     * @param value
     */
    protected void enqueue(boolean value) {
        this.addFirst(value);
    }

    /**
     * Removes last value from queue
     */
    protected void dequeue() {
        this.removeLast();
    }
}
