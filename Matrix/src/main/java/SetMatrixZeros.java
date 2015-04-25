import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rg029761 on 9/22/15.
 */
public class SetMatrixZeros {

    public static int[][] setMatrixZeros(int[][] array) {

        if(array.length == 0) {
            return array;
        }

        int numColumns = array[0].length;
        int numrows = array.length;

        //we just need to keep track of what row and column should be 0
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> columns = new HashSet<Integer>();

        for(int i = 0; i < numrows ; i++) {
            for(int j = 0 ; j < numColumns ; j++) {
                if(array[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        //now set rows and columns to 0s
        for(int row : rows) {
            for(int i = 0 ; i < numColumns ; i++) {
                array[row][i] = 0;
            }
        }

        for(int column : columns) {
            for(int i = 0 ; i < numrows ; i++) {
                array[i][column] = 0;
            }
        }
        return array;
    }

    //do this in place can be the next question.
}
