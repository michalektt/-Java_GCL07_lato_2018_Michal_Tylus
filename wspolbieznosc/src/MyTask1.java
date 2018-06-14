
public class MyTask1 implements Task{

    @Override
    public void run(int taskNumber) throws InterruptedException {

        long t1=System.currentTimeMillis();

        while(t1+1000>System.currentTimeMillis())
        {
            /*System.out.println(Math.pow(123123123,23123123));
            System.out.println(System.currentTimeMillis());
            System.out.println(Math.pow(123123123,23123));
            System.out.println(System.currentTimeMillis());
            System.out.println(Math.pow(123123123,4242343));
            System.out.println(System.currentTimeMillis());*/

            if(Thread.interrupted()) //sprawdza, czy metoda była przerwana
                break;
        }
    }
}
//currentMillis() zwraca obecny czas w milisekundach (czasami w 10 milisekund)