import org.junit.Test;
import priorityqueues.Play;
import priorityqueues.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rg029761 on 10/25/15.
 */
public class PlayTest {

    @Test
    public void testArray() {
        int[] array = {1,56,78,10,5,90};
        Play.play1(array);
    }

    @Test
    public void testArray2() {
        int[] array = {56,78,10,5,90, 1};
        Play.play2(array);
    }

    @Test
    public void testObjects() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("B3425"));
        products.add(new Product("E2112"));
        products.add(new Product("D987"));
        products.add(new Product("A787"));
        products.add(new Product("F456"));
        Play.play3(products);
    }
}
