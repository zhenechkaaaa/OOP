package ru.nsu.odnostorontseva.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import ru.nsu.odnostorontseva.graph.algorithms.TopologicalSort;
import ru.nsu.odnostorontseva.graph.basicparts.Edge;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;
import ru.nsu.odnostorontseva.graph.implementations.AdjacencyList;

class AdjacencyListTest {

    @Test
    void addStrVertexTest() {
        AdjacencyList<String> graph = new AdjacencyList<>();
        Vertex<String> a = new Vertex<>("A");
        graph.addVertex(a);
        assertEquals(1, graph.getAllVertices().size());
    }

    @Test
    void addIntVertexTest() {
        AdjacencyList<Integer> graph = new AdjacencyList<>();
        Vertex<Integer> a = new Vertex<>(5);
        graph.addVertex(a);
        assertEquals(1, graph.getAllVertices().size());
    }

    @Test
    void removeVertexTest() {
        AdjacencyList<String> graph = new AdjacencyList<>();
        Vertex<String> a = new Vertex<>("a");
        graph.addVertex(a);
        graph.removeVertex(a);
        assertEquals(0, graph.getAllVertices().size());
    }

    @Test
    void addEdgeTest() {
        AdjacencyList<String> graph = new AdjacencyList<>();
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> edge = new Edge<>(a, b, 1, false);

        graph.addEdge(edge);

        Map<Vertex<String>, List<Vertex<String>>> adjList = graph.getAdjacencyList();
        assertTrue(adjList.get(a).contains(b));
        assertTrue(adjList.get(b).contains(a));
    }

    @Test
    void addDirectedEdgeTest() {
        AdjacencyList<String> graph = new AdjacencyList<>();
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> edge = new Edge<>(a, b, 1, true);

        graph.addEdge(edge);

        Map<Vertex<String>, List<Vertex<String>>> adjList = graph.getAdjacencyList();
        assertTrue(adjList.get(a).contains(b));
        assertFalse(adjList.containsKey(b));
    }

    @Test
    void removeEdgeTest() {
        AdjacencyList<String> graph = new AdjacencyList<>();
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> edge = new Edge<>(a, b, 1, false);

        graph.addEdge(edge);
        graph.removeEdge(edge);

        assertTrue(graph.getAdjacencyList().isEmpty());
    }

    @Test
    void getNeighborsTest() {
        AdjacencyList<String> graph = new AdjacencyList<>();
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Vertex<String> c = new Vertex<>("c");

        Edge<String> edge1 = new Edge<>(a, b, 1, true);
        Edge<String> edge2 = new Edge<>(a, c, 1, true);

        graph.addEdge(edge1);
        graph.addEdge(edge2);

        List<Vertex<String>> neighbors = graph.getNeighbors(a);
        assertTrue(neighbors.contains(b) && neighbors.contains(c));
    }


    @Test
    void readFromFileTest() {
        // to do
    }

    @Test
    void equalsTest() {
        AdjacencyList<String> graph = new AdjacencyList<>();
        AdjacencyList<String> graph1 = new AdjacencyList<>();
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);
        graph1.addEdge(e);
        graph.addEdge(e);

        assertEquals(graph1, graph);
    }

    @Test
    void notEqualsTest() {
        AdjacencyList<String> graph = new AdjacencyList<>();
        AdjacencyList<String> graph1 = new AdjacencyList<>();
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
    void equalNullTest() {
        AdjacencyList<String> graph = new AdjacencyList<>();
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);
        graph.addEdge(e);

        assertNotEquals(graph, null);
    }

    @Test
    void testHashCode() {
        AdjacencyList<String> graph = new AdjacencyList<>();
        AdjacencyList<String> graph1 = new AdjacencyList<>();
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Edge<String> e = new Edge<>(a, b, 1, false);
        graph1.addEdge(e);
        graph.addEdge(e);

        assertEquals(graph1.hashCode(), graph.hashCode());
    }

    @Test
    void testToString() {
        AdjacencyList<String> graph = new AdjacencyList<>();
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Vertex<String> c = new Vertex<>("c");

        Edge<String> edge1 = new Edge<>(a, b, 1, false);
        Edge<String> edge2 = new Edge<>(b, c, 1, false);

        graph.addEdge(edge1);
        graph.addEdge(edge2);

        String expected = """
                a: [b]
                b: [a, c]
                c: [b]
                """;
        assertEquals(expected, graph.toString());
    }

    @Test
    void sort() {
        AdjacencyList<String> graph = new AdjacencyList<>();
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