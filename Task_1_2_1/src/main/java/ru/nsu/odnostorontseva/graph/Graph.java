package ru.nsu.odnostorontseva.graph;

import java.io.InputStream;
import java.util.List;
import java.util.function.Function;
import ru.nsu.odnostorontseva.graph.basicparts.Edge;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;

/**
 * Determine the overall contract between the graph-objects.
 */
public interface Graph<T> {
    /**
     * Method for adding a vertex into graph.
     *
     * @param vertex (вершина, которую нужно добавить)
     */
    void addVertex(Vertex<T> vertex);

    /**
     * Method for removing a vertex from graph.
     *
     * @param vertex (вершина, которую нужно удалить).
     */
    void removeVertex(Vertex<T> vertex);


    /**
     * Method for adding an edge into graph.
     *
     * @param edge (ребро, которое нужно добавить).
     */
    void addEdge(Edge<T> edge);


    /**
     * Method for removing an edge from graph.
     *
     * @param edge (ребро, которое нужно удалить).
     */
    void removeEdge(Edge<T> edge);


    /**
     * Method, which returns all neighbors of vertex.
     *
     * @param vertex (вершина, соседи которой нам нужны).
     * @return (список всех соседей вершины).
     */
    List<Vertex<T>> getNeighbors(Vertex<T> vertex);

    /**
     * Method, which returns all vertices in graph.
     *
     * @return (список всех вершин графа).
     */
    List<Vertex<T>> getAllVertices();

    /**
     * Method which read an information about graph from file.
     *
     * @param file (поток ввода).
     */
    void readFromFile(InputStream file, Function<String, T> parse);

    /**
     * Method which using to make a vertex-sort.
     *
     * @param sorter (алгоритм сортировки).
     * @return (список отсортированных вершин).
     */
    List<Vertex<T>> sort(Algorithm<T> sorter);
}
