public class Abs<T> extends AbstractUnaryOperation<T> {
    public Abs(TripleExpression<T> x, Operation<T> operation) {
        super(x, operation);
    }

    protected T calculate(T x) throws OverflowException {
        return operation.abs(x);
    }

}
