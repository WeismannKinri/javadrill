package JavaTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class JavaTime {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.parse("2017-10-10 00:00:00.000");
        System.out.println(localDate);
    }
}
