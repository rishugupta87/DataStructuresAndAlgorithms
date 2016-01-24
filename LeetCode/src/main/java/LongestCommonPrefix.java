import java.util.Arrays;

/**
 * Created by rg029761 on 1/8/16.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 1) {
            return strs[0];
        }

        int index = -1;

        //find the min length string
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if(str.length() < min) {
                min = str.length();
                index = i;
            }
        }

        if(index == -1) {
            return "";
        }

        String minLengthString = strs[index];
        char[] charArray = minLengthString.toCharArray();

        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            if(i != index) {
                char[] currCharArray = strs[i].toCharArray();
                while(j < min) {
                    if(currCharArray[j] == charArray[j]) {
                        j++;
                        continue;
                    } else {
                        //remove the last character and update min.
                        minLengthString = minLengthString.substring(0, minLengthString.length() - 1);
                        min--;
                    }
                }
            }
        }

        return minLengthString;
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0)  {
            return "";
        }
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }

    public static void main(String args[]) {
        String[] strs = {"Rishub", "Rish", "dsdd" , "Ript", "Rkl"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix2(strs));
    }
}
