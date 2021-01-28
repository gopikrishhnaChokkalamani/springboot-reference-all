package com.mylearning.v1.graph;

import com.mylearning.v1.graph.disjointset.DisJointSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node implements Comparable<Node> {
  
  public int index;
  public String name;
  public Node parent;
  public List<Node> neighbors = new ArrayList<>();
  public Map<Node, Integer> neighborDistanceMap = new HashMap<>();
  public DisJointSet set;
  public int distance;
  public boolean visited;
  
  public Node(int index, String name) {
    this.index = index;
    this.name = name;
    this.distance = Integer.MAX_VALUE / 10;
  }
  
  @Override
  public int compareTo(Node o) {
    return this.distance - o.distance;
  }
}
