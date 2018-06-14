public class TriangleCalculator {
    double a;
    double b;
    double c;
    double h1,h2,h3;
    double pole;
    double obwod;

    public TriangleCalculator(double bok,double bok1, double bok2, double wysokosc)
    {
        this.a=bok;
        this.b=bok1;
        this.c=bok2;
        this.h1=wysokosc;
    }

    public double calculateTriangle()
    {
        pole=(a*h1)/2;
        return pole;
    }

    public double calculatePerimeter()
    {
        obwod=a+b+c;
        return obwod;
    }


}
