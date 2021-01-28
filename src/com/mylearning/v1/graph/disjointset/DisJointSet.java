package com.mylearning.v1.graph.disjointset;

import com.mylearning.v1.graph.Node;

import java.util.LinkedList;
import java.util.List;

public class DisJointSet {
  
  public List<Node> nodes = new LinkedList<>();
  
  public static void makeSet(List<Node> nodeList) {
    for (Node node : nodeList) {
      DisJointSet set = new DisJointSet();
      set.nodes.add(node);
      node.set = set;
    }
  }
  
  public static DisJointSet findSet(Node node) {
    return node.set;
  }
  
  public static DisJointSet union(Node firstNode, Node secondNode) {
    if (firstNode.set.equals(secondNode.set)) {
      return null;
    } else {
      DisJointSet set1 = firstNode.set;
      DisJointSet set2 = secondNode.set;
      if (set1.nodes.size() > set2.nodes.size()) {
        for (Node node : set2.nodes) {
          node.set = set1;
          set1.nodes.add(node);
        }
        return set1;
      } else {
        for (Node node : set1.nodes) {
          node.set = set2;
          set2.nodes.add(node);
        }
        return set2;
      }
    }
  }
  
  public void print() {
    for (Node node : nodes) {
      System.out.print(node.index + 1 + " ");
    }
    System.out.println();
  }
}