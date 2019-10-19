public class DoubleOperation implements Operation<Double> {
    public Double parseNumber(String x) {
        return Double.parseDouble(x);
    }

    public Double min(Double x, Double y) {
        return Math.min(x, y);
    }

    public Double max(Double x, Double y) {
        return Math.max(x, y);
    }

    public Double add(Double x, Double y) {
        return x + y;
    }

    public Double subtract(Double x, Double y) {
        return x - y;
    }

    public Double multiply(Double x, Double y) {
        return x * y;
    }

    public Double divide(Double x, Double y) {
        return x / y;
    }

    public Double negate(Double x) {
        return -x;
    }

    public Double abs(Double x) {
        return Math.abs(x);
    }

    public Double cast(int x) {
        return (double) x;
    }

    public Double square(Double x) {
        return x * x;
    }

    public Double mod(Double x, Double y) {
        return x % y;
    }

}
