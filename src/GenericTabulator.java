public class GenericTabulator implements Tabulator {
    public Object[][][] tabulate(String mode, String stringExpression, int x1, int x2, int y1, int y2, int z1, int z2) throws UnknownModeException {
        return makeTable(getOperation(mode), stringExpression, x1, x2, y1, y2, z1, z2);
    }

    private Operation<?> getOperation(final String mode) throws UnknownModeException {
        switch (mode) {
            case "i":
                return new IntegerOperation(true);
            case "d":
                return new DoubleOperation();
            case "bi":
                return new BigIntegerOperation();
            case "u":
                return new IntegerOperation(false);
            case "f":
                return new FloatOperation();
            case "b":
                return new ByteOperation();
        }
        throw new UnknownModeException(mode);
    }

    private <T> Object[][][] makeTable(Operation<T> operation, String stringExpression, int x1, int x2, int y1, int y2, int z1, int z2) throws UnknownModeException {
        Object[][][] result = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        Parser<T> parser = new ExpressionParser<>(operation);
        TripleExpression<T> expression;
        try {
            expression = parser.parse(stringExpression);
        } catch (Exception e) {
            return result;
        }
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int k = z1; k <= z2; k++) {
                    try {
                        result[i - x1][j - y1][k - z1] = expression.evaluate(
                                operation.cast(i),
                                operation.cast(j),
                                operation.cast(k));
                    } catch (EvaluatingException e) {
                        result[i - x1][j - y1][k - z1] = null;
                    }
                }
            }
        }
        return result;
    }
}
