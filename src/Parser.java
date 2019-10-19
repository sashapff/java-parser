public interface Parser<T> {
    TripleExpression<T> parse(String expression) throws /* Change me */ Exception;
}