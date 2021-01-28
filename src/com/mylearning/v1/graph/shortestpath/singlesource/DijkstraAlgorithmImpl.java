package com.mylearning.v1.graph.shortestpath.singlesource;

import com.mylearning.v1.graph.GraphUtility;
import com.mylearning.v1.graph.Node;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class DijkstraAlgorithmImpl {
  
  public static void main(String[] args) {
    List<Node> nodes = GraphUtility.initializeNodes(7);
    DijkstraAlgorithmImpl d = new DijkstraAlgorithmImpl(nodes);
    GraphUtility.initializeDirectedWeightedEdges(nodes);
    d.run();
  }
  
  private final List<Node> nodes;
  
  public DijkstraAlgorithmImpl(List<Node> nodes) {
    this.nodes = nodes;
  }
  
  private void run() {
    Node firstNode = nodes.get(0);
    firstNode.distance = 0;
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(firstNode);
    while (!queue.isEmpty()) {
      Node currNode = queue.remove();
      for (Node neighbor : currNode.neighbors) {
        if (currNode.distance + currNode.neighborDistanceMap.get(neighbor) < neighbor.distance) {
          neighbor.distance = currNode.distance + currNode.neighborDistanceMap.get(neighbor);
          neighbor.parent = currNode;
          queue.add(neighbor);
        }
      }
    }
    GraphUtility.print(firstNode, nodes);
  }
}