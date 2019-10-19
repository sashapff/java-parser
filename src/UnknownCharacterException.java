public class UnknownCharacterException extends ParsingException {
    public UnknownCharacterException(int position) {
        super("Unknown character at position " + position);
    }
}