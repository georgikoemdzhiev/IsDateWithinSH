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
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 20);
        calendar.set(Calendar.MINUTE, 0);

        Date startSleepingHours = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);


        Date stopSleepingHours = calendar.getTime();


        if (isWithingSH(startSleepingHours, now, stopSleepingHours)) {
            System.out.println("SLEEPING HOURS now:" + now.toString() + " startSH:" + startSleepingHours + " stopSH:" + stopSleepingHours.toString());

        } else {
            System.out.println("NOT SLEEPING HOURS now:" + now.toString() + " startSH:" + startSleepingHours + " stopSH:" + stopSleepingHours.toString());
        }


    }


}
