package ru.nsu.odnostorontseva.graph;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;
import ru.nsu.odnostorontseva.graph.implementations.AdjacencyList;

class ReaderTest {

    @Test
    void readStringGraphTest() throws IOException {
        Graph<String> graph = new AdjacencyList<>();
        graph.readFromFile("src/main/resources/strGraph", str -> str);
        assertTrue(graph.getAllVertices().contains(new Vertex<>("a")));
    }

    @Test
    void readIntGraphTest() throws IOException {
        Graph<Integer> graph = new AdjacencyList<>();
        graph.readFromFile("src/main/resources/intGraph", Integer::parseInt);
        assertTrue(graph.getAllVertices().contains(new Vertex<>(2)));
    }

    @Test
    void readDblGraphTest() throws IOException {
        Graph<Double> graph = new AdjacencyList<>();
        graph.readFromFile("src/main/resources/dblGraph", Double::parseDouble);
        assertTrue(graph.getAllVertices().contains(new Vertex<>(4.5)));
    }

    @Test
    void readEmptyFileTest() {
        Graph<Integer> graph = new AdjacencyList<>();
        assertThrows(IllegalArgumentException.class,
                () -> graph.readFromFile("src/main/resources/emptFile", Integer::parseInt));
    }

    @Test
    void noFileTest() {
        Graph<Integer> graph = new AdjacencyList<>();
        assertThrows(RuntimeException.class,
                () -> graph.readFromFile("File.txt", Integer::parseInt));
    }

    @Test
    void wrongTypeTest() {
        Graph<Integer> graph = new AdjacencyList<>();
        assertThrows(IllegalArgumentException.class,
                () -> graph.readFromFile("src/main/resources/strGraph", Integer::parseInt));
    }

    @Test
    void notEnoughVertexes() {
        Graph<Integer> graph = new AdjacencyList<>();
        assertThrows(RuntimeException.class,
                () -> graph.readFromFile("src/main/resources/wrngFile", Integer::parseInt));
    }



}