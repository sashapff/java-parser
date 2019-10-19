public class ExpressionParser<T> implements Parser<T> {
    private StringTokenizer<T> stringTokenizer;
    private Operation<T> operation;

    public ExpressionParser(final Operation<T> operation) {
        this.operation = operation;
    }

    public TripleExpression<T> parse(String s) throws ParsingException, IllegalOperationException {
        stringTokenizer = new StringTokenizer<>(s, operation);
        return maxOrMin();
    }

    private TripleExpression<T> maxOrMin() throws ParsingException, IllegalOperationException {
        TripleExpression<T> current = addOrSubtract();
        while (true) {
            if (stringTokenizer.getToken() == Token.MAX) {
                current = new Max<>(current, addOrSubtract(), operation);
            } else if (stringTokenizer.getToken() == Token.MIN) {
                current = new Min<>(current, addOrSubtract(), operation);
            } else {
                return current;
            }
        }
    }

    private TripleExpression<T> addOrSubtract() throws ParsingException, IllegalOperationException {
        TripleExpression<T> current = multiplyOrDivide();
        while (true) {
            if (stringTokenizer.getToken() == Token.ADD) {
                current = new Add<>(current, multiplyOrDivide(), operation);
            } else if (stringTokenizer.getToken() == Token.SUBTRACT) {
                current = new Subtract<>(current, multiplyOrDivide(), operation);
            } else {
                return current;
            }
        }
    }

    private TripleExpression<T> multiplyOrDivide() throws ParsingException, IllegalOperationException {
        TripleExpression<T> current = otherOperations();
        while (true) {
            if (stringTokenizer.getToken() == Token.MULTIPLY) {
                current = new Multiply<>(current, otherOperations(), operation);
            } else if (stringTokenizer.getToken() == Token.DIVIDE) {
                current = new Divide<>(current, otherOperations(), operation);
            } else if (stringTokenizer.getToken() == Token.MOD) {
                current = new Mod<>(current, otherOperations(), operation);
            } else {
                return current;
            }
        }
    }

    private TripleExpression<T> otherOperations() throws ParsingException, IllegalOperationException {
        stringTokenizer.next();
        TripleExpression<T> current;
        if (stringTokenizer.getToken() == Token.NUMBER) {
            current = new Const<>(stringTokenizer.getValue());
            stringTokenizer.next();
        } else if (stringTokenizer.getToken() == Token.VARIABLE) {
            current = new Variable<>(stringTokenizer.getName());
            stringTokenizer.next();
        } else if (stringTokenizer.getToken() == Token.OPENBRACKET) {
            current = maxOrMin();
            if (stringTokenizer.getToken() != Token.CLOSEBRACKET) {
                throw new ExtraOpenBracketException(stringTokenizer.getIndex());
            }
            stringTokenizer.next();
        } else if (stringTokenizer.getToken() == Token.SUBTRACT) {
            current = new Negate<>(otherOperations(), operation);
        } else if (stringTokenizer.getToken() == Token.ABS) {
            current = new Abs<>(otherOperations(), operation);
        } else if (stringTokenizer.getToken() == Token.SQUARE) {
            current = new Square<>(otherOperations(), operation);
        } else {
            throw new ParsingException("Incorrect expression " + stringTokenizer.getExpression());
        }
        return current;
    }

}
