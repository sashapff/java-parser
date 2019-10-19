public abstract class AbstractUnaryOperation<T> implements TripleExpression<T> {
    public final Operation<T> operation;
    private TripleExpression<T> expression;

    public AbstractUnaryOperation(TripleExpression<T> expression, Operation<T> operation) {
        this.expression = expression;
        this.operation = operation;
    }

    protected abstract T calculate(T x) throws EvaluatingException;

    public T evaluate(T x, T y, T z) throws EvaluatingException {
        T current = expression.evaluate(x, y, z);
        return calculate(current);
    }

}
