package lab6;

public abstract class ACalculator<T> {
    Object state;

    abstract <S extends ACalculator> S init();

    public T result() {
        return (T)state;
    }

    public void clear() {
        state = null;
    }

}
