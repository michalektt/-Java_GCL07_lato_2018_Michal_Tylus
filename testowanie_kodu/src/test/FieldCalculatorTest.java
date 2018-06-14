package test;

import Calculator.FieldCalculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static junit.framework.TestCase.assertEquals;

public class FieldCalculatorTest extends FieldCalculator {

    private FieldCalculator classUnderTest;


    @BeforeClass
    public static void onceExecutedBeforeAll(){
        System.out.println("@BeforeClass: onceExecutedBeforeAll FIELD");
    }

    @Before
    public void setUp() throws Exception {
        this.classUnderTest=new FieldCalculator();
        System.out.println("@Before: using Field Calculator");
    }

    @After
    public void tearDown() throws Exception {
        this.classUnderTest=null;// może pomóc garbage collector'owi
        System.out.println("@After: cleaning after Field Calculator");
    }

    @AfterClass
    public static void onceExecutedAfterAll() {
        System.out.println("@AfterClass: onceExecutedAfterAll FIELD");
    }

    @Test
    public void calculateSquareAssert() {
        assertEquals("AssertEquals Square test 1",calculateSquare(4),classUnderTest.calculateSquare(4),0);
        assertEquals("AssertEquals Square test 2",calculateSquare(3),classUnderTest.calculateSquare(3),0);
        assertEquals("AssertEquals Square test 3",calculateSquare(1232),classUnderTest.calculateSquare(1232),0);
    }

    @Test
    public void calculateSquare() {
        calculateSquare(4);
        calculateSquare(3);
        calculateSquare(1232);
    }

    @Test
    public void calculateCircleAssert() {
        assertEquals("AssertEquals Circle Test 1",calculateCircle(3),classUnderTest.calculateCircle(3),0);
        assertEquals("AssertEquals Circle Test 2",calculateCircle(12.5),classUnderTest.calculateCircle(12.5),0);
        assertEquals("AssertEquals Circle Test 3",calculateCircle(23),classUnderTest.calculateCircle(23),0);
    }

    @Test
    public void calculateCircle() {
        calculateCircle(3);
        calculateCircle(12.5);
        calculateCircle(23);
    }

    @Test
    public void calculateTriangleAssert() {
        assertEquals("AssertEquals Triangle test 1",calculateTriangle(12,5),classUnderTest.calculateTriangle(12,5),0);
        assertEquals("AssertEquals Triangle test 2",calculateTriangle(2,44),classUnderTest.calculateTriangle(2,44),0);
        assertEquals("AssertEquals Triangle test 3",calculateTriangle(113,134),classUnderTest.calculateTriangle(113,134),0);
    }

    @Test
    public void calculateTriangle() {
        calculateTriangle(12, 5);
        calculateTriangle(2, 44);
        calculateTriangle(113, 134);
    }

    @Test
    public void calculateRectangleAssert() {
        assertEquals("AssertEquals Rectangle test 1",calculateRectangle(11.3,123),classUnderTest.calculateRectangle(11.3,123),0);
        assertEquals("AssertEquals Rectangle test 2",calculateRectangle(3,4),classUnderTest.calculateRectangle(3,4),0);
        assertEquals("AssertEquals Rectangle test 3",calculateRectangle(2,2),classUnderTest.calculateRectangle(2,2),0);
    }
    @Test

    public void calculateRectangle() {
        calculateRectangle(11.3, 123);
        calculateRectangle(3, 4);
        calculateRectangle(2, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrownSquare() {
        FieldCalculatorTest tester = new FieldCalculatorTest();
        tester.calculateSquare(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrownRectangle() {
        FieldCalculatorTest tester = new FieldCalculatorTest();
        tester.calculateRectangle(-3, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrownTriangle() {
        FieldCalculatorTest tester = new FieldCalculatorTest();
        tester.calculateTriangle(-15, 12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrownCircle() {
        FieldCalculatorTest tester = new FieldCalculatorTest();
        tester.calculateCircle(-33);
    }
}