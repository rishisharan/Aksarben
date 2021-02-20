package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {



    public static void main(String[] args) {
        int[] nums = {66,67,68};
        Permutations permutations = new Permutations();
        System.out.println( permutations.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if( nums.length == 0 ){
            return res;
        }

        boolean[] used = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();

        backTrack( nums,used, permutation,res);
        return res;
    }

    public void backTrack(int[] nums, boolean[] used, List<Integer> permutation, List<List<Integer>> res){
        if( nums.length == permutation.size()){
            res.add(new ArrayList<>(permutation));
            return;
        }
        for( int i = 0 ;i < nums.length; i++){
            if( used[i])
                continue;;
            used[i] = true;
            permutation.add(nums[i]);
            backTrack(nums,used,permutation,res);
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }
    }

}
