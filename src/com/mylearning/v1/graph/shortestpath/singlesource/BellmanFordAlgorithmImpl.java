package com.mylearning.v1.graph.shortestpath.singlesource;

import com.mylearning.v1.graph.GraphUtility;
import com.mylearning.v1.graph.Node;

import java.util.List;

public class BellmanFordAlgorithmImpl {
  
  public static void main(String[] args) {
    List<Node> nodes = GraphUtility.initializeNodes(5);
    BellmanFordAlgorithmImpl b = new BellmanFordAlgorithmImpl(nodes);
    GraphUtility.initializeNegativeCycleGraph(nodes);
    b.run();
  }
  
  private final List<Node> nodes;
  
  public BellmanFordAlgorithmImpl(List<Node> nodes) {
    this.nodes = nodes;
  }
  
  private void run() {
    Node firstNode = nodes.get(4);
    firstNode.distance = 0;
    
    for (int i = 0; i < nodes.size() - 1; i++) {
      for (Node currNode : nodes) {
        for (Node neighbor : currNode.neighbors) {
          if (currNode.distance + currNode.neighborDistanceMap.get(neighbor) < neighbor.distance) {
            neighbor.distance = currNode.distance + currNode.neighborDistanceMap.get(neighbor);
            neighbor.parent = currNode;
          }
        }
      }
    }
  
    for (Node currNode : nodes) {
      for (Node neighbor : currNode.neighbors) {
        if (currNode.distance + currNode.neighborDistanceMap.get(neighbor) < neighbor.distance) {
          System.out.println("Negative Cycle Exists!");
          return;
        }
      }
    }
    
    GraphUtility.print(firstNode, nodes);
  }
}
