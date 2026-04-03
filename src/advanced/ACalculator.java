package advanced;

public abstract class ACalculator
{
    Object state;

    public Object result()
    {
        return this.state;
    }

    public Object clear()
    {
        this.state = 0;
        return this;
    }

    public abstract ACalculator init(Object n);
}
