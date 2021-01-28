package com.mylearning.v1.graph.disjointset;

import com.mylearning.v1.graph.Node;

public class UnDirectedEdge {

  public Node fromNode;
  public Node toNode;
  public int distance;

  public UnDirectedEdge(Node fromNode, Node toNode, int distance) {
    this.fromNode = fromNode;
    this.toNode = toNode;
    this.distance = distance;
  }
}
