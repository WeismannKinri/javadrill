package JavaTime;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class CalendarDrill {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        calendar.setTime(date);
        calendar.setTime(timestamp);
        date = calendar.getTime();
    }


}
