package com.graph;

import java.util.ArrayList;
import java.util.List;

class Graphh{
    List<Node> verices;
}
public class AdjacencySet implements Graph{

    private List<Node> vertexList = new ArrayList<>();
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;

    public AdjacencySet(List<Node> vertexList, int numVertices) {
        this.vertexList = vertexList;
        this.numVertices = numVertices;
        for( int i = 0;i<numVertices;i++){
            vertexList.add(new Node(i));
        }
    }


    @Override
    public void addEdge(int v1, int v2) {
        if( v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0 ){
            throw new IllegalArgumentException("Vertex number is not valid "+v1+" ,"+v2);
        }

        vertexList.get(v1).addEdge(v2);
        if( graphType == GraphType.UNDIRECTED){
            vertexList.get(v2).addEdge(v1);
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if( v >= numVertices || v < 0 ){
            throw new IllegalArgumentException("Vertex number is not valid"+v);

        }
        return vertexList.get(v).getAdjacentVertices();
    }

    @Override
    public int getInDegree(int vertex) {
        return 0;
    }

    @Override
    public int getNumVertices() {
        return numVertices;
    }
}
