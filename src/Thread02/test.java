package Thread02;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<String> panzi = new ArrayList<>();
        Thread bzp = new Thread(new baozipu(panzi));
        Thread ch = new Thread(new chihuo(panzi));
        bzp.start();
        ch.start();


    }
}
