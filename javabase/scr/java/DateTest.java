
import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.Date;
        import java.util.Scanner;

public class DateTest {
    /**存储时间段字符串 缓冲区*/
    public static StringBuffer pBuffer;
    /**标记一周起始日期天数 = 每周最后一天+1*/
    public static int num = 0;

    @SuppressWarnings("resource")
    public static void main(String args[]) {

        while(true){
            pBuffer = new StringBuffer();

//系统获取用户键盘输入行值
            Scanner in =new Scanner(System.in);
            System.out.println("\n请输入年份，例：2015");
            String INyear = in.nextLine();
            System.out.println("请输入月份，例：2");
            String INmonth = in.nextLine();
            String INdate = INyear+"/"+INmonth;

//获取系统当前时间,年月日
            Calendar NOWclr = Calendar.getInstance();
            NOWclr.setTime(new Date());
            int NOWyear = NOWclr.get(Calendar.YEAR);
            int NOWmonth = NOWclr.get(Calendar.MONTH)+1;
            int NOWday = NOWclr.get(Calendar.DAY_OF_MONTH);

            int INday = 0;
//获取用户输入时间，获取总天数
            Calendar SUMclr = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
            try {
                Date dates = sdf.parse(INdate);
                SUMclr.setTime(dates);
                SUMclr.setFirstDayOfWeek(Calendar.MONDAY);//设置一周为周一开始计算，系统默认为周日开始
                INday = SUMclr.getActualMaximum(Calendar.DATE);
                System.out.println(INdate+" 共计"+INday+"天"+SUMclr.getActualMaximum(Calendar.WEEK_OF_MONTH)+"周,周段获取结果如下：");
            } catch (ParseException e1) {
// TODO Auto-generated catch block
                e1.printStackTrace();
            }

//设置需要获取的日期格式
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
            sdf1.setLenient(false);
            SimpleDateFormat sdf2 = new SimpleDateFormat("EEE");


            if((INyear.equals(String.valueOf(NOWyear))) && (NOWmonth == Integer.parseInt(INmonth))){
                pBuffer = GETDate(NOWday, INdate);
                System.out.println("本月周分段按今日天数为最大值截取");
            } else if ((INyear.equals(String.valueOf(NOWyear))) && (Integer.parseInt(INmonth) > NOWmonth)) {
                System.out.println("输入的日期不合法");
            } else{
                pBuffer = GETDate(INday, INdate);
            }
            System.out.println(pBuffer.toString());
        }
    }


    /**
     * @param Day 这个月需获取的最大天数
     * @param Date 用户输入的当前 '年/月' 值
     */
    public static StringBuffer GETDate(int Day ,String Date ){

        StringBuffer buffer = new StringBuffer();

//设置需要获取的日期格式
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
        sdf1.setLenient(false);
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEE");
        for(int i = 1; i < Day+1; i++){
            try {
                Date date = sdf1.parse(Date + "/" + i);
                String Time = sdf1.format(date);//2015/02/08
                String PerDay = sdf2.format(date);//星期日
//System.out.println(Time + " : " + PerDay); //输出格式： 2015/02/08 : 星期日
                int index = 0;
                if(i == 1){
                    if(PerDay.equals("星期一")){
                        index = i+6;
                        buffer.append(GETsegment(index, Day, sdf1, Date, Time));
                    }else if (PerDay.equals("星期二")) {
                        index = i+5;
                        buffer.append(GETsegment(index, Day, sdf1, Date, Time));
                    }else if (PerDay.equals("星期三")) {
                        index = i+4;
                        buffer.append(GETsegment(index, Day, sdf1, Date, Time));
                    }else if (PerDay.equals("星期四")) {
                        index = i+3;
                        buffer.append(GETsegment(index, Day, sdf1, Date, Time));
                    }else if (PerDay.equals("星期五")) {
                        index = i+2;
                        buffer.append(GETsegment(index, Day, sdf1, Date, Time));
                    }else if (PerDay.equals("星期六")) {
                        index = i+1;
                        buffer.append(GETsegment(index, Day, sdf1, Date, Time));
                    }else{
                        num = i+1;
                        buffer.append(Time+"\n");
                    }
                }else if( Time.equals(sdf1.format(sdf1.parse(Date + "/" + num))) && (i != Day) ){
                    int id = i+6;
                    if( id < Day ){
                        num = i+7;
                        buffer.append(Time+"~"+sdf1.format(sdf1.parse(Date + "/" + id ))+"\n");
                    }
                }else if(i == Day){
                    if(PerDay.equals("星期一")){
                        buffer.append(Time+"\n");
                    }else if (PerDay.equals("星期二")) {
                        buffer.append(sdf1.format(sdf1.parse(Date + "/" + (i-1)))+"~"+Time+"\n");
                    }else if (PerDay.equals("星期三")) {
                        buffer.append(sdf1.format(sdf1.parse(Date + "/" + (i-2)))+"~"+Time+"\n");
                    }else if (PerDay.equals("星期四")) {
                        buffer.append(sdf1.format(sdf1.parse(Date + "/" + (i-3)))+"~"+Time+"\n");
                    }else if (PerDay.equals("星期五")) {
                        buffer.append(sdf1.format(sdf1.parse(Date + "/" + (i-4)))+"~"+Time+"\n");
                    }else if (PerDay.equals("星期六")) {
                        buffer.append(sdf1.format(sdf1.parse(Date + "/" + (i-5)))+"~"+Time+"\n");
                    }else{
                        buffer.append(sdf1.format(sdf1.parse(Date + "/" + (i-6)))+"~"+Time+"\n");
                    }
                }
            } catch (ParseException e) {
//do nothing
            }
        }
        return buffer;
    }

    /**
     * @Description 如果输入年月与今天符合，则判断能有效获取的周段区间值
     * @param index 周段最后一天的标识
     * @param Day 这个月需获取的最大天数
     * @param sdf1 日期设定格式
     * @param Date 用户输入的当前 '年/月' 值
     * @param Time for循环轮到的日期
     */
    public static String GETsegment(int index , int Day , SimpleDateFormat sdf1, String Date , String Time){
        String segment = "";
        try {
            if(index < Day){
                num = index + 1;
                segment = Time+"~"+sdf1.format(sdf1.parse(Date + "/" + index))+"\n";
            }else {
                if(Day != 1){
                    segment = Time+"~"+sdf1.format(sdf1.parse(Date + "/" + Day))+"\n";
                }else{
                    segment = Time+"\n";
                }
            }
        } catch (ParseException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return segment;
    }
}