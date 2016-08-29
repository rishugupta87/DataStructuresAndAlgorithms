package strings;

import org.junit.Test;

/**
 * Created by rg029761 on 11/5/15.
 */
public class IsStringNumberTest {

    @Test
    public void test1() {
        String str = "-21212";
        System.out.println(IsStringNumber.isNumeric(str));
    }

    @Test
    public void test2() {
        String str = "+21212,21323";
        System.out.println(IsStringNumber.isNumeric(str));
    }

    @Test
    public void test3() {
        String str = "+21212.21221";
        System.out.println(IsStringNumber.isNumeric(str));
    }

    @Test
    public void test4() {
        String str = "-21212.21221";
        System.out.println(IsStringNumber.isNumeric(str));
    }

    @Test
    public void test5() {
        String str = "213.212";
        System.out.println(IsStringNumber.isNumeric(str));
    }

    @Test
    public void test6() {
        String str = "333.323";
        System.out.println(IsStringNumber.isNumeric(str));
    }

    @Test
    public void test7() {
        String str = "$333.323sa";
        System.out.println(IsStringNumber.isNumeric(str));
    }

    @Test
    public void test9() {
        String str = "-333.56";
        System.out.println(IsStringNumber.isNumeric(str));
    }
}
