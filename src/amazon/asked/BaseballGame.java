package amazon.asked;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String ops[] = {"5","2","C","D","+"};
        BaseballGame bg = new BaseballGame();
        System.out.println(bg.calPoints(ops));
    }

    public int calPoints(String[] ops) {
        int result = 0;
        if( ops.length == 0)
            return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for ( int i = 0;i<ops.length;i++){
            String cur = ops[i];
            switch ( cur){
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                case "+":
                    int first = stack.pop();
                    int second = stack.peek() + first;
                    stack.push(first);
                    stack.push(second);
                    break;
                default:
                    int num = Integer.parseInt(cur);
                    stack.push(num);
                    break;
            }
        }
        while ( !stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
