import java.util.Scanner;

/**
 * Help represents the help page for users to learn the rules of the game.
 */
public class Help {
    /**
     * Launches help dialogue for Othello.
     */
    public static void display() {
        Scanner input = new Scanner(System.in);
        String quit = "start";
        while (!quit.equals("quit")) {
            System.out.println(
                    """
                            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                            |                                     Welcome to Help!                                     |
                            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                            Type 'quit' to exit.
                            
                            Outflank your opponent by jumping over there disk(s).                  
                               A  B  C  D  E  F  G  H
                            1         
                            2         
                            3         
                            4           W  B
                            5           B  W
                            6
                            7
                            8
                       
                               A  B  C  D  E  F  G  H
                            1         
                            2         
                            3         B
                            4         B  B
                            5         B  W
                            6
                            7
                            8
                       
                                                        
                               A  B  C  D  E  F  G  H
                            1         
                            2         
                            3         B
                            4         B  B
                            5      W  W  W
                            6
                            7
                            8
                       
                                            
                            The rules of Othello are simple:
                            1. Black always moves first.
                            2. If on your turn you cannot outflank and flip at least one opposing disk, 
                               your turn is forfeited and your opponent moves again. 
                               However, if a move is available to you, you may not forfeit your turn.
                            4. Players may not skip over their own colour disk(s) to outflank an opposing disk.
                            5. Disk(s) may only be outflanked as a direct result of a move and must fall 
                               in the direct line of the disk placed down.
                            6. All disks outflanked in any one move must be flipped, 
                               even if it is to the player's advantage not to flip them at all.                                                        
                            7. Once a disk is placed on a square, 
                               it can never be moved to another square later in the game.                                                        
                            8. When it is no longer possible for either player to move, the game is over. 
                               Disks are counted and the player with the majority of their colour showing is the winner.
                            """
            );
            quit = input.nextLine();
        }
    }
}
