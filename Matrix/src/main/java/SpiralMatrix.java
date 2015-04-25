import java.util.Arrays;

/**
 * Created by rg029761 on 9/22/15.
 */
public class SpiralMatrix {
    private static int count = 1;
    /**
     *     1    2    3    4
     *     14   15   16   5
     *     13   20   17   6
     *     12   19   18   7
     *     11   10    9   9
     */
    public static int[][] populateSpiralMatrix(int[][] array) {

        if(array.length == 0) {
            return array;
        }

        int rowstart = 0; int rowend = array.length - 1;
        int colstart = 0; int colend = array[0].length - 1;

        while(rowstart <= rowend && colstart <= colend) {
            //popuate the -> 1,2,3,4
            for(int i = colstart ; i <= colend ; i++) {
                array[rowstart][i] = array[rowstart][i] + count;
                count++;
            }
            rowstart++;

            //populate the right column
            for(int i = rowstart ; i <= rowend ; i++) {
                array[i][colend] = array[i][colend] + count;
                count++;
            }
            colend--;

            if(rowstart < rowend) {
                //populate <-
                for(int i = colend ; i >= colstart ; i--) {
                    array[rowend][i] = array[rowend][i] + count;
                    count++;
                }
                rowend --;
            }


            if(colstart < colend) {
                //populate left column uowards
                for(int i = rowend ; i >= rowstart ; i--) {
                    array[i][colstart] = array[i][colstart] + count;
                    count++;
                }
                colstart++;
            }

        }
        return array;
    }

    public static void main(String args[]) {
        int arrA[][] = {    { 0, 0, 0, 0},
                            { 0, 0, 0, 0},
                            { 0, 0, 0, 0}
                        };
        int[][] newArray = populateSpiralMatrix(arrA);
        System.out.println(Arrays.deepToString(newArray));
    }
}
