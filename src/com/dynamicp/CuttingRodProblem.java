package com.dynamicp;

public class CuttingRodProblem {
    public static void main(String[] args) {
        int[] price = {1,5,8};
        CuttingRodProblem cp = new CuttingRodProblem();
        System.out.println(cp.resolveProblem(price, price.length));
    }

    public int resolveProblem( int[] price, int len){
        if( price.length == 0)
            return 0;
        int res = cutRod(price, len);
        return res;
    }

    private int cutRod(int[] price, int len){

        int val[] = new int[len+1];
        val[0] = 0;
        int i,j;
        for( i = 1;i<=len;i++){
            int max_val = Integer.MIN_VALUE;
            for( j = 0; j < i; j++)
                max_val = Math.max(max_val, price[j] + val[i - j - 1] );
            val[i] = max_val;
        }

        return val[len];
    }


}
