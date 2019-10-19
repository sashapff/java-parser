public class ExtraOpenBracketException extends ParsingException {
    public ExtraOpenBracketException(int position) {
        super("Extra opening bracket at position " + position);
    }
}