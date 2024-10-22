package ru.nsu.odnostorontseva.graph.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import ru.nsu.odnostorontseva.graph.Algorithm;
import ru.nsu.odnostorontseva.graph.Graph;
import ru.nsu.odnostorontseva.graph.Reader;
import ru.nsu.odnostorontseva.graph.basicparts.Edge;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;


/**
 * Implementation of graph, using Adjacency Matrix.
 */
public class AdjacencyMatrix<T> implements Graph<T> {
    private final List<Vertex<T>> vertices;
    private final ArrayList<ArrayList<Integer>> adjacencyMatrix;
    /**
     * Class constructor.
     *
     * @param vertices (список вершин графа)
     */
    public AdjacencyMatrix(List<Vertex<T>> vertices) {
        this.vertices = new ArrayList<>(vertices);
        this.adjacencyMatrix = new ArrayList<>();
        for (int i = 0; i < vertices.size(); i++) {
            adjacencyMatrix.add(new ArrayList<>());
            for (int j = 0; j < vertices.size(); j++) {
                adjacencyMatrix.get(i).add(0);
            }
        }
    }

    @Override
    public List<Vertex<T>> getAllVertices() {
        return this.vertices;
    }

    /**
     * Method to get the matrix
     *
     * @return matrix.
     */
    public ArrayList<ArrayList<Integer>> getMatrix() {
        return this.adjacencyMatrix;
    }


    @Override
    public void addVertex(Vertex<T> vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            adjacencyMatrix.add(new ArrayList<>());
            for (int i = 0; i < vertices.size(); i++) {
                adjacencyMatrix.get(i).add(0);
                if (i < vertices.size() - 1) {
                    adjacencyMatrix.getLast().add(0);
                }
            }
        }
    }

    @Override
    public void removeVertex(Vertex<T> vertex) {
        int index = vertices.indexOf(vertex);
        if (index != -1) {
            vertices.remove(index);
            adjacencyMatrix.remove(index);
            for (ArrayList<Integer> row : adjacencyMatrix) {
                row.remove(index);
            }
        }
    }

    @Override
    public void addEdge(Edge<T> edge) {
        Vertex<T> startVertex = edge.getStartVertex();
        Vertex<T> finishVertex = edge.getFinishVertex();

        if (!vertices.contains(startVertex)) {
            addVertex(startVertex);
        }
        if (!vertices.contains(finishVertex)) {
            addVertex(finishVertex);
        }

        int startId = vertices.indexOf(startVertex);
        int finishId = vertices.indexOf(finishVertex);

        adjacencyMatrix.get(startId).set(finishId, edge.getWeight());
        if (!edge.isDirected()) {
            adjacencyMatrix.get(finishId).set(startId, edge.getWeight());
        }
    }

    @Override
    public void removeEdge(Edge<T> edge) {
        int startId = vertices.indexOf(edge.getStartVertex());
        int FinishId = vertices.indexOf(edge.getFinishVertex());

        if (startId != -1 && FinishId != -1) {
            adjacencyMatrix.get(startId).set(FinishId, 0);
            if (!edge.isDirected()) {
                adjacencyMatrix.get(FinishId).set(startId, 0);
            }
        }
    }

    @Override
    public List<Vertex<T>> getNeighbors(Vertex<T> vertex) {
        List<Vertex<T>> neighbors = new ArrayList<>();
        int index = vertices.indexOf(vertex);
        if (index != -1) {
            for (int j = 0; j < vertices.size(); j++) {
                if (adjacencyMatrix.get(index).get(j) != 0) {
                    neighbors.add(vertices.get(j));
                }
            }
        }
        return neighbors;
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
        if (!(o instanceof AdjacencyMatrix<?> other)) {
            return false;
        }
        return adjacencyMatrix.equals(other.adjacencyMatrix) && vertices.equals(other.vertices);
    }

    @Override
    public int hashCode() {
        return adjacencyMatrix.hashCode() + vertices.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("  ");
        for (Vertex<T> vertex : vertices) {
            sb.append(vertex).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < vertices.size(); i++) {
            sb.append(vertices.get(i)).append(" ");
            for (int j = 0; j < vertices.size(); j++) {
                sb.append(adjacencyMatrix.get(i).get(j)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public List<Vertex<T>> sort(Algorithm<T> sorter) {
        return sorter.sort(this);
    }
}
