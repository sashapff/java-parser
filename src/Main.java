public class Main {
    protected Main() throws UnknownModeException {
        System.out.println(new GenericTabulator().tabulate("i", "square -5", 1, 1, 1, 1, 1, 1)[0][0][0]);
    }

    public static void main(String[] args) throws UnknownModeException {
        new Main();
    }
}