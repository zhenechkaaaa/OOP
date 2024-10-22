package ru.nsu.odnostorontseva.graph.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import ru.nsu.odnostorontseva.graph.Algorithm;
import ru.nsu.odnostorontseva.graph.Graph;
import ru.nsu.odnostorontseva.graph.Reader;
import ru.nsu.odnostorontseva.graph.basicparts.Edge;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;


/**
 * Implementation of graph, using Adjacency List.
 */
public class AdjacencyList<T> implements Graph<T> {
    public final Map<Vertex<T>, ArrayList<Vertex<T>>> adjacencyList;

    /**
     *
     */
    public AdjacencyList() {
        adjacencyList = new HashMap<>();
    }

    /**
     * @return список смежности
     */
    public Map<Vertex<T>, ArrayList<Vertex<T>>> getAdjacencyList() {
        return adjacencyList;
    }

    @Override
    public void addVertex(Vertex<T> vertex) {
        if(!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<>());
        }
    }

    @Override
    public void removeVertex(Vertex<T> vertex) {
        adjacencyList.remove(vertex);
        for(Vertex<T> v : adjacencyList.keySet()) {
            adjacencyList.get(v).remove(vertex);
        }
    }

    @Override
    public void addEdge(Edge<T> edge) {
        if(!adjacencyList.containsKey(edge.getStartVertex())) {
            adjacencyList.put(edge.getStartVertex(), new ArrayList<>());
        }
        adjacencyList.get(edge.getStartVertex()).add(edge.getFinishVertex());
        if(!edge.isDirected()) {
            if(!adjacencyList.containsKey(edge.getFinishVertex())) {
                adjacencyList.put(edge.getFinishVertex(), new ArrayList<>());
            }
            adjacencyList.get(edge.getFinishVertex()).add(edge.getStartVertex());
        }
    }

    @Override
    public void removeEdge(Edge<T> edge) {
        adjacencyList.get(edge.getStartVertex()).remove(edge.getFinishVertex());
        if(adjacencyList.get(edge.getStartVertex()).isEmpty()) {
            removeVertex(edge.getStartVertex());
        }
        if(!edge.isDirected()) {
            adjacencyList.get(edge.getFinishVertex()).remove(edge.getStartVertex());
            if (adjacencyList.get(edge.getFinishVertex()).isEmpty()) {
                removeVertex(edge.getFinishVertex());
            }
        }

    }

    @Override
    public List<Vertex<T>> getNeighbors(Vertex<T> vertex) {
        return adjacencyList.get(vertex);
    }

    @Override
    public List<Vertex<T>> getAllVertices() {
        List<Vertex<T>>  vertices = new ArrayList<>();
        for(Vertex<T> v : adjacencyList.keySet()) {
            if(!vertices.contains(v)) {
                vertices.add(v);
            }
            vertices.addAll(adjacencyList.get(v));
        }
        return vertices;
    }

    @Override
    public void readFromFile(String fileName, Function<String, T> parse) {
        Reader<T> r = new Reader<>();
        r.readFromFile(fileName, this, parse);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AdjacencyList<?> other)) {
            return false;
        }
        return adjacencyList.equals(other.adjacencyList);
    }

    @Override
    public int hashCode() {
        return adjacencyList.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Vertex<T> vertex : adjacencyList.keySet()) {
            sb.append(vertex).append(": ");
            sb.append(adjacencyList.get(vertex)).append("\n"); // Добавляем соседей в строку
        }

        return sb.toString();
    }

    @Override
    public List<Vertex<T>> sort(Algorithm<T> sorter) {
        return sorter.sort(this);
    }
}
