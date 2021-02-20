package com.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrix  implements Graph{

    private int[][] adjMatrix;
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;

    public AdjacencyMatrix(int[][] adjMatrix, GraphType graphType, int numVertices) {
        this.adjMatrix = new int[numVertices][numVertices];
        this.graphType = graphType;
        this.numVertices = numVertices;
        for( int i = 0;i<numVertices;i++){
            for( int j = 0;j<numVertices;j++){
              adjMatrix[i][j] = 0;
            }
        }
    }


    @Override
    public void addEdge(int v1, int v2) {
        if( v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0 ){
            throw new IllegalArgumentException("Vertex number is not valid");
        }

        adjMatrix[v1][v2] = 1;
        if( graphType == graphType.UNDIRECTED){
            adjMatrix[v2][v1] = 1;
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if( v >= numVertices || v < 0 ){
            throw  new IllegalArgumentException("Vertex number is not valid");
        }

        List<Integer> adjacentVerticesList = new ArrayList<>();
        Collections.sort(adjacentVerticesList);
        return adjacentVerticesList;
    }

    @Override
    public int getInDegree(int vertex) {
        if( vertex <0 || vertex >= numVertices){
            throw  new IllegalArgumentException("Vertex number is not valid.");
        }
        int inDegree = 0;
        for( int i = 0;i < numVertices;i++){
            if( adjMatrix[i][vertex] != 0 ){
                inDegree++;
            }
        }
        return inDegree;
    }

    @Override
    public int getNumVertices() {
        return numVertices;
    }


}
