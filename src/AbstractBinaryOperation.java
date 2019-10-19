public abstract class AbstractBinaryOperation<T> implements TripleExpression<T> {
    protected final Operation<T> operation;
    private TripleExpression<T> firstExpression, secondExpression;

    protected AbstractBinaryOperation(TripleExpression<T> firstExpression, TripleExpression<T> secondExpression,
                                      Operation<T> operation) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
        this.operation = operation;
    }

    protected abstract T calculate(T x, T y) throws EvaluatingException;

    public T evaluate(T x, T y, T z) throws EvaluatingException {
        T first = firstExpression.evaluate(x, y, z);
        T second = secondExpression.evaluate(x, y, z);
        return calculate(first, second);
    }

}
