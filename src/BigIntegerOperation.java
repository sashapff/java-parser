import java.math.BigInteger;

public class BigIntegerOperation implements Operation<BigInteger> {
    public BigInteger parseNumber(String x) {
        return new BigInteger(x);
    }

    public BigInteger min(BigInteger x, BigInteger y) {
        return x.min(y);
    }

    public BigInteger max(BigInteger x, BigInteger y) {
        return x.max(y);
    }

    public BigInteger add(BigInteger x, BigInteger y) {
        return x.add(y);
    }

    public BigInteger subtract(BigInteger x, BigInteger y) {
        return x.subtract(y);
    }

    public BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    public BigInteger divide(BigInteger x, BigInteger y) throws IllegalOperationException {
        if (y.equals(new BigInteger("0"))) {
            throw new IllegalOperationException("Division by zero");
        }
        return x.divide(y);
    }

    public BigInteger negate(BigInteger x) {
        return x.negate();
    }

    public BigInteger abs(BigInteger x) {
        return x.abs();
    }

    public BigInteger cast(int x) {
        return new BigInteger(Integer.toString(x));
    }

    public BigInteger square(BigInteger x) {
        return x.multiply(x);
    }

    public BigInteger mod(BigInteger x, BigInteger y) throws IllegalOperationException {
        if (y.equals(new BigInteger("0"))) {
            throw new IllegalOperationException("Division by zero");
        }
        if (y.compareTo(new BigInteger("0")) < 0) {
            throw new IllegalOperationException("Division by negative number");
        }
        return x.mod(y);
    }

}
