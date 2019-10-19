public class ByteOperation implements Operation<Byte> {
    public Byte parseNumber(String x) {
        return Byte.parseByte(x);
    }

    public Byte min(Byte x, Byte y) {
        return (byte) Math.min(x, y);
    }

    public Byte max(Byte x, Byte y) {
        return (byte) Math.max(x, y);
    }

    public Byte add(Byte x, Byte y) {
        return (byte) (x + y);
    }

    public Byte subtract(Byte x, Byte y) {
        return (byte) (x - y);
    }

    public Byte multiply(Byte x, Byte y) {
        return (byte) (x * y);
    }

    public Byte divide(Byte x, Byte y) throws IllegalOperationException {
        if (y == 0) {
            throw new IllegalOperationException("Division by zero");
        }
        return (byte) (x / y);
    }

    public Byte negate(Byte x) {
        return (byte) -x;
    }

    public Byte abs(Byte x) {
        if (x >= 0) {
            return x;
        } else {
            return (byte) -x;
        }
    }

    public Byte cast(int x) {
        return (byte) x;
    }

    public Byte square(Byte x) {
        return (byte) (x * x);
    }

    public Byte mod(Byte x, Byte y) throws IllegalOperationException {
        if (y == 0) {
            throw new IllegalOperationException("Division by zero");
        }
        return (byte) (x % y);
    }

}
