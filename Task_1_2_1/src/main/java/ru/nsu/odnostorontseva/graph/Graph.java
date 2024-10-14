package ru.nsu.odnostorontseva.graph;

import ru.nsu.odnostorontseva.graph.BasicParts.Edge;
import ru.nsu.odnostorontseva.graph.BasicParts.Vertex;

import java.util.List;

public interface Graph {
    /**
     * Method for adding a vertex into graph.
     *
     * @param vertex (вершина, которую нужно добавить)
     */
    void addVertex(Vertex vertex);

    /**
     * Method for removing a vertex from graph.
     *
     * @param vertex ().
     */
    void removeVertex(Vertex vertex);


    /**
     * Method for adding an edge into graph.
     *
     * @param edge ().
     */
    void addEdge(Edge edge);


    /**
     * Method for removing an edge from graph.
     *
     * @param edge ().
     */
    void removeEdge(Edge edge);


    /**
     * Method, which returns all neighbors of vertex.
     *
     * @param vertex ().
     * @return ().
     */
    List<Vertex> getNeighbors(Vertex vertex);


    /**
     * Method which read an information about graph from file.
     *
     * @param filename ().
     */
    void readFromFile(String filename);

    boolean equals(Object o);
    String toString();

    /**
     * Method which make a toposort in graph.
     *
     * @return ().
     */
    List<Vertex> topologicalSort();
}
