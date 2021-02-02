package com.mylearning.v1.problems.leetcode.easy;

import java.util.Stack;

public class ValidParanthesis {
  
  public static void main(String[] args) {
    // String s = "()[]{}";
    //String s = "{[]}";
    String s = "((";
    //if the braces are in same order - no need of stack
    //    for (int i = 0; i < s.length() - 1; i+=2) {
    //      char fir = s.charAt(i);
    //      char sec = s.charAt(i + 1);
    //      if ((fir == '(' && sec == ')') || (fir == '[' && sec == ']') || (fir == '{' && sec == '}')) {
    //        continue;
    //      }
    //      System.out.println(false);
    //      break;
    //    }
    //    System.out.println(true);
    
    Stack<Character> stack = new Stack<>();
    //stack.push(s.charAt(0));
    for (int i = 0; i < s.length(); i++) {
      char n = s.charAt(i);
      if (n == '(' || n == '[' || n == '{') {
        stack.push(n);
      } else if (n == ')' || n == ']' || n == '}') {
        if (!stack.isEmpty()) {
          char c = stack.pop();
          if ((c == '(' && n == ')') || (c == '[' && n == ']') || (c == '{' && n == '}')) {
            continue;
          }
        }
        System.out.println(false);
        return;
      }
    }
    if (!stack.isEmpty()) {
      System.out.println(false);
      return;
    }
    System.out.println(true);
  }
}
