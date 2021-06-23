package Thread;

public class myThread extends Thread {
    @Override
    public void run() {
        System.out.println("我是myThread01");
        Thread thread = Thread.currentThread();
        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----");
    }
}
