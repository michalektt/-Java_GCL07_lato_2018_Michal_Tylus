public class RectangleCalculator {
    double a;
    double b;
    double pole;
    double obwod;

    public RectangleCalculator(double bok1, double bok2)
    {
        this.a=bok1;
        this.b=bok2;
    }

    public double calculateRectangle()
    {
        pole=a*b;
        return pole;
    }

    public double calculatePerimeter()
    {
        obwod=2*a+2*b;
        return obwod;
    }
}
