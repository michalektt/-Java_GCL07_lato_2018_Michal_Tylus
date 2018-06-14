public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Główny wątek: Start");

        System.out.println("Główny wątek: Tworzę nowy wątek - worker");
        Worker taskThread = new Worker("worker");

        taskThread.setListener(new WorkerListener() {
            @Override
            public void onWorkerStarted() {
                System.out.println("Praca rozpoczęta");
            }

            @Override
            public void onWorkerStoped() {
                System.out.println("Worker zatrzymany.");
            }

            @Override
            public void onTaskStarted(int taskNumber, String taskName) {
                System.out.println("Zadanie rozpoczęte: " + taskNumber +" "+ taskName);
            }

            @Override
            public void onTaskCompleted(int taskNumber, String taskName) {
                System.out.println("Zadanie ukończone: " + taskNumber +" "+ taskName);
            }
        });

        taskThread.enqueueTask("Task1", new MyTask1());
        taskThread.enqueueTask("Task2", new MyTask2());
        taskThread.enqueueTask("Task3", new MyTask3());
        taskThread.enqueueTask("Task4",new MyTask1());
        taskThread.enqueueTask("Task5", new MyTask3());

        taskThread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        taskThread.enqueueTask("Task1", new MyTask2());
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        taskThread.enqueueTask("Task1", new MyTask1());
        taskThread.enqueueTask("Task2", new MyTask2());
        taskThread.enqueueTask("Task3", new MyTask3());
        taskThread.enqueueTask("Task4",new MyTask1());
        taskThread.enqueueTask("Task5", new MyTask3());

        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        taskThread.stop();

        System.out.println("Główny wątek: Koniec");
    }
}