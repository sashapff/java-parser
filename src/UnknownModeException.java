public class UnknownModeException extends Exception {
    public UnknownModeException(final String nameOfMode) {
        super("Unknown name of Mode: " + nameOfMode);
    }
}
