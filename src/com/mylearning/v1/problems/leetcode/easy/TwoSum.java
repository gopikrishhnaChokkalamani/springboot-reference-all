package com.mylearning.v1.problems.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  
  public static void main(String[] args) {
    int[] arr = {2, 7, 11, 15};
    int sum = 9;
    int[] res = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int diff = sum - arr[i];
      if (map.containsKey(diff)) {
        System.out.println(Arrays.toString(new int[]{map.get(diff), i}));
        return;
      } else {
        map.put(arr[i], i);
      }
    }
  }
}
