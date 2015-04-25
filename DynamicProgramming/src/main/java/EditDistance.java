/**
 * In computer science, edit distance is a way of quantifying how dissimilar two strings (e.g., words)
 * are to one another by counting the minimum number of operations required to transform one string into the other.
 * http://people.cs.clemson.edu/~bcdean/dp_practice/dp_8.swf
 *
 *
 */
public class EditDistance {

    private static int EDIT_COST = 1;

    private static int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }

    public static int dynamicEditDistance(final String str1, final String str2){
        int temp[][] = new int[str1.length()+1][str2.length()+1];

        for(int i=0; i < temp[0].length; i++){
            temp[0][i] = i;
        }

        for(int i=0; i < temp.length; i++){
            temp[i][0] = i;
        }

        for(int i=1;i <=str1.length(); i++){
            for(int j=1; j <= str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    temp[i][j] = temp[i-1][j-1];
                }else{
                    temp[i][j] = min(temp[i-1][j-1] + EDIT_COST,temp[i-1][j] + EDIT_COST,temp[i][j-1] + EDIT_COST);
                }
            }
        }
        return temp[str1.length()][str2.length()];
    }
}
