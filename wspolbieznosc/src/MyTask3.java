public class MyTask3 implements Task {

    @Override
    public void run(int taskNumber) throws InterruptedException {

        long t1=System.currentTimeMillis();

        while(t1+1000>System.currentTimeMillis())
        {
            Thread.yield();
        }
    }
}
//Thread.yield() daje szansę innym wątkom, to znaczy, że to czy uporządkowanie wątków się wykona nie jest pewne, nie zostanie wymuszone
//Thread.yield() is to give the executive chance to other threads, but Thread.sleep(0) will not, it'll just tell CPU that you should rearrange the executive threads including the current thread itself.
//
//Thread.yield() is just an advice which means it may not be accepted at all, but Thread.sleep(0) will do the rearrangement forcedly.
//w pewnym sensie oddaje swoją "kolej" innym wątkom i odbiera ją w kolejnej kolejce