package amazon.asked;

import java.util.*;

public class CutOffRank {
    public static void main(String[] args) {
        CutOffRank cf = new CutOffRank();
//        int cutOffRank = 3;
//        int num = 4;
//        Integer scores[] = { 100,50,50,25};

        int cutOffRank = 3;
        int num = 6;
        int scores[] = {100,2,2,2,2,2};
        System.out.println(cf.cutOffRank(cutOffRank, num, scores));
    }

    public int cutOffRank(int cutOffRank, int num, int[] scores) {
        int rank = 2, res = 0;
        int result[] = new int[scores.length];
        int[] arrCopy = Arrays.copyOf(scores,scores.length);
        Map<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        CutOffRank.reverse(arrCopy);
        result[0] = 1;

        for ( int i = 1;i<arrCopy.length;i++){
            if( arrCopy[i] == arrCopy[i-1])
                result[i] = result[i-1];
            else
                result[i] = rank;
            rank++;
        }

        for ( int r: result ) {
            if( r <= cutOffRank )
                res++;
        }
        return res;
    }

    public static void reverse(int[] num) {
        int temp = 0;
        for (int i  = 0; i < ( num.length - 1 ); i++) {
            for (int j = 0; j < num.length - i - 1; j++) {
                if (num[j] < num[j+1])
                {
                    temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }

    }


}
