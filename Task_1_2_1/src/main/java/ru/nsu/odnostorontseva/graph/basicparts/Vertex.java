package ru.nsu.odnostorontseva.graph.basicparts;

import java.util.Objects;

/**
 * Class for representing a vertex.
 */
public class Vertex {
    private final String name;  // Уникальный идентификатор вершины

    /**
     * Constructing the vertex.
     *
     * @param name (name of vertex).
     */
    public Vertex(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex vertex)) return false;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
