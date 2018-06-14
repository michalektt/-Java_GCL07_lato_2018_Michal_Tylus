import java.util.concurrent.LinkedBlockingQueue;

public class Worker {

    private final Object lock = new Object();
    public LinkedBlockingQueue<Contener> tasks;
    WorkerListener listener;
    Thread watek;

    Worker(String name) {
        tasks = new LinkedBlockingQueue<Contener>();
    }

    boolean cont = true;
    boolean started = false;

    public synchronized void start() {

        if(watek !=null) {
            return;
        }

        String name="Worker" + "12" + "thread";

        watek =new Thread(name){

            @Override
            public void run() {
                int taskNumber=0;
                listener.onWorkerStarted();
                while (true) {
                    try {
                        Contener temp=tasks.take();

                        listener.onTaskStarted(taskNumber,temp.getName());
                        temp.getTask().run(taskNumber);
                        listener.onTaskCompleted(taskNumber,temp.getName());
                        ++taskNumber;

                    } catch (InterruptedException e) {
                        break;
                    }
                }
                listener.onWorkerStoped();
            }
        };
        watek.start();
    }


    synchronized void enqueueTask(String taskName, Task task) throws InterruptedException {
        Contener temp=new Contener(task,taskName);
        tasks.put(temp);
        notify();
    }

    public synchronized void stop() {

        if(watek ==null)
            return;

        System.out.println("Zatrzymuję działający wątek.");
        watek.interrupt();
        watek =null;
    }

    void setListener(WorkerListener wl) {
        listener = wl;
    }

    boolean isStarted() {
        if (started)
            return true;
        else
            return false;
    }

}