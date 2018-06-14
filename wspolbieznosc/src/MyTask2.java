public class MyTask2 implements Task {

    @Override
    public void run(int taskNumber) throws InterruptedException {
        Thread.sleep(1000); // wstrzymuje działąnie bieżąćego wątku okreśłoną liczbę milisekund
    }

}