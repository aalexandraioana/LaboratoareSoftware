package advanced;

public class Lab5Adv
{
    public static void main(String []args)
    {
        NewIntCalculator newIntCalcObj = new NewIntCalculator();

        Object intResult = newIntCalcObj.init(10).add(5).subtract(3).multiply(2).result();

        DoubleCalculator doubleCalcObj = new DoubleCalculator();

        Object doubleResult = doubleCalcObj.init(10.0).add(5.0).subtract(3.3).multiply(2.2).result();

        System.out.println("(10 + 5 - 3 ) * 2 = " + intResult);
        System.out.println("(10 + 5 - 3.3 ) * 2.2 = " + doubleResult);
    }
}
