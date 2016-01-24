import java.util.ArrayList;
import java.util.List;

/**
 * Created by rg029761 on 1/9/16.
 */
public class GenerateNParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){
        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

    public static void main(String[] args) {
        System.out.println(new GenerateNParenthesis().generateParenthesis(3));
    }
}
