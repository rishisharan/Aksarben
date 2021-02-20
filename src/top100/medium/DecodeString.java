package top100.medium;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        String result = decodeString.decodeString("3[a]2[bc]");
        for ( int i =0;i< result.length();i++){
            System.out.print(result.charAt(i));
        }
    }

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int index = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        while ( index < s.length() ) {
            if (Character.isDigit(s.charAt(index))) {
                int num = 0;
                while (Character.isDigit(s.charAt(index))) {
                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }
                numStack.push(num);
            }else if( s.charAt(index) == '['){
                stringStack.push(res.toString());
                res = new StringBuilder("");
                index++;
            }else if( s.charAt(index) == ']'){
                int repeatTimes = numStack.pop();
                StringBuilder temp = new StringBuilder(stringStack.pop());
                for( int i = 0;i< repeatTimes;i++){
                    temp.append(res);
                }
                res = temp;
                index++;
            }else {
                res.append(s.charAt(index++));
            }
        }
        return res.toString();
    }
}
