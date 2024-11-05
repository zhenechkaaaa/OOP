package ru.nsu.odnostorontseva.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import ru.nsu.odnostorontseva.graph.algorithms.TopologicalSort;
import ru.nsu.odnostorontseva.graph.basicparts.Edge;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;
import ru.nsu.odnostorontseva.graph.implementations.IncidenceMatrix;

class IncidenceMatrixTest {

    @Test
    void addStringVertexTest() {
        IncidenceMatrix<String> graph = new IncidenceMatrix<>(List.of(), List.of());
        Vertex<String> a = new Vertex<>("A");
        graph.addVertex(a);
        assertEquals(1, graph.getAllVertices().size());
    }

    @Test
    void addIntVertexTest() {
        IncidenceMatrix<Integer> graph = new IncidenceMatrix<>(List.of(), List.of());
        Vertex<Integer> a = new Vertex<>(5);
        graph.addVertex(a);
        assertEquals(1, graph.getAllVertices().size());
    }

    @Test
    void removeVertexTest() {
        IncidenceMatrix<String> graph = new IncidenceMatrix<>(List.of(), List.of());
        Vertex<String> a = new Vertex<>("a");
        graph.addVertex(a);
        graph.removeVertex(a);
        assertEquals(0, graph.getAllVertices().size());
    }

    @Test
    void addUndirectedEdgeTest() {
        IncidenceMatrix<String> graph = new IncidenceMatrix<>(List.of(), List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);

        graph.addEdge(e);

        List<List<Integer>> testMatrix = graph.getMatrix();
        int vertexIndexA = graph.getAllVertices().indexOf(a);
        int vertexIndexB = graph.getAllVertices().indexOf(b);

        assertEquals(1, testMatrix.get(vertexIndexA).get(0)); // Вершина a инцидентна ребру
        assertEquals(1, testMatrix.get(vertexIndexB).get(0)); // Вершина b инцидентна ребру
    }

    @Test
    void addDirectedEdgeTest() {
        IncidenceMatrix<String> graph = new IncidenceMatrix<>(List.of(), List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, true);

        graph.addEdge(e);

        List<List<Integer>> testMatrix = graph.getMatrix();
        int vertexIndexA = graph.getAllVertices().indexOf(a);
        int vertexIndexB = graph.getAllVertices().indexOf(b);

        assertEquals(1, testMatrix.get(vertexIndexA).get(0));
        assertEquals(-1, testMatrix.get(vertexIndexB).get(0));
    }

    @Test
    void removeEdgeTest() {
        IncidenceMatrix<String> graph = new IncidenceMatrix<>(List.of(), List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);

        graph.addEdge(e);
        graph.removeEdge(e);

        List<List<Integer>> testMatrix = graph.getMatrix();
        int vertexIndexA = graph.getAllVertices().indexOf(a);
        int vertexIndexB = graph.getAllVertices().indexOf(b);

        assertEquals(0, testMatrix.get(vertexIndexA).get(0));
        assertEquals(0, testMatrix.get(vertexIndexB).get(0));
    }

    @Test
    void getNeighborsTest() {
        IncidenceMatrix<String> graph = new IncidenceMatrix<>(List.of(), List.of());
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
    void equalsItselfTest() {
        IncidenceMatrix<String> graph = new IncidenceMatrix<>(List.of(), List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);
        graph.addEdge(e);

        assertEquals(graph, graph);
    }

    @Test
    void equalsTest() {
        IncidenceMatrix<String> graph = new IncidenceMatrix<>(List.of(), List.of());
        IncidenceMatrix<String> graph1 = new IncidenceMatrix<>(List.of(), List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);
        graph1.addEdge(e);
        graph.addEdge(e);

        assertEquals(graph1, graph);
    }

    @Test
    void notEqualsTest() {
        IncidenceMatrix<String> graph = new IncidenceMatrix<>(List.of(), List.of());
        IncidenceMatrix<String> graph1 = new IncidenceMatrix<>(List.of(), List.of());
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
        IncidenceMatrix<String> graph = new IncidenceMatrix<>(List.of(), List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);
        graph.addEdge(e);

        assertNotEquals(graph, null);
    }

    @Test
    void equalsDiffObjectsTest() {
        IncidenceMatrix<String> graph = new IncidenceMatrix<>(List.of(), List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);
        graph.addEdge(e);

        assertNotEquals(graph, "incidence matrix");
    }

    @Test
    void testHashCode() {
        IncidenceMatrix<String> graph = new IncidenceMatrix<>(List.of(), List.of());
        IncidenceMatrix<String> graph1 = new IncidenceMatrix<>(List.of(), List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);
        graph1.addEdge(e);
        graph.addEdge(e);

        assertEquals(graph.hashCode(), graph1.hashCode());
    }

    @Test
    void testToString() {
        IncidenceMatrix<String> graph = new IncidenceMatrix<>(List.of(), List.of());
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Vertex<String> c = new Vertex<>("c");

        Edge<String> edge1 = new Edge<>(a, b, 1, false);
        Edge<String> edge2 = new Edge<>(b, c, 1, false);

        graph.addEdge(edge1);
        graph.addEdge(edge2);

        String expected = """
                 a b c\s
              e1 1 1 0\s
              e2 0 1 1\s
              """;

        assertEquals(expected, graph.toString());
    }

    @Test
    void sortTest() {
        IncidenceMatrix<String> graph = new IncidenceMatrix<>(List.of(), List.of());
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
