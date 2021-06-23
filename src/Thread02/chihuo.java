package Thread02;

import java.util.List;

public class chihuo implements Runnable{
    private List<String> list;

    public chihuo(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        int i=100;
        while (i>=0) {
            synchronized (list) {
                //判断有无包子
                if (list != null) {
                    //有包子,则吃包子
                    String s = list.get(0);
                    System.out.println("我吃了一个：" + s);
                    list.remove(0);
                    //唤醒店铺线程
                    list.notify();
                    //线程等待
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            i--;
        }
    }
}
