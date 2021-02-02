package com.mylearning.v1.problems.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
  
  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("I", 1);
    map.put("IV", 4);
    map.put("V", 5);
    map.put("IX", 9);
    map.put("X", 10);
    map.put("XL", 40);
    map.put("L", 50);
    map.put("XC", 90);
    map.put("C", 100);
    map.put("CD", 400);
    map.put("D", 500);
    map.put("CM", 900);
    map.put("M", 1000);
    
    String s = "III";
    int i = 0;
    int j = 1;
    int sum = 0;
    while (i != s.length() && j != s.length()) {
      if (map.get(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(j))) != null)  {
        sum += map.get(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(j)));
        i = j + 1;
        j = j + 2;
      } else {
        sum += map.get(String.valueOf(s.charAt(i)));
        i++;
        j++;
      }
    }
    for (int k = i; i < s.length(); i++) {
      sum += map.get(String.valueOf(s.charAt(k)));
    }
    System.out.println(sum);
  }
}
