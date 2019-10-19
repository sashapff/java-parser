public class UnknownNameException extends ParsingException {
    public UnknownNameException(int position) {
        super("Unknown name of variable or operation at position " + position);
    }
}