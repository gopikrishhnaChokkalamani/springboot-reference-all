package com.mylearning.v1.problems.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSwap {
  
  public static void main(String[] args) {
    List<Integer> l = Arrays.asList(3, 1, 2, 4);
   // List<Integer> l = Arrays.asList(3, 3, 1, 2);
//    List<Integer> l = Arrays.asList(78,
//        53,
//        58,
//        29,
//        34,
//        21,
//        73,
//        70,
//        10,
//        60,
//        33,
//        63,
//        24,
//        16,
//        30,
//        51,
//        71,
//        7,
//        20,
//        43,
//        18,
//        76,
//        14,
//        31,
//        23,
//        59,
//        41,
//        46,
//        25,
//        1,
//        32,
//        49,
//        69,
//        47,
//        65,
//        57,
//        56,
//        52,
//        12,
//        5,
//        62,
//        55,
//        72,
//        75,
//        42,
//        3,
//        35,
//        48,
//        68,
//        78,
//        11,
//        39,
//        22,
//        54,
//        64,
//        26,
//        67,
//        6,
//        61,
//        2,
//        9,
//        4,
//        37,
//        45,
//        8,
//        13,
//        19,
//        38,
//        44,
//        40,
//        36,
//        27,
//        15,
//        66,
//        28,
//        74,
//        17,
//        77,
//        50);
    int swapCount = 0;
    for (int j = 0; j < l.size(); j++) {
      int maxIndex = j;
      for (int i = j + 1; i < l.size(); i++) {
        if (l.get(i) > l.get(maxIndex)) {
          maxIndex = i;
        }
      }
      if (maxIndex != j) {
        swapCount++;
        int t = l.get(j);
        l.set(j, l.get(maxIndex));
        l.set(maxIndex, t);
//        int tempValue = l.get(maxIndex);
//        l.set(maxIndex, l.get(i));
//        l.set(i, tempValue);
      }
    }
    for (int i = 0; i < l.size(); i++) {
      System.out.print(l.get(i) + " ");
    }
    System.out.println();
    System.out.println("===>" + swapCount);
    System.out.println(minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7}));
  }
  
  static int minimumSwaps(int[] arr) {
    int s  = 0;
    for (int i = 0; i < arr.length; i++) {
      int min = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[min] > arr[j]) {
          min = j;
        }
      }
      if (min != i) {
        s++;
        int tmp = arr[min];
        arr[min] = arr[i];
        arr[i] = tmp;
      }
    }
    return s;
  }
}
