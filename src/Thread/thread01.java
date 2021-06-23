package Thread;

public class thread01 {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        myThread myThread = new myThread();
        myThread.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("---我是线程01---");
            }
        }).start();

    }
}
