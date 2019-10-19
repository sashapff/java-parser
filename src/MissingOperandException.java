public class MissingOperandException extends ParsingException {
    public MissingOperandException(int position) {
        super("Missing operand at position " + position);
    }
}