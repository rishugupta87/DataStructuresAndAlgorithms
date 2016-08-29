import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rg029761 on 7/5/15.
 */
public class SubsetSumTest {

    @Test
    public void test() {
        int arr[] = {2,3,7,8,10};
        System.out.println(SubsetSum.isSubsetSum(arr, 15, 14));
    }
    @Test
    public void test2() throws ParseException {
        String s1 = "10:00";
        String s2 = "13:21";
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date d1 = format.parse(s1);
        Date d2 = format.parse(s2);
        System.out.println(d2.getHours() - d1.getHours());
        System.out.println(d2.getMinutes() - d1.getMinutes());

        if(d2.getHours() - d1.getHours() == 0) {
            //return 2;
        }

    }
}
