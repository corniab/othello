import java.util.Scanner;

/**
 * Game represents the gameplay of Othello. It initializes and setups
 * new games and directs the logical flow of plays and user input.
 */
public class Game {
    Board board;
    Player player;
    PlayerQueue playerQueue;

    Score score;

    /**
     * Constructor class for game.
     */
    public Game() {
        this.board = new Board();
        this.player = new Player(this.board);
        this.playerQueue = new PlayerQueue();
        this.score = new Score(this.board.getGrid());
    }

    /**
     * Starts a new game.
     * @throws Exception
     */
    public void start() throws Exception {
        // Create reader for input
        Scanner reader = new Scanner(System.in);

        // Create Message
        Message message = new Message();

        // Start event loop
        while (!message.getHeader().equals("F1")) {
            // Clear Terminal
            Terminal.clear();

            // Print Score
            score.updateScore();
            score.printScore();

            // Print out Board
            this.board.printGrid();

            // Print out message
            System.out.println("          " + message.getContent());

            // Check if either player has move available
            if (playerQueue.checkQueue()) {

                // Check if current player has move
                if (player.canMove()) {

                    // Get input from user
                    System.out.print("          " + player.current + "'s turn: ");
                    String input = reader.nextLine();

                    // Validate input
                    message = Message.createMessage(input);

                    switch (message.getHeader()) {
                        // If user types 'quit' then continue
                        case "F1":
                            break;

                        // If user types 'help' then launch help then continue
                        case "F2":
                            Terminal.clear();
                            Help.display();
                            Terminal.clear();
                            break;

                            // If user types invalid input then continue
                        case "F3":
                            break;

                        // If user types valid input then make move, update board, update player, and update queue
                        case "F4":
                            if(player.play(message.getPos())) {
                                player.nextPlayer();
                                playerQueue.updateQueue(true);
                            }

                            // Player has available moves but tried to play an invalid move.
                            else {
                                message.setHeader("F5");
                            }
                            break;

                        default:
                            System.out.println("Unexpected value.");
                            throw new Exception();
                    }
                }

                // Current player does not have a move.
                else {
                    // Update queue, update player and set message
                    playerQueue.updateQueue(false);
                    player.nextPlayer();
                    message.setHeader("F6");
                }
            }

            // No moves available for either player. Game Over!
            else {
                message.setHeader("F1");
            }
        }
        Terminal.clear();

        // Show the final score
        score.updateScore();
        score.printScore();

        // Ask if user wants to play again
        System.out.print("Would you like to play again (y/n)?: ");
        String input = reader.nextLine();
        if (input.equals("y")) {
            Game game = new Game();
            game.start();
        }
        else {
            System.out.println("Thanks for playing!");
        }
    }
}