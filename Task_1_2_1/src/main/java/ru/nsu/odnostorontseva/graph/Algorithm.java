package ru.nsu.odnostorontseva.graph;

import ru.nsu.odnostorontseva.graph.basicparts.Vertex;
import java.util.List;

public interface Algorithm<T> {
    List<Vertex<T>> sort(Graph<T> graph);
}
