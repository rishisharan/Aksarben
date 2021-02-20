package amazon.asked;

import java.util.Arrays;

public class MinimumDifficulty {
    public static void main(String[] args) {
        MinimumDifficulty md = new MinimumDifficulty();
        int [] jobDifficulty = {6,5,4,3,2,1};
        int days = 2;

//        int [] jobDifficulty = {9,9,9};
//        int days = 4;

        System.out.println(md.minDifficulty(jobDifficulty, days));
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        if( d > jobDifficulty.length)
            return -1;
        int[][] dp = new int[d+1][jobDifficulty.length];
        for(int[] p:dp){
            Arrays.fill(p,-1);
        }
        return dfs(jobDifficulty,dp, d, 0);
    }

    private int dfs(int[] jobDifficulty, int[][] dp, int days, int idx){
        if( days == 1 ){
            int max = 0;
            while( idx < jobDifficulty.length ) max = Math.max(max, jobDifficulty[idx++]);
            return max;
        }
        if( dp[days][idx] != -1) return dp[days][idx];
        int max = 0;
        int res = Integer.MAX_VALUE;
        for( int i = idx;i < jobDifficulty.length - days + 1 ;i++){
            max = Math.max(max, jobDifficulty[i]);
            res = Math.min(res, max +dfs(jobDifficulty, dp, days-1, i+1));
        }
        return dp[days][idx] = res;
    }
}
