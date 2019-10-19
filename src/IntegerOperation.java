public class IntegerOperation implements Operation<Integer> {
    private boolean checkOverflow;

    IntegerOperation(boolean checkOverflow) {
        this.checkOverflow = checkOverflow;
    }

    public Integer parseNumber(String x) {
        return Integer.parseInt(x);
    }

    public Integer min(Integer x, Integer y) {
        return Math.min(x, y);
    }

    public Integer max(Integer x, Integer y) {
        return Math.max(x, y);
    }

    public Integer add(Integer x, Integer y) throws OverflowException {
        if (checkOverflow) {
            checkAdd(x, y);
        }
        return x + y;
    }

    private void checkAdd(Integer x, Integer y) throws OverflowException {
        if (x > 0 && Integer.MAX_VALUE - x < y) {
            throw new OverflowException();
        }
        if (x < 0 && Integer.MIN_VALUE - x > y) {
            throw new OverflowException();
        }
    }

    public Integer subtract(Integer x, Integer y) throws OverflowException {
        if (checkOverflow) {
            checkSubstract(x, y);
        }
        return x - y;
    }

    private void checkSubstract(Integer x, Integer y) throws OverflowException {
        if (x >= 0 && y < 0 && x - Integer.MAX_VALUE > y) {
            throw new OverflowException();
        }
        if (x <= 0 && y > 0 && Integer.MIN_VALUE - x > -y) {
            throw new OverflowException();
        }
    }

    public Integer multiply(Integer x, Integer y) throws OverflowException {
        if (checkOverflow) {
            checkMultiply(x, y);
        }
        return x * y;
    }

    private void checkMultiply(Integer x, Integer y) throws OverflowException {
        if (x > 0 && y > 0 && Integer.MAX_VALUE / x < y) {
            throw new OverflowException();
        }
        if (x > 0 && y < 0 && Integer.MIN_VALUE / x > y) {
            throw new OverflowException();
        }
        if (x < 0 && y > 0 && Integer.MIN_VALUE / y > x) {
            throw new OverflowException();
        }
        if (x < 0 && y < 0 && Integer.MAX_VALUE / x > y) {
            throw new OverflowException();
        }
    }

    public Integer divide(Integer x, Integer y) throws OverflowException, IllegalOperationException {
        checkDivide(x, y);
        return x / y;
    }

    private void checkDivide(Integer x, Integer y) throws OverflowException, IllegalOperationException {
        if (x == Integer.MIN_VALUE && y == -1 && checkOverflow) {
            throw new OverflowException();
        }
        if (y == 0) {
            throw new IllegalOperationException("Division by zero");
        }
    }

    public Integer mod(Integer x, Integer y) throws IllegalOperationException {
        checkMod(x, y);
        return x % y;
    }

    private void checkMod(Integer x, Integer y) throws IllegalOperationException {
        if (y == 0) {
            throw new IllegalOperationException("Division by zero");
        }
    }

    public Integer negate(Integer x) throws OverflowException {
        if (checkOverflow) {
            checkNegate(x);
        }
        return -x;
    }

    private void checkNegate(Integer x) throws OverflowException {
        if (x == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
    }

    public Integer abs(Integer x) throws OverflowException {
        if (checkOverflow) {
            checkAbs(x);
        }
        return Math.abs(x);
    }

    private void checkAbs(Integer x) throws OverflowException {
        if (x == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
    }

    public Integer square(Integer x) throws OverflowException {
        if (checkOverflow) {
            checkMultiply(x, x);
        }
        return x * x;
    }

    public Integer cast(int x) {
        return x;
    }

}
