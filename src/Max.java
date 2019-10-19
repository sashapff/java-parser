public class Max<T> extends AbstractBinaryOperation<T> {
    public Max(TripleExpression<T> firstExpression, TripleExpression<T> secondExpression, Operation<T> operation) {
        super(firstExpression, secondExpression, operation);
    }

    protected T calculate(T x, T y) {
        return operation.max(x, y);
    }

}
