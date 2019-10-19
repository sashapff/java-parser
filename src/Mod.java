public class Mod<T> extends AbstractBinaryOperation<T> {
    public Mod(TripleExpression<T> firstExpression, TripleExpression<T> secondExpression, Operation<T> operation) {
        super(firstExpression, secondExpression, operation);
    }

    protected T calculate(T x, T y) throws IllegalOperationException {
        return operation.mod(x, y);
    }

}