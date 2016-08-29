package array;

/**
 * Created by rg029761 on 7/30/15.
 */
public class FindElementIn2DArray {

    private static boolean findElement(final int[][] array, int num, int numOfRows , int numofCol) {

        int i = 0, j = numofCol - 1;
        while(i < numOfRows && j >= 0) {
            if(array[i][j] == num) {
                return true;
            } else if(num > array[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int[][] array =
                {{1,2,3,4},
                {6,7,8,9},
                {13,14,15,16},
                {17,18,19,20},
                {22,23,24,26}};

        int n = array.length;
        int m = array[0].length;

        System.out.println(findElement(array, 17, n, m));
    }
}
