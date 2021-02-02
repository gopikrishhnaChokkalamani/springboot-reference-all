package com.mylearning.v1.problems.leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInArray {
  
  public static void main(String[] args) {
    //int[] arr = {3, 2, 1, 5, 6, 4};
    int[] arr = {3,2,3,1,2,4,5,5,6};
    int k = 4;
    Queue<Integer> queue = new PriorityQueue<>();
    for (Integer i : arr) {
        queue.add(i);
      if (queue.size() > k) {
        queue.remove();
      }
    }
    int i = 0;
    System.out.println(queue.remove());
  }
}
