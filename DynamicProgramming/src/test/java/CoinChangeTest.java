import org.junit.Test;

/**
 * Created by rg029761 on 5/10/15.
 */
public class CoinChangeTest {


    @Test
    public void testCoinChange2() {
        int[] coins = {1, 5, 6 , 8};
        CoinChange coinChange = new CoinChange(coins, 11);
        System.out.println(coinChange.getMinCoins2());
    }
}
