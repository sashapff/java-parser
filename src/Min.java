public class Min<T> extends AbstractBinaryOperation<T> {
    public Min(TripleExpression<T> firstExpression, TripleExpression<T> secondExpression, Operation<T> operation) {
        super(firstExpression, secondExpression, operation);
    }

    protected T calculate(T x, T y) {
        return operation.min(x, y);
    }

}
