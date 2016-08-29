import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rg029761 on 5/23/16.
 */
public class Park {

    public int test2()  {
        String s1 = "00:22";
        String s2 = "00:42";
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(s1);
            d2 = format.parse(s2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //System.out.println(d2.getHours() - d1.getHours());
        //System.out.println(d2.getMinutes() - d1.getMinutes());

        if(d1.after(d2)) {
            return -1;
        }

        int cost = 2 ;


        if(d2.getHours() - d1.getHours() >= 1) {
            cost += 3;
            long diff = d2.getTime() - d1.getTime();
            long diffMinutes = diff / (60 *  1000) ;
            long hoursLeft = (diffMinutes - 60)/60;
            long minLeft = (diffMinutes - 60) % 60;
            if(minLeft > 0) {
                cost+= (1+ hoursLeft) * 4;
            } else {
                cost+= hoursLeft * 4;
            }
        } else if(d2.getMinutes() - d1.getMinutes() > 0) {
            cost+= 4;
        }

        System.out.println(cost);
        return 0;
    }

    public static void main(String args[]) throws ParseException {
        new Park().test2();
    }
}
