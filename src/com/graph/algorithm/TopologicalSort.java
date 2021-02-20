package com.graph.algorithm;

import com.graph.AdjacencyMatrix;
import com.graph.Graph;

import java.util.*;

public class TopologicalSort {
    public static List<Integer> sort(Graph graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        Map<Integer,Integer> indegreeMap = new HashMap<>();
        for( int vertex = 0; vertex < graph.getNumVertices(); vertex++){
            int inDegree = graph.getInDegree(vertex);
            indegreeMap.put(vertex, inDegree);
            if( inDegree == 0 )
                queue.add(vertex);
        }

        List<Integer> sortedList = new ArrayList<>();
        while ( !queue.isEmpty() ){
            int vertex = queue.pollLast();
            sortedList.add(vertex);

            List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);
            for( int adjacemntVertex: adjacentVertices){
                int updatedDegree = indegreeMap.get(adjacemntVertex) - 1;
                indegreeMap.remove(adjacemntVertex);
                indegreeMap.put(adjacemntVertex, updatedDegree);
                if( updatedDegree == 0){
                    queue.add(adjacemntVertex);
                }
            }
        }

        if( sortedList.size() != graph.getNumVertices()){
            throw new RuntimeException("The Graph has a cycle");
        }
        return sortedList;
    }

    public static void main(String[] args){
        int matrix[][] = new int[5][5];
        AdjacencyMatrix graph = new AdjacencyMatrix(matrix, Graph.GraphType.DIRECTED,5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        TopologicalSort obj = new TopologicalSort();
        List<Integer> res = obj.sort(graph);
        for ( int result: res) {
            System.out.print(result + " ");
        }
    }
}
