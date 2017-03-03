import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by koemdzhiev on 02/03/2017.
 */
public class main {

    public static boolean isWithingSH(Date startSH, Date now, Date stopSH) {
        try {
            SimpleDateFormat parser = new SimpleDateFormat("HH:mm", Locale.UK);
            Date startTime = parser.parse(startSH.getHours() + ":" + startSH.getMinutes());
            Date endTime = parser.parse(stopSH.getHours() + ":" + stopSH.getMinutes());
            Date nowTime = parser.parse(now.getHours() + ":" + now.getMinutes());

            if (startTime.after(endTime)) {
                if (endTime.after(nowTime)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (startTime.before(nowTime) && endTime.after(nowTime)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (java.text.ParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance(Locale.UK);
        calendar.add(Calendar.DAY_OF_WEEK, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 20);
        calendar.set(Calendar.MINUTE, 0);

        Date StartSH = calendar.getTime();
        calendar.add(Calendar.DAY_OF_WEEK, 2);
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        Date StopSH = calendar.getTime();

        Calendar cal = Calendar.getInstance(Locale.UK);
        cal.set(Calendar.HOUR_OF_DAY, 5);
        cal.set(Calendar.MINUTE, 29);

        Date now = cal.getTime();

        if (isWithingSH(StartSH, now, StopSH)) {
            System.out.println("SLEEPING HOURS");
        } else {
            System.out.println("NOT SLEEPING HOURS");
        }


    }


}
