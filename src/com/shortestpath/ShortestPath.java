package com.shortestpath;

import com.graph.AdjacencyMatrix;
import com.graph.AdjacencySet;
import com.graph.Graph;
import com.graph.Node;

import java.util.*;

public class ShortestPath {

    public static void main(String[] args){
        ShortestPath sp = new ShortestPath();
        AdjacencySet graph = new AdjacencySet(new ArrayList<Node>(), 5);
        graph.addEdge(0, 1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(3,4);
        graph.addEdge(4,2);
        graph.addEdge(4,1);
        System.out.print("Day one ");
        sp.shortestPath(graph, 0 , 2);
        System.out.print("Day two ");
        sp.shortestPathDayOne( graph, 0, 2);
        System.out.print("Day three ");
        sp.shortestPathDayOne( graph, 0, 2);


    }


    public void shortestPathDayOne( Graph graph, int source, int destination){
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTableDayOne(graph, source);
        Stack<Integer> stack = new Stack<>();
        stack.push( destination );
        int prevVertex = distanceTable.get(destination).getLastVertex();
        while ( prevVertex != -1 && prevVertex != source){
            stack.push(prevVertex);
            prevVertex = distanceTable.get(prevVertex).getLastVertex();
        }

        if( prevVertex == -1 ){
            System.out.println("There is no path from "+ source + " to "+destination);
        }else {
            System.out.print("Smallest path is "+ source);
            while (!stack.isEmpty()){
                System.out.print(" -> "+stack.pop());
            }
            System.out.println(" Shortest path unweighted is done!!");
        }
    }

    private static Map<Integer, DistanceInfo> buildDistanceTableDayOne( Graph graph, int source ){
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        for( int i = 0; i < graph.getNumVertices();i++){
            distanceTable.put(i, new DistanceInfo());
        }
        distanceTable.get(0).setLastVertex(0);
        distanceTable.get(0).setDistance(0);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        while ( !queue.isEmpty()){
            int currentVertex = queue.pollFirst();
            for( int i : graph.getAdjacentVertices(currentVertex)){
                int currentDistance = distanceTable.get(i).getDistance();
                if( currentDistance == -1 ){
                    currentDistance = 1 + distanceTable.get(currentVertex).getDistance();
                    distanceTable.get(i).setDistance(currentDistance);
                    distanceTable.get(i).setLastVertex(currentVertex);
                    if( !graph.getAdjacentVertices(i).isEmpty()){
                        queue.add(i);
                    }
                }
            }
        }
        return distanceTable;
    }

    private static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source){
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        for( int i =0;i<graph.getNumVertices();i++){
            distanceTable.put(i, new DistanceInfo());
        }
        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);

        while ( !queue.isEmpty() ){
            int currentVertex = queue.pollFirst();
            for( int i : graph.getAdjacentVertices(currentVertex)){
                int currentDistance = distanceTable.get(i).getDistance();
                if( currentDistance == -1 ){
                    currentDistance = 1 + distanceTable.get(currentVertex).getDistance();
                    distanceTable.get(i).setDistance(currentDistance);
                    distanceTable.get(i).setLastVertex(currentVertex);
                    if( !graph.getAdjacentVertices(i).isEmpty()){
                        queue.add(i);
                    }
                }
            }
        }
        return distanceTable;

    }

    public static void shortestPath(Graph graph, int source, int destination){
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);

        Stack<Integer> stack = new Stack<>();
        stack.push(destination);

        int prevVertex = distanceTable.get(destination).getLastVertex();
        while ( prevVertex != -1 && prevVertex != source ){
            stack.push(prevVertex);
            prevVertex = distanceTable.get(prevVertex).getLastVertex();
        }

        if( prevVertex == -1 ){
            System.out.println("There is no path from "+ source +" to "+ destination);
        }else {
            System.out.print("Smallest path is " + source);
            while ( !stack.isEmpty()){
                System.out.print(" -> "+stack.pop());
            }
            System.out.println(" Shortest path unweighted is done!");
        }
    }


    public void shortestPathDayThree( Graph graph, int source, int destination) {
        HashMap<Integer, DistanceInfo> distanceTable = this.buildDistanceTableDayThree(graph, source);
        int prevVertex = distanceTable.get(destination).getLastVertex();
        Stack<Integer> stack = new Stack<>();
        stack.push(destination);
        while( prevVertex != -1 && prevVertex != source){
            stack.push(prevVertex);
            prevVertex = distanceTable.get(prevVertex).getLastVertex();
        }
        if( prevVertex == -1 ){
            System.out.print("There is no path from "+source+ " to " +destination);
        }else {
            System.out.print("The smallest path is");
            while ( !stack.isEmpty() ){
                System.out.print(" -> " +stack.pop());
            }
            System.out.println("Shortest path unweighted is done!!");
        }
    }

    public HashMap<Integer, DistanceInfo> buildDistanceTableDayThree(Graph graph, int source){
        HashMap<Integer, DistanceInfo> distanceTable = new HashMap<>();
        for ( int i = 0; i<graph.getNumVertices();i++){
            distanceTable.put(i, new DistanceInfo());
        }
        distanceTable.get(0).setLastVertex(0);
        distanceTable.get(0).setDistance(0);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        while ( !queue.isEmpty() ){
            int currentVertex = queue.pollFirst();
            for ( int i  : graph.getAdjacentVertices(currentVertex)){
                int currentDistance = distanceTable.get(i).getDistance();
                if( currentDistance == -1){
                    currentDistance = 1 + distanceTable.get(currentVertex).getDistance();
                    distanceTable.get(i).setDistance(currentDistance);
                    distanceTable.get(i).setLastVertex(currentVertex);
                    if(!graph.getAdjacentVertices(i).isEmpty()){
                        queue.add(i);
                    }
                }
            }
        }
        return distanceTable;
    }
}
