package com.mylearning.v1.graph.shortestpath.allpairs;

import com.mylearning.v1.graph.GraphUtility;
import com.mylearning.v1.graph.Node;

import java.util.List;

public class FloydWarshallAlgorithmImpl {
  
  public static void main(String[] args) {
    List<Node> nodes = GraphUtility.initializeNodes(5);
    FloydWarshallAlgorithmImpl f = new FloydWarshallAlgorithmImpl(nodes);
    GraphUtility.initializeNegativeCycleGraph(nodes);
    f.run();
  }
  
  private final List<Node> nodes;
  
  public FloydWarshallAlgorithmImpl(List<Node> nodes) {
    this.nodes = nodes;
  }
  
  private void run() {
    Node node = nodes.get(4);
    node.distance = 0;
    int[][] matrix = new int[nodes.size()][nodes.size()];
    
    for (int i = 0; i < nodes.size(); i++) {
      Node firstNode = nodes.get(i);
      for (int j = 0; j < nodes.size(); j++) {
        Node secondNode = nodes.get(j);
        if (i == j) {
          matrix[i][j] = 0;
        } else if (firstNode.neighborDistanceMap.containsKey(secondNode)) {
          matrix[i][j] = firstNode.neighborDistanceMap.get(secondNode);
        } else {
          matrix[i][j] = 999;
        }
      }
    }
    
    for (int k = 0; k < nodes.size(); k++) {
      for (int i = 0; i < nodes.size(); i++) {
        for (int j = 0; j < nodes.size(); j++) {
          matrix[i][j] = Math.min(matrix[i][j], (matrix[i][k] + matrix[k][j]));
          if (matrix[i][i] < 0) {
            System.out.println("Negative Cycle Exists");
            return;
          }
        }
      }
    }
  
    for (int i = 0; i < nodes.size(); i++) {
      for (int j = 0; j < nodes.size(); j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}