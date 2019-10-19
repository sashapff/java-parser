public class ExtraCloseBracketException extends ParsingException {
    public ExtraCloseBracketException(int position) {
        super("Extra closing bracket at position " + position);
    }
}