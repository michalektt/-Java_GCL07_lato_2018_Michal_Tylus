import static java.lang.Math.sqrt;

public class SquareCalculator {

    double pole;
    double a;
    double obwod;


    public SquareCalculator(double bok)
    {
        this.a=bok;
    }
    public double calculateSquare()
    {
        pole=a*a;
        return pole;
    }

    public double calculatePerimeter()
    {
        obwod=4*a;
        return obwod;
    }
}
