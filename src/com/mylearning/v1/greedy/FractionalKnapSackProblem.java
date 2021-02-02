package com.mylearning.v1.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FractionalKnapSackProblem {
  
  public static void main(String[] args) {
    float totalWeight = 0;
    float totalCost = 0;
    float knapSackCapacity = 15;
    List<KnapSack> arr = Arrays.asList(new KnapSack(10, 2), new KnapSack(5, 3),
        new KnapSack(15, 5), new KnapSack(7, 7), new KnapSack(6, 1),
        new KnapSack(18, 4), new KnapSack(3, 1));
    List<KnapSack> sorted = arr.stream().sorted(Comparator.comparingDouble(KnapSack::getRatio).reversed()).collect(Collectors.toList());
    for (KnapSack sack : sorted) {
      if (totalWeight + sack.weight < knapSackCapacity) {
        totalWeight += sack.weight;
        totalCost += sack.cost;
        System.out.println(sack.weight + " added Weight, " + sack.cost + " added Cost");
        System.out.println("Total Weight " + totalWeight);
        System.out.println("Total Cost " + totalCost);
      } else {
        float fractionalWeight = sack.weight / sack.ratio;
        if (totalWeight + fractionalWeight < knapSackCapacity) {
          float fractionalCost = sack.cost / sack.ratio;
          totalWeight += fractionalWeight;
          totalCost += fractionalCost;
          System.out.println(fractionalWeight + " added Weight, " + fractionalCost + " added Cost");
          System.out.println("Total Weight " + totalWeight);
          System.out.println("Total Cost " + totalCost);
        }
      }
    }
  }
  
  public static class KnapSack {
    float cost;
    float weight;
    float ratio;
    
    public KnapSack(float cost, float weight) {
      this.cost = cost;
      this.weight = weight;
      this.ratio = cost / weight;
    }
    
    public float getCost() {
      return cost;
    }
    
    public void setCost(float cost) {
      this.cost = cost;
    }
    
    public float getWeight() {
      return weight;
    }
    
    public void setWeight(float weight) {
      this.weight = weight;
    }
    
    public float getRatio() {
      return ratio;
    }
    
    public void setRatio(float ratio) {
      this.ratio = ratio;
    }
  }
}
