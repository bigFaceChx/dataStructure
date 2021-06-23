package ArrayList;

import java.util.ArrayList;

public class ArrayListDemo01 {
    public static void main(String[] args) {
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        System.out.println(arrayList);
        arrayList.remove(0);
        System.out.println(arrayList);
        arrayList.set(0,"d");
        System.out.println(arrayList);
        arrayList.set(1,"ji");
        System.out.println(arrayList);
        System.out.println(arrayList.get(1));
    }

}
