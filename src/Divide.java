public class Divide<T> extends AbstractBinaryOperation<T> {
    public Divide(TripleExpression<T> firstExpression, TripleExpression<T> secondExpression, Operation<T> operation) {
        super(firstExpression, secondExpression, operation);
    }

    protected T calculate(T x, T y) throws OverflowException, IllegalOperationException {
        return operation.divide(x, y);
    }

}