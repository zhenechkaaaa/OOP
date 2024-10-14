package ru.nsu.odnostorontseva.graph.Implementations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.odnostorontseva.graph.BasicParts.Edge;
import ru.nsu.odnostorontseva.graph.BasicParts.Vertex;

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
        assertTrue(graph.getVertices().contains(a));
    }

    @Test
    void removeVertexTest() {
        Vertex a = new Vertex("a");
        graph.addVertex(a);
        graph.removeVertex(a);
        assertFalse(graph.getVertices().contains(a));
    }

    @Test
    void addUnweightedEdgeTest() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Edge edge = new Edge(a, b, 1, false);
        graph.addEdge(edge);

        int[][] matrix = graph.getMatrix();
        int indexA = graph.getVertices().indexOf(a);
        int indexB = graph.getVertices().indexOf(b);

        assertEquals(1, matrix[indexA][indexB]);
        assertEquals(1, matrix[indexB][indexA]);
    }

    @Test
    void addWeightedEdgeTest() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Edge edge = new Edge(a, b, 8, false);
        graph.addEdge(edge);

        int[][] matrix = graph.getMatrix();
        int indexA = graph.getVertices().indexOf(a);
        int indexB = graph.getVertices().indexOf(b);

        assertEquals(8, matrix[indexA][indexB]);
        assertEquals(8, matrix[indexB][indexA]);
    }

    @Test
    void removeEdgeTest() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Edge edge = new Edge(a, b, 1, false);
        graph.addEdge(edge);
        graph.removeEdge(edge);

        int[][] matrix = graph.getMatrix();
        int indexA = graph.getVertices().indexOf(a);
        int indexB = graph.getVertices().indexOf(b);

        assertEquals(0, matrix[indexA][indexB]);
        assertEquals(0, matrix[indexB][indexA]);
    }

    @Test
    void getNeighborsTest() {
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
    void readFromFileTest() {
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

        //assertEquals("  a b c \n" +
        //                       "a 0 1 0 \n" +
        //                       "b 1 0 1 \n" +
        //                       "c 0 1 0 ",
        //        graph.toString());
    }

    @Test
    void topologicalSort() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);

        graph.addEdge(Edge.createEdge(a, b, 1, true));
        graph.addEdge(Edge.createEdge(b, c, 1, true));

        List<Vertex> sorted = graph.topologicalSort();

        assertEquals(a, sorted.get(0));
        assertEquals(b, sorted.get(1));
        assertEquals(c, sorted.get(2));
    }
}