package edu.gatech.cs1332.x4.mod13;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Your implementation of various graph traversal algorithms.
 */
public class GraphAlgorithms {

    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * You may import/use java.util.Set, java.util.List, java.util.Queue, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     *
     * The only instance of java.util.Map that you should use is the adjacency
     * list from graph. DO NOT create new instances of Map for BFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the bfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
        // Create a list to store visited vertices in order
        List<Vertex<T>> visitedOrder = new ArrayList<>();

        // Create a set to keep track of visited vertices
        Set<Vertex<T>> visited = new HashSet<>();

        // Create a queue for BFS traversal
        Queue<Vertex<T>> queue = new LinkedList<>();

        // Add start vertex to queue and visited set
        queue.add(start);
        visited.add(start);

        // Get the adjacency list from the graph
        Map<Vertex<T>, List<VertexDistance<T>>> adjList = graph.getAdjList();

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.remove();
            visitedOrder.add(current);

            // Visit all neighbors of current vertex
            for (VertexDistance<T> neighbor : adjList.get(current)) {
                Vertex<T> neighborVertex = neighbor.getVertex();
                if (!visited.contains(neighborVertex)) {
                    queue.add(neighborVertex);
                    visited.add(neighborVertex);
                }
            }
        }

        return visitedOrder;
    }

    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * NOTE: This method should be implemented recursively. You may need to
     * create a helper method.
     *
     * You may import/use java.util.Set, java.util.List, and any classes that
     * implement the aforementioned interfaces, as long as they are efficient.
     *
     * The only instance of java.util.Map that you may use is the adjacency list
     * from graph. DO NOT create new instances of Map for DFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the dfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
        List<Vertex<T>> visitedOrder = new ArrayList<>();
        Set<Vertex<T>> visited = new HashSet<>();

        // Call helper method to perform recursive DFS
        dfsHelper(start, graph, visitedOrder, visited);

        return visitedOrder;
    }

    // Helper method for DFS
    private static <T> void dfsHelper(Vertex<T> current, Graph<T> graph,
                                      List<Vertex<T>> visitedOrder,
                                      Set<Vertex<T>> visited) {
        // Mark current vertex as visited and add to visited order
        visited.add(current);
        visitedOrder.add(current);

        // Get adjacency list from graph
        Map<Vertex<T>, List<VertexDistance<T>>> adjList = graph.getAdjList();

        // Visit all unvisited neighbors recursively
        for (VertexDistance<T> neighbor : adjList.get(current)) {
            Vertex<T> neighborVertex = neighbor.getVertex();
            if (!visited.contains(neighborVertex)) {
                dfsHelper(neighborVertex, graph, visitedOrder, visited);
            }
        }
    }
}