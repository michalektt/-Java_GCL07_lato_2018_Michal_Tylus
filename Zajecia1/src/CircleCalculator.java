import static java.lang.Math.*;
public class CircleCalculator {

    double r;
    double pole;
    double L;

    public CircleCalculator(double promien){
        this.r=promien;
    }

    public double calculateCircle()
    {
        pole=PI*r*r;
        return pole;
    }

    public double calculatePerimeter()
    {
        L=2*PI*r;
        return L;
    }
}
