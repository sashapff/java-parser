public class Negate<T> extends AbstractUnaryOperation<T> {
    public Negate(TripleExpression<T> x, Operation<T> operation) {
        super(x, operation);
    }

    protected T calculate(T x) throws OverflowException {
        return operation.negate(x);
    }
}
