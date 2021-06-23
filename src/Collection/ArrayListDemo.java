package Collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        HashSet<customer>  set01 = new HashSet<>();
        set01.add(new customer("小王"));
        List<customer> arrayList = new ArrayList<customer>(set01);
        Iterator<customer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            customer next = iterator.next();
            System.out.println(next);
        }
    }
}
