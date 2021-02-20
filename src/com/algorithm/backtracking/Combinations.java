package com.algorithm.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int[] nums = {50,51,52};
        Combinations combinations = new Combinations();
        System.out.println( combinations.combination(nums));
    }

    public List<List<Integer>> combination(int[] nums){
        List<List<Integer>> results = new LinkedList<>();
        performCombinations(nums, 0, results, new LinkedList<Integer>());
        return results;
    }

    public void performCombinations(int[] nums, int i, List<List<Integer>> results, List<Integer> path){
        if( i == nums.length){
            results.add(path);
            return;
        }
        List<Integer> pathWithCurrent = new LinkedList<>(path);
        pathWithCurrent.add(nums[i]);
        performCombinations(nums, i+1, results,  path);
        performCombinations(nums, i+1, results,  pathWithCurrent);

    }
}
