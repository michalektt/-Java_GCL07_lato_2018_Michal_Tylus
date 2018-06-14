package Calculator;

import test.BasicCalculatorTest;
import test.FieldCalculatorTest;

public class Main{
    public static void main(String[] args)
    {
        BasicCalculator basic=new BasicCalculator();
        FieldCalculator field=new FieldCalculator();

        System.out.println(basic.calculateSum(2,3));
        System.out.println(basic.calculateSqrt(5));

    }
}
