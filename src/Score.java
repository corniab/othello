/**
 * Represents the player's score.
 */
public class Score {
    int score1;
    int score2;
    String[][] grid;

    /**
     * Constructor function for Score class
     * @param grid 2D array representing a board
     */
    public Score(String[][] grid) {
        this.grid = grid;
        score1 = 0;
        score2 = 0;
    }

    /**
     * Prints the score to the display.
     */
    public void printScore() {
        String s1 = padScore(score1);
        String s2 = padScore(score2);
        System.out.println("");
        System.out.println("          ┌───────────────────┐");
        System.out.println("          │       SCORE       │");
        System.out.println("          ├────┬────┬────┬────┤");
        System.out.println("          │ B  │ " + s1 + " │ W  │ " + s2 + " │");
        System.out.println("          └────┴────┴────┴────┘");
    }

    /**
     * Updates the current score
     */
    public void updateScore() {
        score1 = 0;
        score2 = 0;
        for (String[] row : grid) {
            for (String cell : row) {
                if (cell.equals("B")) {
                    score1++;
                }
                else if (cell.equals("W")) {
                    score2++;
                }
            }
        }
    }

    /**
     * Pads integers less than 0 with a leading 0.
     * @param score
     * @return
     */
    private static String padScore(int score) {
        if (score < 10) {
            return "0" + score;
        } 
        return String.valueOf(score);
    }
}
