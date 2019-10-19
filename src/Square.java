public class Square<T> extends AbstractUnaryOperation<T> {
    public Square(TripleExpression<T> expression, Operation<T> operation) {
        super(expression, operation);
    }

    protected T calculate(T x) throws OverflowException {
        return operation.square(x);
    }

}