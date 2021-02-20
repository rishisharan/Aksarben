package com.recursion.Iteration;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {

    static List<String> al = new ArrayList<>();
    static List<String> bl = new ArrayList<>();
    static List<String> cl = new ArrayList<>();

    public static void main(String[] args) {
        String str = "ab";
        findSubsequence(str, "");
        System.out.println(al);
        findSubsequenceDayOne("abc", "");
        System.out.println(bl);
        findSubsequenceDayTwo("abcd", "");
        System.out.println(cl);
    }

    public static void findSubsequenceDayTwo(String str, String current){
        if( str.length() == 0){
            cl.add(current);
            return;
        }
        findSubsequenceDayTwo(str.substring(1),current+str.charAt(0));
        findSubsequenceDayTwo(str.substring(1), current);
    }

    public static void findSubsequenceDayOne(String str, String ans){
        if( str.length() == 0){
            bl.add(ans);
            return;
        }
        findSubsequenceDayOne(str.substring(1), ans+str.charAt(0));
        findSubsequenceDayOne(str.substring(1),ans);
    }

    public static void findSubsequence(String s, String ans){
        if( s.length() == 0){
            al.add(ans);
            return;
        }

        findSubsequence(s.substring(1), ans+s.charAt(0));
        findSubsequence(s.substring(1),ans);
    }
}
