import java.io.IOException;

/**
 * The terminal class interacts specifically with Windows powershell.
 * Could be modified to work with another.
 */
public class Terminal {
    /**
     * Clears the terminal.
     * @param arg
     * @throws InterruptedException
     * @throws IOException
     */
    public static void clear(String... arg) throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}

