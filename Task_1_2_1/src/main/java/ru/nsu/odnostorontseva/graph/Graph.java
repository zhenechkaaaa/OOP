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
     * @param vertex (вершина, которую нужно удалить).
     */
    void removeVertex(Vertex vertex);


    /**
     * Method for adding an edge into graph.
     *
     * @param edge (ребро, которое нужно добавить).
     */
    void addEdge(Edge edge);


    /**
     * Method for removing an edge from graph.
     *
     * @param edge (ребро, которое нужно удалить).
     */
    void removeEdge(Edge edge);


    /**
     * Method, which returns all neighbors of vertex.
     *
     * @param vertex (вершина, соседи которой нам нужны).
     * @return (список всех соседей вершины).
     */
    List<Vertex> getNeighbors(Vertex vertex);


    /**
     * Method which read an information about graph from file.
     *
     * @param filename (имя файла).
     */
    void readFromFile(String filename);

    boolean equals(Object o);
    String toString();

    /**
     * Method which make a topological sort in graph.
     *
     * @return (топологически отсортированный список вершин).
     */
    List<Vertex> topologicalSort();
}
