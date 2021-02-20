package com.recursion.Iteration;

import java.util.ArrayList;
import java.util.List;

public class PhoneCombination {
    public static void main(String[] args) {
        PhoneCombination pc = new PhoneCombination();
        String digits = "23";
        List<String> res = pc.letterCombinations(digits);
        for (String r: res
             ) {
            System.out.println(r);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String[] mapping = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        combinations(result, digits,  "",0, mapping);
        return result;
    }

    public void combinations(List<String> result, String digits, String current, int index, String[] mapping){
        if( index == digits.length()){
            result.add(current);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for( int i  = 0; i< letters.length();i++){
            combinations(result, digits, current+letters.charAt(i), index+1, mapping);
        }
    }


}
