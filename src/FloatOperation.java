public class FloatOperation implements Operation<Float> {
    public Float parseNumber(String x) {
        return Float.parseFloat(x);
    }

    public Float min(Float x, Float y) {
        return Math.min(x, y);
    }

    public Float max(Float x, Float y) {
        return Math.max(x, y);
    }

    public Float add(Float x, Float y) {
        return x + y;
    }

    public Float subtract(Float x, Float y) {
        return x - y;
    }

    public Float multiply(Float x, Float y) {
        return x * y;
    }

    public Float divide(Float x, Float y) {
        return x / y;
    }

    public Float negate(Float x) {
        return -x;
    }

    public Float abs(Float x) {
        return Math.abs(x);
    }

    public Float cast(int x) {
        return (float) x;
    }

    public Float square(Float x) {
        return x * x;
    }

    public Float mod(Float x, Float y) {
        return x % y;
    }

}
