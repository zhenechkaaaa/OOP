package ru.nsu.odnostorontseva.graph.Implementations;

import ru.nsu.odnostorontseva.graph.BasicParts.Edge;
import ru.nsu.odnostorontseva.graph.BasicParts.Vertex;
import ru.nsu.odnostorontseva.graph.Graph;

import java.util.*;

public class AdjacencyMatrix implements Graph {
    private List<Vertex> vertices;
    private int[][] matrix;

    public AdjacencyMatrix(List<Vertex> vertices) {
        vertices = new ArrayList<>();
        matrix = new int[0][0];
    }

    @Override
    public void addVertex(Vertex vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            int newSize = vertices.size();
            int[][] newMatrix = new int[newSize][newSize];
            for (int i = 0; i < matrix.length; i++) {
                System.arraycopy(matrix[i], 0, newMatrix[i], 0, matrix.length);
            }
            matrix = newMatrix;
        }
    }

    @Override
    public void removeVertex(Vertex vertex) {
        int index = vertices.indexOf(vertex);
        if (index != -1) {
            vertices.remove(index);
            int[][] newMatrix = new int[vertices.size()][vertices.size()];
            for (int i = 0, newI = 0; i < matrix.length; i++) {
                if (i == index) continue;
                for (int j = 0, newJ = 0; j < matrix.length; j++) {
                    if (j == index) continue;
                    newMatrix[newI][newJ++] = matrix[i][j];
                }
                newI++;
            }
            matrix = newMatrix;
        }
    }

    @Override
    public void addEdge(Edge edge) {
        int index1 = vertices.indexOf(edge.getStartVertex());
        int index2 = vertices.indexOf(edge.getFinishVertex());
        if (index1 != -1 && index2 != -1) {
            matrix[index1][index2] = 1;
        }
    }

    @Override
    public void removeEdge(Edge edge) {
        int index1 = vertices.indexOf(edge.getStartVertex());
        int index2 = vertices.indexOf(edge.getFinishVertex());
        if (index1 != -1 && index2 != -1) {
            matrix[index1][index2] = 0;
        }
    }

    @Override
    public List<Vertex> getNeighbors(Vertex vertex) {
        List<Vertex> neighbors = new ArrayList<>();
        int index = vertices.indexOf(vertex);
        if (index != -1) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[index][i] == 1) {
                    neighbors.add(vertices.get(i));
                }
            }
        }
        return neighbors;
    }

    @Override
    public void readFromFile(String filename) {
        // Реализация чтения из файла
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdjacencyMatrix other)) return false;
        return Arrays.deepEquals(matrix, other.matrix) && vertices.equals(other.vertices);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vertices.size(); i++) {
            sb.append(vertices.get(i)).append(": ");
            for (int j = 0; j < vertices.size(); j++) {
                if (matrix[i][j] == 1) {
                    sb.append(vertices.get(j)).append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public List<Vertex> topologicalSort() {
       return null;
    }
}
