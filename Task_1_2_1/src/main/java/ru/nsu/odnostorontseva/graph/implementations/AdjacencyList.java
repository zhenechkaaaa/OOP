package ru.nsu.odnostorontseva.graph.implementations;

import java.util.ArrayList;
import java.util.List;
import ru.nsu.odnostorontseva.graph.Algorithm;
import ru.nsu.odnostorontseva.graph.Graph;
import ru.nsu.odnostorontseva.graph.Reader;
import ru.nsu.odnostorontseva.graph.basicparts.Edge;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;


/**
 * Implementation of graph, using Adjacency List.
 */
public class AdjacencyList implements Graph {
    private final List<Vertex> vertices;
    private final List<List<Vertex>> adjacencyList;

    /**
     * Class constructor.
     *
     * @param vertices (список вершин графа)
     */
    public AdjacencyList(List<Vertex> vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices.size());
        for (Vertex v : vertices) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    @Override
    public List<Vertex> getAllVertices() {
        return vertices;
    }

    @Override
    public void addVertex(Vertex vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
        }
    }

    @Override
    public void removeVertex(Vertex vertex) {
        vertices.remove(vertex);
    }

    @Override
    public void addEdge(Edge edge) {
        if (!vertices.contains(edge.getStartVertex())) {
            addVertex(edge.getStartVertex());
        } else if (!vertices.contains(edge.getFinishVertex())) {
            addVertex(edge.getFinishVertex());
        }
        adjacencyList.get(vertices.indexOf(edge.getStartVertex())).add(edge.getFinishVertex());
        if (!edge.isDirected()) {
            adjacencyList.get(vertices.indexOf(edge.getFinishVertex())).add(edge.getStartVertex());
        }
    }

    @Override
    public void removeEdge(Edge edge) {
        adjacencyList.get(vertices.indexOf(edge.getStartVertex())).remove(edge.getFinishVertex());
        if (!edge.isDirected()) {
            adjacencyList.get(vertices.indexOf(edge.getFinishVertex())).add(edge.getStartVertex());
        }
    }

    @Override
    public List<Vertex> getNeighbors(Vertex vertex) {
        return adjacencyList.get(vertices.indexOf(vertex));
    }

    @Override
    public void readFromFile(String filename) {
        Reader.readFromFile(filename, this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AdjacencyList other)) {
            return false;
        }

        return vertices.equals(other.vertices) && adjacencyList.equals(other.adjacencyList);
    }

    @Override
    public int hashCode() {
        return vertices.hashCode() + adjacencyList.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Vertex v : vertices) {
            sb.append(v).append(": ").append(adjacencyList.get(vertices.indexOf(v))).append(", ");
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public List<Vertex> sort(Algorithm sorter) {
        return sorter.sort(this);
    }
}
