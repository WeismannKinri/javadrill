package JavaTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class JavaUtilTime {
    public static void main(String[] args) {
        //It will show date
        System.out.println(fromStringToDate("2017-01-01"));
        //It will show the number of milliseconds since January 1, 1970
        System.out.println(fromStringToDate("2017-01-01").getTime());
        //It will get a string of a time
        System.out.println(fromDateToString(fromStringToDate("2017-01-01")));
    }

    public static Date fromStringToDate(String target) {
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = spf.parse(target);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String fromDateToString(Date date){
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
        String str = spf.format(date);
        return str;
    }

}
