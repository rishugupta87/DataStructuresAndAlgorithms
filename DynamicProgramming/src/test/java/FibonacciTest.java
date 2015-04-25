import org.junit.Test;

/**
 * Created by rg029761 on 6/13/15.
 */
public class FibonacciTest {

    @Test
    public void testFib() {
        System.out.println(new Fibonacci().fib(7));
    }

    @Test
    public void testFib2() {
        System.out.println(new Fibonacci().fib2(8));
    }

    @Test
    public void testFib3() {
        System.out.println(new Fibonacci().fib3(8));
    }

}
