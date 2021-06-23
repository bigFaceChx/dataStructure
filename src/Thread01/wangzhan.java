package Thread01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class wangzhan implements Runnable{
    private int pickt=1000;
    private Object obj=new Object();
    Lock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true){
            lock.lock();
            try{
                if (pickt>0){
                    System.out.println("窗口："+Thread.currentThread().getName()+"出票，票号为："+pickt);
                    pickt--;
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    private void method01() {
        int i=1;
        while (true) {
            synchronized (obj) {
                if (pickt > 0) {
                    System.out.println("本窗口" + Thread.currentThread().getName() + "卖出的第：" + i + "张票");
                    i++;
                    pickt--;
                    System.out.println("还剩："+pickt+"张票");
                }
            }
        }
    }
}
