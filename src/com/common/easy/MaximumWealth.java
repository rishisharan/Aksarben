package com.common.easy;

public class MaximumWealth {
    public static void main(String[] args) {
       int[][] accounts = {{1,2,3},{3,2,1}};
       MaximumWealth mw = new MaximumWealth();

        System.out.println(mw.maximumWealth(accounts));
    }

    public int maximumWealth(int[][] accounts) {
        int max = 0, tot=0;
        int m = accounts.length;
        int n = accounts[0].length;

        for ( int i =0;i<m;i++){
            for( int j = 0; j< n;j++){
                tot += accounts[i][j];
            }
            if( tot > max){
                max = tot;
            }
                tot = 0;

        }
        return max;
    }
}
