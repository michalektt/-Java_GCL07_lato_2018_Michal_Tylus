import java.util.Scanner;
interface Calculator {

    public static void main(String[] args) {

        SquareCalculator kwadrat=new SquareCalculator(5.12);
        CircleCalculator kolo=new CircleCalculator(4);
        TriangleCalculator trojkat=new TriangleCalculator(3,4,5,3);
        RectangleCalculator prostokat=new RectangleCalculator(12,5);

        int wybor=-1;
        Scanner odczyt=new Scanner(System.in);
        boolean loop=true;

        while(loop) {
            System.out.println("Wybierz:");
            wybor=odczyt.nextInt();
            switch (wybor) {
                case 1:
                    System.out.println("Pole kwadratu=" + kw1adrat.calculateSquare() + " Obwod=" + kwadrat.calculatePerimeter());
                    break;
                case 2:
                    System.out.println("Pole kola=" + kolo.calculateCircle() + " Obwod=" + kolo.calculatePerimeter());
                    break;
                case 3:
                    System.out.println("Pole trojkata=" + trojkat.calculateTriangle() + " Obwod=" + trojkat.calculatePerimeter());
                    break;
                case 4:
                    System.out.println("Pole prostokata=" + prostokat.calculateRectangle() + " Obwod=" + prostokat.calculatePerimeter());
                    break;
                case 5:
                    System.out.println("Konczenie pracy programu!");
                    loop=false;
                    break;
                default:
                    System.out.println("Podano zla liczbe!");
                     break;
            }
        }






    }
}
