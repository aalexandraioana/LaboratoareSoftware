package lab6;

public class DoubleCalculator  extends ACalculator<Double> {
    @Override
    DoubleCalculator init() {
        state = 0.0;
        return this;
    }

    public Double getState()
    {
        return (Double) this.state;
    }

    public  DoubleCalculator add(Double a) {
        state = (Double)state + a;
        return this;
    }

    public  DoubleCalculator subtract(Double a) {
        state = (Double)state - a;
        return this;
    }
    public  DoubleCalculator multiply(Double a) {
        state = (Double)state * a;
        return this;
    }
    public  DoubleCalculator divide(Double a) {
        state = (Double)state / a;
        return this;
    }
}
