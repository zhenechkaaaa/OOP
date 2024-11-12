package ru.nsu.odnostorontseva.graph.basicparts;

import java.util.Objects;

/**
 *  Class for representing an edge.
 */
public class Edge<T> {
    private final Vertex<T> vertex1;
    private final Vertex<T> vertex2;
    private final int weight;
    private final boolean directed;

    /**
     * Constructing an edge.
     *
     * @param vertex1 (вершина 1).
     * @param vertex2 (вершина 2).
     * @param weight (вес ребра).
     * @param directed (является ли направленным).
     */
    public Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight, boolean directed) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.directed = directed;
    }

    /**
     * Method to get "from" vertex.
     *
     * @return ().
     */
    public Vertex<T> getStartVertex() {
        return vertex1;
    }

    /**
     * Method to get "to" vertex.
     *
     * @return ().
     */
    public Vertex<T> getFinishVertex() {
        return vertex2;
    }

    /**
     * Method to get edge's weight.
     *
     * @return ().
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Method to check is the edge is directed.
     *
     * @return ().
     */
    public boolean isDirected() {
        return directed;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Edge<?> edge)) {
            return false;
        }
        if (directed) {
            return Objects.equals(vertex1, edge.vertex1)
                    && Objects.equals(vertex2, edge.vertex2)
                    && (weight == edge.weight);
        } else {
            return ((Objects.equals(vertex1, edge.vertex1)
                    && Objects.equals(vertex2, edge.vertex2))
                    || (Objects.equals(vertex1, edge.vertex2)
                    && Objects.equals(vertex2, edge.vertex1)))
                    && (weight == edge.weight);
        }
    }

    @Override
    public int hashCode() {
        if (directed) {
            return Objects.hash(vertex1, vertex2, weight);
        } else {
            return Objects.hash(vertex1, vertex2)
                    + Objects.hash(vertex2, vertex1)
                    + Integer.hashCode(weight);
        }
    }

    @Override
    public String toString() {
        if (directed) {
            return vertex1 + " -> " + vertex2 + " (w: " + weight + ")";
        } else {
            return vertex1 + " - " + vertex2 + " (w: " + weight + ")";
        }
    }
}

