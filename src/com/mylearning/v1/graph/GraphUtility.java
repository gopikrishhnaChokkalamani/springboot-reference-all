package com.mylearning.v1.graph;

import com.mylearning.v1.graph.disjointset.UnDirectedEdge;

import java.util.ArrayList;
import java.util.List;

public class GraphUtility {
  
  public static List<Node> initializeNodes(int index) {
    List<Node> nodes = new ArrayList<>();
    int i = 0;
    char c = 'A';
    while (i < index) {
      nodes.add(new Node(i, String.valueOf(c)));
      i++;
      c++;
    }
    return nodes;
  }
  
  public static void initializeUnDirectedUnWeightedEdges(List<Node> nodes) {
    addUnDirectedUnWeightedEdge(nodes,0, 1);
    addUnDirectedUnWeightedEdge(nodes,1, 2);
    addUnDirectedUnWeightedEdge(nodes,2, 3);
    addUnDirectedUnWeightedEdge(nodes,3, 4);
    addUnDirectedUnWeightedEdge(nodes,4, 5);
    addUnDirectedUnWeightedEdge(nodes,5, 0);
    addUnDirectedUnWeightedEdge(nodes,4, 6);
    addUnDirectedUnWeightedEdge(nodes,6, 1);
  }
  
  public static void initializeUnDirectedWeightedEdges(List<Node> nodes) {
    addUnDirectedWeightedEdge(nodes,0, 1, 28);
    addUnDirectedWeightedEdge(nodes,1, 2, 16);
    addUnDirectedWeightedEdge(nodes,2, 3, 12);
    addUnDirectedWeightedEdge(nodes,3, 4, 22);
    addUnDirectedWeightedEdge(nodes,4, 5, 25);
    addUnDirectedWeightedEdge(nodes,5, 0, 10);
    addUnDirectedWeightedEdge(nodes,4, 6, 24);
    addUnDirectedWeightedEdge(nodes,6, 1, 14);
  }
  
  public static void initializeDirectedWeightedEdges(List<Node> nodes) {
    addDirectedWeightedEdge(nodes,0, 1, 28);
    addDirectedWeightedEdge(nodes,1, 2, 16);
    addDirectedWeightedEdge(nodes,2, 3, 12);
    addDirectedWeightedEdge(nodes,3, 4, 22);
    addDirectedWeightedEdge(nodes,4, 5, 25);
    addDirectedWeightedEdge(nodes,5, 0, 10);
    addDirectedWeightedEdge(nodes,4, 6, 24);
    addDirectedWeightedEdge(nodes,6, 1, 14);
  }
  
  public static void initializeNegativeCycleGraph(List<Node> nodes) {
    addDirectedWeightedEdge(nodes,1, 0, 3);
    addDirectedWeightedEdge(nodes,0, 2, 6);
    addDirectedWeightedEdge(nodes,2, 3, 2);
    addDirectedWeightedEdge(nodes,3, 2, 1);
    addDirectedWeightedEdge(nodes,3, 1, 1);
    addDirectedWeightedEdge(nodes,0, 3, 6);
    addDirectedWeightedEdge(nodes,4, 1, 4);
    addDirectedWeightedEdge(nodes,4, 3, 2);
  }
  
  public static void addUnDirectedUnWeightedEdge(List<Node> nodes, int from, int to) {
    Node fromNode = nodes.get(from);
    Node toNode = nodes.get(to);
    fromNode.neighbors.add(toNode);
    toNode.neighbors.add(fromNode);
  }
  
  public static void addUnDirectedWeightedEdge(List<Node> nodes, int from, int to, int distance) {
    Node fromNode = nodes.get(from);
    Node toNode = nodes.get(to);
    fromNode.neighbors.add(toNode);
    toNode.neighbors.add(fromNode);
    fromNode.neighborDistanceMap.put(toNode, distance);
    toNode.neighborDistanceMap.put(fromNode, distance);
  }
  
  public static void addDirectedWeightedEdge(List<Node> nodes, int from, int to, int distance) {
    Node fromNode = nodes.get(from);
    Node toNode = nodes.get(to);
    fromNode.neighbors.add(toNode);
    fromNode.neighborDistanceMap.put(toNode, distance);
  }
  
  public static void printPath(Node node) {
    if (node.parent != null) {
      printPath(node.parent);
    }
    System.out.print(node.name + " ");
  }
  
  public static void print(Node firstNode, List<Node> nodes) {
    for (Node node : nodes) {
      System.out.println("Distance between " + firstNode.name + " to " + node.name + " is " + node.distance);
      System.out.print("Path to reach "+ node.name + " from "+ firstNode.name + " - ");
      printPath(node);
      System.out.println("\n");
    }
  }
}