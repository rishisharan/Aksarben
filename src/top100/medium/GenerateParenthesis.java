package top100.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> res = gp.generateParenthesis(3);
        for (String s: res
             ) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if( n == 0){
            return result;
        }
        workOnParenthesis("(",1,0,result,n);
        return result;
    }

    private void workOnParenthesis(String current, int open, int close, List<String> result, int n){
        if( current.length() == n * 2) {
            result.add(current);
            return;
        }

        if( open < n)
            workOnParenthesis(current+"(", open+1,close,result,n);
        if( close < open )
            workOnParenthesis(current+")",open,close+1,result,n);
    }
}
