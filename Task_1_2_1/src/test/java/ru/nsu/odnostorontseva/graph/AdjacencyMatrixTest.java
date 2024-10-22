package ru.nsu.odnostorontseva.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import ru.nsu.odnostorontseva.graph.algorithms.TopologicalSort;
import ru.nsu.odnostorontseva.graph.basicparts.Edge;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;
import ru.nsu.odnostorontseva.graph.implementations.AdjacencyMatrix;


class AdjacencyMatrixTest{

    @Test
    void addStringVertexTest() {
        AdjacencyMatrix<String> graph = new AdjacencyMatrix<>(List.of());
        Vertex<String> a = new Vertex<>("A");
        graph.addVertex(a);
        assertEquals(1, graph.getAllVertices().size());
    }

    @Test
    void addIntVertexTest() {
        AdjacencyMatrix<Integer> graph = new AdjacencyMatrix<>(List.of());
        Vertex<Integer> a = new Vertex<>(5);
        graph.addVertex(a);
        assertEquals(1, graph.getAllVertices().size());
    }

    @Test
    void removeVertexTest() {
        AdjacencyMatrix<String> graph = new AdjacencyMatrix<>(List.of());
        Vertex<String> a = new Vertex<>("a");
        graph.addVertex(a);
        graph.removeVertex(a);
        assertEquals(0, graph.getAllVertices().size());
    }

    @Test
    void addEdgeTest() {
        AdjacencyMatrix<String> graph = new AdjacencyMatrix<>(List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);

        graph.addEdge(e);

        int indexA = graph.getAllVertices().indexOf(a);
        int indexB = graph.getAllVertices().indexOf(b);
        ArrayList<ArrayList<Integer>> testMatrix = graph.getMatrix();
        assertEquals(1, testMatrix.get(indexA).get(indexB));
        assertEquals(1, testMatrix.get(indexB).get(indexA));
    }


    @Test
    void addDirectedEdgeTest() {
        AdjacencyMatrix<String> graph = new AdjacencyMatrix<>(List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, true);

        graph.addEdge(e);

        int indexA = graph.getAllVertices().indexOf(a);
        int indexB = graph.getAllVertices().indexOf(b);
        ArrayList<ArrayList<Integer>> testMatrix = graph.getMatrix();
        assertEquals(1, testMatrix.get(indexA).get(indexB));
        assertEquals(0, testMatrix.get(indexB).get(indexA));
    }

    @Test
    void removeEdge() {
        AdjacencyMatrix<String> graph = new AdjacencyMatrix<>(List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);

        graph.addEdge(e);
        graph.removeEdge(e);

        int indexA = graph.getAllVertices().indexOf(a);
        int indexB = graph.getAllVertices().indexOf(b);
        ArrayList<ArrayList<Integer>> testMatrix = graph.getMatrix();
        assertEquals(0, testMatrix.get(indexA).get(indexB));
        assertEquals(0, testMatrix.get(indexB).get(indexA));
    }

    @Test
    void getNeighbors() {
        AdjacencyMatrix<String> graph = new AdjacencyMatrix<>(List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Vertex<String> c = new Vertex<>("c");

        Edge<String> edge1 = new Edge<>(a, b, 1, false);
        graph.addEdge(edge1);

        Edge<String> edge2 = new Edge<>(b, c, 1, false);
        graph.addEdge(edge2);

        List<Vertex<String>> neighbors = graph.getNeighbors(b);
        assertEquals(2, neighbors.size());
        assertTrue(neighbors.contains(a));
        assertTrue(neighbors.contains(c));
    }

    @Test
    void readFromFileTest() {
        //to do
    }

    @Test
    void equalsItselfTest() {
        AdjacencyMatrix<String> graph = new AdjacencyMatrix<>(List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);
        graph.addEdge(e);

        assertEquals(graph, graph);
    }

    @Test
    void equalsTest() {
        AdjacencyMatrix<String> graph = new AdjacencyMatrix<>(List.of());
        AdjacencyMatrix<String> graph1 = new AdjacencyMatrix<>(List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);
        graph1.addEdge(e);
        graph.addEdge(e);

        assertEquals(graph1, graph);
    }

    @Test
    void notEqualsTest() {
        AdjacencyMatrix<String> graph = new AdjacencyMatrix<>(List.of());
        AdjacencyMatrix<String> graph1 = new AdjacencyMatrix<>(List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);

        Vertex<String> c = new Vertex<>("c");
        Edge<String> e2 = new Edge<>(b, c, 1, false);
        graph1.addEdge(e2);
        graph.addEdge(e);

        assertNotEquals(graph1, graph);
    }

    @Test
    void equalsNullTest() {
        AdjacencyMatrix<String> graph = new AdjacencyMatrix<>(List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);
        graph.addEdge(e);

        assertNotEquals(graph, null);
    }

    @Test
    void equalsDiffObjectsTest() {
        AdjacencyMatrix<String> graph = new AdjacencyMatrix<>(List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);
        graph.addEdge(e);

        assertNotEquals(graph, "adjacency matrix");
    }

    @Test
    void testHashCode() {
        AdjacencyMatrix<String> graph = new AdjacencyMatrix<>(List.of());
        AdjacencyMatrix<String> graph1 = new AdjacencyMatrix<>(List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);
        graph1.addEdge(e);
        graph.addEdge(e);

        assertEquals(graph.hashCode(), graph1.hashCode());
    }

    @Test
    void testToString() {
        AdjacencyMatrix<String> graph = new AdjacencyMatrix<>(List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Vertex<String> c = new Vertex<>("c");

        Edge<String> edge1 = new Edge<>(a, b, 1, false);
        Edge<String> edge2 = new Edge<>(b, c, 1, false);

        graph.addEdge(edge1);
        graph.addEdge(edge2);

        String expected = """
                  a b c\s
                a 0 1 0\s
                b 1 0 1\s
                c 0 1 0\s
                """;

        assertEquals(expected, graph.toString());
    }

    @Test
    void sort() {
        AdjacencyMatrix<String> graph = new AdjacencyMatrix<>(List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Vertex<String> c = new Vertex<>("c");

        Edge<String> edge1 = new Edge<>(a, b, 1, true);
        Edge<String> edge2 = new Edge<>(b, c, 1, true);

        graph.addEdge(edge1);
        graph.addEdge(edge2);

        List<Vertex<String>> list = Arrays.asList(a, b, c);

        assertEquals(list, graph.sort(new TopologicalSort<>()));
    }
}