package ru.nsu.odnostorontseva.graph.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.odnostorontseva.graph.algorithms.TopologicalSort;
import ru.nsu.odnostorontseva.graph.basicparts.Edge;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class AdjacencyMatrixTest {
    private AdjacencyMatrix graph;

    @BeforeEach
    void setUp() {
        graph = new AdjacencyMatrix(List.of());
    }

    @Test
    void addVertexTest() {
        Vertex a = new Vertex("a");
        graph.addVertex(a);
        assertEquals(1, graph.getAllVertices().size());
    }

    @Test
    void removeVertexTest() {
        Vertex a = new Vertex("a");
        graph.addVertex(a);
        graph.removeVertex(a);
        assertEquals(0, graph.getAllVertices().size());
    }

    @Test
    void addEdgeTest() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Edge e = new Edge(a, b, 1, false);

        graph.addEdge(e);

        int indexA = graph.getAllVertices().indexOf(a);
        int indexB = graph.getAllVertices().indexOf(b);
        int[][] testMatrix = graph.getMatrix();
        assertEquals(1, testMatrix[indexA][indexB]);
        assertEquals(1, testMatrix[indexB][indexA]);
    }

    @Test
    void addDirectedEdgeTest() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Edge e = new Edge(a, b, 1, true);

        graph.addEdge(e);

        int indexA = graph.getAllVertices().indexOf(a);
        int indexB = graph.getAllVertices().indexOf(b);
        int[][] testMatrix = graph.getMatrix();
        assertEquals(1, testMatrix[indexA][indexB]);
        assertEquals(0, testMatrix[indexB][indexA]);
    }

    @Test
    void removeEdge() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Edge e = new Edge(a, b, 1, false);

        graph.addEdge(e);
        graph.removeEdge(e);

        int indexA = graph.getAllVertices().indexOf(a);
        int indexB = graph.getAllVertices().indexOf(b);
        int[][] testMatrix = graph.getMatrix();
        assertEquals(0, testMatrix[indexA][indexB]);
        assertEquals(0, testMatrix[indexB][indexA]);
    }

    @Test
    void getNeighbors() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");

        Edge edge1 = new Edge(a, b, 1, false);
        graph.addEdge(edge1);

        Edge edge2 = new Edge(b, c, 1, false);
        graph.addEdge(edge2);

        List<Vertex> neighbors = graph.getNeighbors(b);
        assertEquals(2, neighbors.size());
        assertTrue(neighbors.contains(a));
        assertTrue(neighbors.contains(c));
    }

    @Test
    void readFromFile() {
        //добавить файлы для тесто в ресурсы
    }

    @Test
    void equalsItselfTest() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Edge e = new Edge(a, b, 1, false);
        graph.addEdge(e);

        assertEquals(graph, graph);
    }

    @Test
    void equalsTest() {
        AdjacencyMatrix graph1 = new AdjacencyMatrix(List.of());
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Edge e = new Edge(a, b, 1, false);
        graph1.addEdge(e);
        graph.addEdge(e);

        assertEquals(graph1, graph);
    }

    @Test
    void notEqualsTest() {
        AdjacencyMatrix graph1 = new AdjacencyMatrix(List.of());
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Edge e = new Edge(a, b, 1, false);

        Vertex c = new Vertex("c");
        Edge e2 = new Edge(b, c, 1, false);
        graph1.addEdge(e2);
        graph.addEdge(e);

        assertNotEquals(graph1, graph);
    }

    @Test
    void equalsNullTest() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Edge e = new Edge(a, b, 1, false);
        graph.addEdge(e);

        assertNotEquals(graph, null);
    }

    @Test
    void equalsDiffObjectsTest() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Edge e = new Edge(a, b, 1, false);
        graph.addEdge(e);

        assertNotEquals(graph, "adjacency matrix");
    }

    @Test
    void testHashCode() {
        AdjacencyMatrix graph1 = new AdjacencyMatrix(List.of());
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Edge e = new Edge(a, b, 1, false);
        graph1.addEdge(e);
        graph.addEdge(e);

        assertEquals(graph1.hashCode(), graph1.hashCode());
    }

    @Test
    void testToString() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");

        Edge edge1 = new Edge(a, b, 1, false);
        Edge edge2 = new Edge(b, c, 1, false);

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
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");

        Edge edge1 = new Edge(a, b, 1, true);
        Edge edge2 = new Edge(b, c, 1, true);

        graph.addEdge(edge1);
        graph.addEdge(edge2);

        Vertex[] array = {new Vertex("a"), new Vertex("b"), new Vertex("c")};
        ArrayList<Vertex> list = new ArrayList<Vertex>(Arrays.asList(array));

        assertEquals(list, graph.sort(new TopologicalSort()));
    }
}