import org.junit.Test;

import java.util.Arrays;

/**
 * Created by rg029761 on 9/22/15.
 */
public class SetMatrixTest {

    @Test
    public void test1() {
        int arrA[][] = {
                { 1, 2, 3,  4},
                { 0, 8, 9, 10},
                { 1, 0, 11, 0},
        };
        int[][] newMatrix = SetMatrixZeros.setMatrixZeros(arrA);
        System.out.println(Arrays.deepToString(newMatrix));
    }

    @Test
    public void test2() {
        int arrA[][] = {
                { 1, 2, 3,  4},
                { 0, 8, 9, 10},
                { 1, 3, 2, 2},
        };
        int[][] newMatrix = SetMatrixZeros.setMatrixZeros(arrA);
        System.out.println(Arrays.deepToString(newMatrix));
    }
}
