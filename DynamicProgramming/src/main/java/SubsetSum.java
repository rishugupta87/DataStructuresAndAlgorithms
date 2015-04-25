import java.util.Arrays;

/**
 * Created by rg029761 on 7/5/15.
 */
public class SubsetSum {

    /**
     * Given a set of non negative numbers and a total,
     * find if there exists a subset in this set whose sum is same as total.
     *
     * ex: sum = 11
     * set of elements = {2,3,7,8,10}
     * subsets = {3,8}
     */

    public static boolean isSubsetSum(final int[] set, int n, int sum) {
        final boolean[][] table = new boolean[set.length][n];

        //populate the table first column
        for(int k = 0 ; k < table.length ; k ++) {
            table[k][0] = true;
        }

        //populate the first row
        for(int k = 1 ; k < table[0].length ; k++) {
            if(set[0] == k) {
                table[0][k] = true;
            } else {
                table[0][k] = false;
            }
        }

        for(int i = 1 ; i < set.length; i++) {
            for(int j = 1 ; j < table[0].length ; j++) {
                if(set[i] > j) {
                    table[i][j] = table[i-1][j];
                } else {
                    table[i][j] = table[i-1][j] || table[i-1][j - set[i]];
                }
            }
        }

        System.out.println(Arrays.deepToString(table));

        return table[table.length - 1][sum];
    }
}
