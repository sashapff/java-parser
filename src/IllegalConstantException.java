public class IllegalConstantException extends ParsingException {
    public IllegalConstantException(String s) {
        super("Constant '" + s + "' incorrect for int");
    }
}