package test;
import java.util.Arrays;
import java.util.Collection;

import Calculator.BasicCalculator;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import static junit.framework.TestCase.assertEquals;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;



public class BasicCalculatorTest extends BasicCalculator{
    private Integer inputNumber,inputNumber2,inputExpected;

   private BasicCalculator classUnderTest;

   @BeforeClass
   public static void onceExecutedBeforeAll(){
       System.out.println("@BeforeClass: onceExecutedBeforeAll BASIC");
   }


   @Before
    public void setUp() throws Exception{
       classUnderTest=new BasicCalculator();
       System.out.println("@Before: using Basic Calculator");
   }


   @After
    public void tearDown() throws Exception{
       classUnderTest=null;
       System.out.println("@After: cleaning after Basic Calculator");
   }

    @AfterClass
    public static void onceExecutedAfterAll() {
        System.out.println("@AfterClass: onceExecutedAfterAll BASIC");
    }


    @Test(expected = IllegalArgumentException.class)
   public void testExceptionIsThrownSqrt(){
       BasicCalculatorTest tester=new BasicCalculatorTest();
       tester.calculateSqrt(-5);
   }

   @Test(expected=IllegalArgumentException.class)
   public void testExceptionIsThrownDivision(){
       BasicCalculatorTest tester=new BasicCalculatorTest();
       tester.calculateDivision(4,0);
   }

   @Test
    public void testAddAssert(){
       assertEquals("AssertEquals Add test 1",7,classUnderTest.calculateSum(3,4),0);
       assertEquals("AssertEquals Add test 2",200,classUnderTest.calculateSum(100,100),0);
       assertEquals("AssertEquals Add test 3",24,classUnderTest.calculateSum(20,4),0);
   }

   @Test
   public void testAdd()
   {
       calculateSum(3,5);
       calculateSum(-4,23434);
       calculateSum(12312,3343);
   }

   @Test
   public void testDifferenceAssert(){
       assertEquals("AssertEquals Difference test 1", 20,classUnderTest.calculateDifference(21,1),0);
       assertEquals("AssertEquals Difference test 2", 0,classUnderTest.calculateDifference(-1,-1),0);
       assertEquals("AssertEquals Difference test 3", -7,classUnderTest.calculateDifference(20,27),0);
   }

   @Test
   public void testDifference(){
       calculateDifference(3,7);
       calculateDifference(22,6);
       calculateDifference(2,2);
   }

   @Test
   public void testDivisionAssert(){
       assertEquals("AssertEquals Division test 1",5,classUnderTest.calculateDivision(25,5),0);
       assertEquals("AssertEquals Division test 2",2,classUnderTest.calculateDivision(20,10),0);
       assertEquals("AssertEquals Division test 3",-6,classUnderTest.calculateDivision(-24,4),0);
   }

   @Test
   public void testDivision(){
       calculateDivision(2,3);
       calculateDivision(34,6);
       calculateDivision(-123,3);
   }

   @Test
   public void testSqrtAssert(){
       assertEquals("AssertEquals Sqrt test 1",5,classUnderTest.calculateSqrt(25),0);
       assertEquals("AssertEquals Sqrt test 2",12,classUnderTest.calculateSqrt(144),0);
       assertEquals("AssertEquals Sqrt test 3",3,classUnderTest.calculateSqrt(9),0);
   }

   @Test
   public void testSqrt(){
       calculateSqrt(5);
       calculateSqrt(16);
       calculateSqrt(25);
   }

   @Test
   public void testPowAssert(){
       assertEquals("AssertEquals Exponentiation test 1",144,classUnderTest.calculatePow(12,2),0);
       assertEquals("AssertEquals Exponentiation test 2",4,classUnderTest.calculatePow(2,2),0);
       assertEquals("AssertEquals Exponentiation test 3",16,classUnderTest.calculatePow(4,2),0);
   }

   @Test
   public void testPow(){
       calculatePow(3,3);
       calculatePow(12,5);
       calculatePow(-32,7);
   }

   @Test
   public void testMultiAssert(){
       assertEquals("AssertEquals Multiplication test 1",25,classUnderTest.calculateMultiplication(5,5),0);
       assertEquals("AssertEquals Multiplication test 2",12,classUnderTest.calculateMultiplication(3,4),0);
       assertEquals("AssertEquals Multiplication test 3",-24,classUnderTest.calculateMultiplication(-6,4),0);
   }

   @Test
    public void testMulti(){
       calculateMultiplication(3,6);
       calculateMultiplication(22,-2);
       calculateMultiplication(0,123);
   }
}