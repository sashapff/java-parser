interface Operation<T> {
    T parseNumber(final String x) throws IllegalConstantException;

    T min(T x, T y);

    T max(T x, T y);

    T add(T x, T y) throws OverflowException;

    T subtract(T x, T y) throws OverflowException;

    T multiply(T x, T y) throws OverflowException;

    T divide(T x, T y) throws OverflowException, IllegalOperationException;

    T negate(T x) throws OverflowException;

    T abs(T x) throws OverflowException;

    T cast(int x);

    T square(T x) throws OverflowException;

    T mod(T x, T y) throws IllegalOperationException;
}
