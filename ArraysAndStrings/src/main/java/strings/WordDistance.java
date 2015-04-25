package strings;

/**
 * Created by rg029761 on 11/4/15.
 */
public class WordDistance {

    public static int distance(String str,String a,String b){

        String[] strArray = str.split(" ");

        boolean isFoundA = false;
        boolean isFoundB = false;

        int min = Integer.MAX_VALUE;

        int distance = -1 ;
        for(String s : strArray) {
            distance ++ ;

            if(a.equals(s)) {
                distance = 0;
                isFoundA = true;
            } else if(b.equals(s)) {
                isFoundB = true;

                if(!isFoundA) { //you found b before a illegal
                    return -1;
                }

                if(distance < min) {
                    min = distance;
                }
            }
        }

        if(!isFoundA || !isFoundB) {
            return -1;
        }
        return min;
    }
}
