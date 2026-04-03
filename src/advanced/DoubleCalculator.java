package advanced;

public class DoubleCalculator extends ACalculator
{
    @Override
    public DoubleCalculator init (Object state)
    {
        this.state = (Double) state;
        return this;
    }

    public DoubleCalculator add(Double value)
    {
        this.state = (Double) this.state + value;
        return this;
    }

    public DoubleCalculator subtract(Double value)
    {
        this.state = (Double) this.state - value;
        return this;
    }

    public DoubleCalculator multiply(Double value)
    {
        this.state = (Double) this.state * value;
        return this;
    }
}
