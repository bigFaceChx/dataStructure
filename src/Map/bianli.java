package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class bianli {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"chx");
        map.put(2,"wjc");
        map.put(3,"wyl");
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            String value=map.get(next);
            System.out.println("键为："+next+"，值为："+value);
        }
    }
}
