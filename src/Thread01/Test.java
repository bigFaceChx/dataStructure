package Thread01;

public class Test {
    public static void main(String[] args) {
        wangzhan wangzhan = new wangzhan();
        Thread thread = new Thread(wangzhan);
        Thread thread01 = new Thread(wangzhan);
        Thread thread02 = new Thread(wangzhan);
        thread01.start();
        thread.start();
        thread02.start();

    }
}
