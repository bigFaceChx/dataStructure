package Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date01 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        Date date1 = new Date(15968415L);
        System.out.println(date1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }
}
