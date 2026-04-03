package lab5;

public class AdvancedCalculator extends IntCalculator
{
    public AdvancedCalculator(int state)
    {
        super(state);
    }
    public AdvancedCalculator divide (int value)
    {
        if (value != 0)
            this.state /= value;
        else
            System.out.println("Error");
        return this;
    }

    public AdvancedCalculator power (int value)
    {
        double result = Math.pow(this.state, value);
        this.state = (int) result;
        return this;
    }

    public AdvancedCalculator root (int value)
    {
        double result = 0;
        if (value != 0)
            result = Math.pow(this.state, (double) 1/value);
        else
            System.out.println("Error");
        this.state = (int) result;
        return this;
    }
}
