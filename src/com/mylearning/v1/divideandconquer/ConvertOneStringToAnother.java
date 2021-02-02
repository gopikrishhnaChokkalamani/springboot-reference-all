package com.mylearning.v1.divideandconquer;

public class ConvertOneStringToAnother {
  
  public static void main(String[] args) {
    String s1 = "table";
    String s2 = "tbres";
    System.out.println(convertString(s1, s2, 0, 0, "NA"));
  }
  
  private static int convertString(String s1, String s2, int s1Index, int s2Index, String op) {
    if (s1Index > s1.length() - 1) {
      return s2.length() - s2Index;
    }
    if (s2Index > s2.length() - 1) {
      return s1.length() - s1Index;
    }
    System.out.println(op);
    if (s1.charAt(s1Index) == s2.charAt(s2Index)) {
      return convertString(s1, s2, s1Index + 1, s2Index + 1, "EQUAL");
    }
    int insert = 1 + convertString(s1, s2, s1Index + 1, s2Index, "INSERT");
    int delete = 1 + convertString(s1, s2, s1Index, s2Index + 1, "DELETE");
    int replace = 1 + convertString(s1, s2, s1Index + 1, s2Index + 1, "REPLACE");
    return Math.min(insert, Math.min(delete, replace));
  }
}