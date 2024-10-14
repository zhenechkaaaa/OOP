package ru.nsu.odnostorontseva.graph.BasicParts;

import java.util.Objects;

public class Edge {
    private final Vertex vertex1;
    private final Vertex vertex2;

    public Edge(Vertex vertex1, Vertex vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public Vertex getStartVertex() {
        return vertex1;
    }

    public Vertex getFinishVertex() {
        return vertex2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge edge)) return false;
        return Objects.equals(vertex1, edge.vertex1) && Objects.equals(vertex2, edge.vertex2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex1, vertex2);
    }

    @Override
    public String toString() {
        return "(" + vertex1 + ", " + vertex2 + ")";
    }
}

