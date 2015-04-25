import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by rg029761 on 5/10/15.
 */
public class  CoinChange {
    private final int[] coins;
    private final int sum;
    private final int[] memo;

    public CoinChange(int[] coins, int sum) {
        this.coins = coins;
        this.sum = sum;
        memo = new int[sum + 1];
    }

    public int getMinNumberOfCoins() {
        return getMinNumberOfCoins(sum);
    }

    private int getMinNumberOfCoins(int sum) {
        if (memo[sum] != 0) {  // eliminate duplicated calculations
            return memo[sum];
        }
        if (sum == 0) {
            return 0;  // base case
        }
        int result = 0;
        for (int coin: coins) {
            if (coin <= sum) {
                result = Math.min(result, getMinNumberOfCoins(sum - coin)) + 1;
            }
        }
        memo[sum] = result;  // save for reuse
        return result;
    }

    public int getMinCoins2() {
        if(sum == 0) {
            return 0;
        }

        for(int i = 1 ; i < sum ; i++) {
            int min = Integer.MAX_VALUE;
            for(int coin : coins) {
                if(coin <= i) {
                    if(memo[i - coin] < min) {
                        min = memo[i - coin];
                    }
                }
            }
            memo[i] = 1 + min;
        }
        return memo[sum - 1];
    }
}
