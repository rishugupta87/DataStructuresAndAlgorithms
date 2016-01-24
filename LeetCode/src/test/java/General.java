import org.junit.Test;

/**
 * Created by rg029761 on 1/5/16.
 */
public class General {

    @Test
    public void test() {
        String s = " 323 ";
        System.out.println(Integer.parseInt(s));
    }

    @Test
    public void test_Indexof() {
        String Str = new String("Welcome to Tutorialspoint.com");
        String SubStr1 = new String("Tutorials");
        String SubStr2 = new String("Sutorials");

        System.out.print("Found Index1 :" );
        System.out.println(Str.indexOf( 'o' ));

        System.out.print("Found Index2 :" );
        System.out.println(Str.indexOf( 'o', 5 ));

        System.out.print("Found Index3 :" );
        System.out.println( Str.indexOf( SubStr1 ));

        System.out.print("Found Index4 :" );
        System.out.println( Str.indexOf( SubStr1, 15 ));

        System.out.print("Found Index5 :" );
        System.out.println(Str.indexOf( SubStr2 ));
    }
}
