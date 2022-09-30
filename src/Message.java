/**
 * The message class creates and sets messages for the user based on their input.
 */
public class Message {
    private String header;
    private String content;
    private int[] pos;

    public Message () {
        header = "F0";
        content = "Let's Play!";
        pos = new int[]{};
    }

    /**
     * Get header
     */
    public String getHeader() {
        return header;
    }

    /**
     * Get content
     */
    public String getContent() {
        return content;
    }

    /**
     * Get Position
     */
    public int[] getPos() {
        return pos;
    }

    /**
     * Set Position
     */
    public void setPos(int[] value) {
        pos = value;
    }

    /**
     * Set Header
     */
    public void setHeader(String value) {
        header = value;
        setContent(value);
    }

    /**
     * Set content
     */
    private void setContent(String value) {
        switch (value) {
            case "F0" -> content = "Let's play! Type 'quit' to end and 'help' for help.";
            case "F1" -> content = "quit";
            case "F2" -> content = "help";
            case "F3" -> content = "Invalid Input.";
            case "F4" -> content = "Nice Play!";
            case "F5" -> content = "Can't move there!";
            case "F6" -> content = "Move not available!";
            default -> content = "Continue";
        }
    }


    /**
     * Static method for creating a message after validating the input.
     */
    public static Message createMessage(String input) {
        Message message = new Message();
        switch (input) {
            case "quit" -> message.setHeader("F1");
            case "help" -> message.setHeader("F2");
            default -> {
                int[] pos = Input.validate(input);
                if (pos.length > 0) {
                    message.setHeader("F4");
                    message.setPos(pos);
                } else {
                    message.setHeader("F3");
                }
            }
        }

        return message;
    }
}
