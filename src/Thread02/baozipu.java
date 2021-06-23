package Thread02;

import java.util.List;

public class baozipu implements Runnable{
    private List<String> list;
    public baozipu(List<String> list) {
        this.list=list;
    }

    @Override
    public void run() {
        int i=100;
        while (i>=0) {
            synchronized (list) {
                    //生产包子
                    String baozi = "韭菜包";
                    System.out.println("我做了一个："+baozi);
                    list.add(baozi);
                    //唤醒吃货线程
                    list.notify();
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            i--;
        }
    }
}
