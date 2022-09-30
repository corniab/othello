/**
 * The Point class represents coordinates that a user
 * will enter.
 */
public class Point {
    /**]
     * Converts a letter-number pair to a coordinate.
     * @param input Comes as 'A5' or 'B3' or ...
     * @return integer array with 2 points [5, 2]
     */
    public static int[] convert(String input) {
        String[] splitInput = input.split("");
        int point2 = splitInput[0].charAt(0) - 65;
        int point1 = Integer.parseInt(splitInput[1])-1;
        return new int[]{point1, point2};
    }
}
