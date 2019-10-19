public class Subtract<T> extends AbstractBinaryOperation<T> {
    public Subtract(TripleExpression<T> firstExpression, TripleExpression<T> secondExpression, Operation<T> operation) {
        super(firstExpression, secondExpression, operation);
    }

    protected T calculate(T x, T y) throws OverflowException {
        return operation.subtract(x, y);
    }

}
