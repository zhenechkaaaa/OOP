package ru.nsu.odnostorontseva.graph;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;
import ru.nsu.odnostorontseva.graph.implementations.AdjacencyList;

class ReaderTest {

    @Test
    void readStringGraphTest() throws IOException {
        Graph<String> graph = new AdjacencyList<>();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("strGraph")) {
            assertNotNull(inputStream, "File not found in resources");
            graph.readFromFile(inputStream, str -> str);
        }
        assertTrue(graph.getAllVertices().contains(new Vertex<>("a")));
    }

    @Test
    void readIntGraphTest() throws IOException {
        Graph<Integer> graph = new AdjacencyList<>();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("intGraph")) {
            assertNotNull(inputStream, "File not found in resources");
            graph.readFromFile(inputStream, Integer::parseInt);
        }
        assertTrue(graph.getAllVertices().contains(new Vertex<>(2)));
    }

    @Test
    void readDblGraphTest() throws IOException {
        Graph<Double> graph = new AdjacencyList<>();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("dblGraph")) {
            assertNotNull(inputStream, "File not found in resources");
            graph.readFromFile(inputStream, Double::parseDouble);
        }
        assertTrue(graph.getAllVertices().contains(new Vertex<>(4.5)));
    }

    @Test
    void readEmptyFileTest() {
        Graph<Integer> graph = new AdjacencyList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("emptFile");
        assertNotNull(inputStream, "File not found in resources");

        assertThrows(IllegalArgumentException.class,
                () -> graph.readFromFile(inputStream, Integer::parseInt));
    }

    @Test
    void noFileTest() {
        Graph<Integer> graph = new AdjacencyList<>();
        assertThrows(RuntimeException.class,
                () -> graph.readFromFile(null, Integer::parseInt));
    }

    @Test
    void wrongTypeTest() {
        Graph<Integer> graph = new AdjacencyList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("strGraph");
        assertNotNull(inputStream, "File not found in resources");

        assertThrows(IllegalArgumentException.class,
                () -> graph.readFromFile(inputStream, Integer::parseInt));
    }

    @Test
    void notEnoughVertexes() {
        Graph<Integer> graph = new AdjacencyList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("wrngFile");
        assertNotNull(inputStream, "File not found in resources");

        assertThrows(RuntimeException.class,
                () -> graph.readFromFile(inputStream, Integer::parseInt));
    }


}