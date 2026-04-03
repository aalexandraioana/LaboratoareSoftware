package advanced;

public class NewIntCalculator extends ACalculator
{
    @Override
    public NewIntCalculator init (Object state)
    {
        this.state = (Integer) state;
        return this;
    }

    public NewIntCalculator add(Integer value)
    {
       this.state = (Integer) this.state + value;
        return this;
    }

    public NewIntCalculator subtract(Integer value)
    {
        this.state = (Integer) this.state - value;
        return this;
    }

    public NewIntCalculator multiply(Integer value)
    {
        this.state = (Integer) this.state * value;
        return this;
    }
}
