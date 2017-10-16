package JavaTime;

import java.text.SimpleDateFormat;

public class JavaSqlTime {
    public static void main(String[] args) {
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(utilDate.getTime());
        java.util.Date utilDate2  =new java.util.Date(sqlTimestamp.getTime());
    }


}
