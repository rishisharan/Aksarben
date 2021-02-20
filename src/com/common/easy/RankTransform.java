package com.common.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RankTransform {
    public static void main(String[] args) {
        Integer arr[] = {2,2,3,4,5};
    //    Integer arr[] = {100,50,50,25};
//        Integer arr[] = {2,2,2};
        RankTransform rt = new RankTransform();
        int[] res = rt.arrayRankTransform(arr);
        for (int r:res
             ) {
            System.out.print(r+" ");
        }
    }

    public int[] arrayRankTransform(Integer[] arr) {
        Map<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        Integer[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCopy, Collections.reverseOrder());

        int counter= 1;
        for(int i =0; i<arr.length; i++){
            if(!mapper.containsKey(arrCopy[i])){
                mapper.put(arrCopy[i], counter);
                counter++;
            }
        }
        int rank = 2;
        int[] result = new int[arr.length];
        result[0] = 1;
        for(int i = 1;i<arrCopy.length;i++){
            if( arrCopy[i] == arrCopy[i-1])
                result[i] = result[i-1];
            else
                result[i] = mapper.get(arrCopy[i]);;
            rank++;
        }
        return result;
    }
}
