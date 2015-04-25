import java.util.Arrays;

/**
 * Created by rg029761 on 10/3/15.
 */
public class SpiralMatrix2 {

    private static int count = 1;

    static int[][] spiralPrint(int m, int n, int[][] a)
    {
        int i, k = 0, l = 0;

    /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
    */

        while (k < m && l < n)
        {
        /* Print the first row from the remaining rows */
            for (i = l; i < n; ++i)
            {
                a[k][i] = a[k][i] + count;
                count++;
            }
            k++;

        /* Print the last column from the remaining columns */
            for (i = k; i < m; ++i)
            {
                a[i][n-1] = a[i][n-1] + count;
                count++;
            }
            n--;

        /* Print the last row from the remaining rows */
            if ( k < m)
            {
                for (i = n-1; i >= l; --i)
                {
                    a[m-1][i] = a[m-1][i] + count;
                    count++;
                }
                m--;
            }

        /* Print the first column from the remaining columns */
            if (l < n)
            {
                for (i = m-1; i >= k; --i)
                {
                    a[i][l] = a[i][l] + count;
                    count++;
                }
                l++;
            }
        }
        return a;
    }

    public static void main(String args[]) {
        int arrA[][] = {    { 0, 0, 0, 0},
                { 0, 0, 0, 0},
                { 0, 0, 0, 0}
        };
        int[][] newArray = spiralPrint(arrA.length, arrA[0].length, arrA);
        System.out.println(Arrays.deepToString(newArray));
    }
}
