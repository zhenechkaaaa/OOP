package ru.nsu.odnostorontseva.graph.implementations;

import ru.nsu.odnostorontseva.graph.Algorithm;
import ru.nsu.odnostorontseva.graph.Graph;
import ru.nsu.odnostorontseva.graph.Reader;
import ru.nsu.odnostorontseva.graph.basicparts.Edge;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class IncidenceMatrix<T> implements Graph<T> {
    private final List<Vertex<T>> vertices;
    private final List<Edge<T>> edges;
    private final ArrayList<ArrayList<Integer>> incidenceMatrix;

    /**
     * Class constructor.
     *
     * @param vertices (список вершин графа)
     */
    public IncidenceMatrix(List<Vertex<T>> vertices, List<Edge<T>> edges) {
        this.vertices = new ArrayList<>(vertices);
        this.edges = new ArrayList<>(edges);
        this.incidenceMatrix = new ArrayList<>();

        for (int i = 0; i < vertices.size(); i++) {
            incidenceMatrix.add(new ArrayList<>());
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
        return this.incidenceMatrix;
    }

    @Override
    public void addVertex(Vertex<T> vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            incidenceMatrix.add(new ArrayList<>());
            for (ArrayList<Integer> row : incidenceMatrix) {
                while (row.size() < edges.size()) {
                    row.add(0);
                }
            }
        }
    }

    @Override
    public void removeVertex(Vertex<T> vertex) {
        int index = vertices.indexOf(vertex);
        if (index != -1) {
            vertices.remove(index);
            incidenceMatrix.remove(index);
        }
    }

    @Override
    public void addEdge(Edge<T> edge) {
        Vertex<T> startV = edge.getStartVertex();
        Vertex<T> finishV = edge.getFinishVertex();

        if (!vertices.contains(startV)) {
            addVertex(startV);
        }
        if (!vertices.contains(finishV)) {
            addVertex(finishV);
        }

        edges.add(edge);
        int newEdgeIndex = edges.indexOf(edge);

        int startId = vertices.indexOf(startV);
        int finishId = vertices.indexOf(finishV);

        if (edge.isDirected()) {
            incidenceMatrix.get(startId).add(newEdgeIndex, edge.getWeight());
            incidenceMatrix.get(finishId).add(newEdgeIndex, -(edge.getWeight()));
        } else {
            incidenceMatrix.get(startId).add(newEdgeIndex, edge.getWeight());
            incidenceMatrix.get(finishId).add(newEdgeIndex, edge.getWeight());
        }

        if(vertices.size() > 2) {
            for(int i = 0; i < vertices.size(); i++){
                if(vertices.get(i) != startV && vertices.get(i) != finishV) {
                    incidenceMatrix.get(i).add(newEdgeIndex, 0);
                }
            }
        }

    }


    @Override
    public void removeEdge(Edge<T> edge) {
        int edgeId= edges.indexOf(edge);
        if (edgeId != -1) {
            edges.remove(edgeId);
            for (ArrayList<Integer> row : incidenceMatrix) {
                row.remove(edgeId);
                row.add(0);
            }
        }
    }

    @Override
    public List<Vertex<T>> getNeighbors(Vertex<T> vertex) {
        List<Vertex<T>> neighbors = new ArrayList<>();
        int vertexId = vertices.indexOf(vertex);
        if (vertexId != -1) {
            for (int edgeIndex = 0; edgeIndex < edges.size(); edgeIndex++) {
                if (incidenceMatrix.get(vertexId).get(edgeIndex) == 1) {
                    Edge<T> edge = edges.get(edgeIndex);
                    Vertex<T> neighbor = (edge.getStartVertex().equals(vertex)) ? edge.getFinishVertex() : edge.getStartVertex();
                    neighbors.add(neighbor);
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
        if (!(o instanceof IncidenceMatrix<?> other)) {
            return false;
        }
        return incidenceMatrix.equals(other.incidenceMatrix)
                && vertices.equals(other.vertices)
                && edges.equals(other.edges);
    }

    @Override
    public int hashCode() {
        return incidenceMatrix.hashCode() + vertices.hashCode() + edges.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("   ");
        for (Vertex<T> vertex : vertices) {
            sb.append(vertex).append(" ");
        }
        sb.append("\n");

        for (int e = 1; e <= edges.size(); e++) {
            sb.append("e").append(e).append(" ");
            for(int i = 0; i< vertices.size(); i++){
                sb.append(incidenceMatrix.get(i).get(e-1)).append(" ");
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
