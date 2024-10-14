package ru.nsu.odnostorontseva.graph;

import ru.nsu.odnostorontseva.graph.BasicParts.Edge;
import ru.nsu.odnostorontseva.graph.BasicParts.Vertex;

import java.util.List;

public interface Graph {
    void addVertex(Vertex vertex);
    void removeVertex(Vertex vertex);
    void addEdge(Edge edge);
    void removeEdge(Edge edge);
    List<Vertex> getNeighbors(Vertex vertex);
    void readFromFile(String filename);
    boolean equals(Object o);
    String toString();
    List<Vertex> topologicalSort();
}
