package ru.nsu.odnostorontseva.graph;

import java.util.List;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;

public interface Algorithm<T> {
    List<Vertex<T>> sort(Graph<T> graph);
}
