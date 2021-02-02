package com.mylearning.v1.problems.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {
  
  public static void main(String[] args) {
    String  s = "abcabcbb";
    int i  = 0, j = 0, max = 0;
    Set<Character> set = new HashSet<>();
    while (i < s.length() && j < s.length()) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j));
        j++;
        max = Math.max(max, j - i);
      } else {
        set.remove(s.charAt(i));
        i++;
      }
    }
    System.out.println(max);
  }
}
