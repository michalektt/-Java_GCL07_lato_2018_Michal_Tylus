package test;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import Calculator.BasicCalculator;

@RunWith(Parameterized.class)
public class testParametrized{
    private double inputNumber, inputNumber2, inputExpected;
    private BasicCalculator classUnderTest;
    @Before
    public void initialize() {
        classUnderTest=new BasicCalculator();
    }
    public  testParametrized(double inputNumber, double inputNumber2, double inputExpected){
        this.inputNumber = inputNumber;
        this.inputNumber2=inputNumber2;
        this.inputExpected=inputExpected;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers(){
        return Arrays.asList(new Object[][]{
                {2,4,6},
                {6,7,13},
                {5,6,11},
                {23,2,25},
                {4,4,8}
        });
    }

    @Test
    public void testSumParametrized(){
        assertEquals(inputExpected,classUnderTest.calculateSum(inputNumber,inputNumber2),0);
    }

}
