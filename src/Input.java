import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Input represents the game's ability to validate a players input.
 */
public class Input {
    /**
     * Enforces user input of letter-number coordinate
     * @param input
     * @return empty array | {int1, int2}
     */
    public static int[] validate(String input) {
        Pattern pattern = Pattern.compile("^[A-H][1-8]");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            int[] pos = Point.convert(input);
            return pos;
        }
        // User entered invalid coordinate.
        return new int[]{};
    }
}
