package com.graph;

import java.util.*;

public class Node {
   private int vertexNumber;
   private Set<Integer> adjacentSet = new HashSet<>();

   public Node(int vertexNumber){
       this.vertexNumber = vertexNumber;
   }

   public int getVertexNumber(){
       return vertexNumber;
   }

   public void addEdge(int vertexNumber){
       adjacentSet.add(vertexNumber);
   }

   public List<Integer> getAdjacentVertices(){
       List<Integer> sortedList = new ArrayList<>(adjacentSet);
       Collections.sort(sortedList);
       return sortedList;
   }
}
