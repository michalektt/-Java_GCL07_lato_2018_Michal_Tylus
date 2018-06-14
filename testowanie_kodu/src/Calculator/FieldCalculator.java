package Calculator;

public class FieldCalculator {

    public double calculateSquare(double a)
    {
        if(a<0)
        {
            throw new IllegalArgumentException("Side is negative");
        }
        else
        {
            return a*a;
        }
    }
    public double calculateCircle(double r)
    {
        if (r<0)
        {
            throw new IllegalArgumentException("Ray is negative");
        }
        else
        {
            double field = Math.PI*r*r;
            return field;
        }
    }
    public double calculateTriangle(double a, double h)
    {
        if(a<0)
        {
            throw new IllegalArgumentException("Side is negative");
        }
        else if(h<0)
        {
            throw new IllegalArgumentException("Height is negative");
        }
        else
        {
            double field=a*h/2;
            return field;
        }
    }
    public double calculateRectangle(double a, double b)
    {
        if (a < 0) {
            throw new IllegalArgumentException("Side a is negative");
        } else if (b < 0) {
            throw new IllegalArgumentException("Side b is negative");
        } else {
            return a * b;
        }
    }
}
