public class Add<T> extends AbstractBinaryOperation<T> {
    public Add(TripleExpression<T> firstExpression, TripleExpression<T> secondExpression, Operation<T> operation) {
        super(firstExpression, secondExpression, operation);
    }

    protected T calculate(T x, T y) throws OverflowException {
        return operation.add(x, y);
    }

}
