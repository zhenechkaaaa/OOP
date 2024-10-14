package ru.nsu.odnostorontseva.graph.BasicParts;

import java.util.Objects;

public class Edge {
    private final Vertex vertex1;
    private final Vertex vertex2;
    private final int weight;
    private final boolean directed;

    public Edge(Vertex vertex1, Vertex vertex2, int weight, boolean directed) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.directed = directed;
    }

    public Vertex getStartVertex() {
        return vertex1;
    }

    public Vertex getFinishVertex() {
        return vertex2;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isDirected() {
        return directed;
    }

    public static Edge createEdge(Vertex vertex1, Vertex vertex2, int weight, boolean directed) {
        return new Edge(vertex1, vertex2, weight, directed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge edge)) return false;
        if (directed) {
            return Objects.equals(vertex1, edge.vertex1) &&
                    Objects.equals(vertex2, edge.vertex2) &&
                    (weight == edge.weight);
        } else {
            return (Objects.equals(vertex1, edge.vertex1) && Objects.equals(vertex2, edge.vertex2) ||
                    Objects.equals(vertex1, edge.vertex2) && Objects.equals(vertex2, edge.vertex1)) &&
                    (weight == edge.weight);
        }
    }

    @Override
    public int hashCode() {
        if (directed) {
            return Objects.hash(vertex1, vertex2, weight);
        } else {
            return Objects.hash(vertex1, vertex2) + Objects.hash(vertex2, vertex1) + Integer.hashCode(weight);
        }
    }

    @Override
    public String toString() {
        if(directed) {
            return vertex1 + " -> " + vertex2 + " (w: " + weight + ")";
        } else {
            return vertex1 + " - " + vertex2 + " (w: " + weight + ")";
        }
    }
}

