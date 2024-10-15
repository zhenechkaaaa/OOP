package ru.nsu.odnostorontseva.graph.implementations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import ru.nsu.odnostorontseva.graph.Graph;
import ru.nsu.odnostorontseva.graph.basicparts.Edge;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;


public class AdjacencyList implements Graph {
    private final List<Vertex> vertices;
    private final List<List<Vertex>> adjacencyList;

    public AdjacencyList(List<Vertex> vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices.size());
        for (Vertex v : vertices) {
            adjacencyList.add(new ArrayList<>());
        }
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
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().trim().split(" ");
                Edge e;
                try {
                    if (line.length == 3) {
                        e = Edge.createEdge(new Vertex(line[0]), new Vertex(line[1]), 1, Boolean.parseBoolean(line[2]));
                    } else if (line.length == 4) {
                        e = Edge.createEdge(new Vertex(line[0]), new Vertex(line[1]), Integer.parseInt(line[2]), Boolean.parseBoolean(line[3]));
                    } else {
                        throw new IllegalArgumentException("Wrong number of arguments");
                    }
                } catch (IllegalArgumentException ex) {
                    throw new IllegalArgumentException("Wrong type of arguments");
                }
                this.addEdge(e);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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

    }
}
