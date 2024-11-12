package ru.nsu.odnostorontseva.graph.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ru.nsu.odnostorontseva.graph.Algorithm;
import ru.nsu.odnostorontseva.graph.Graph;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;

/**
 * Special class representing toposort.
 *
 * @param <T> параметр.
 */
public class TopologicalSort<T> implements Algorithm<T> {

    @Override
    public List<Vertex<T>> sort(Graph<T> graph) {
        List<Vertex<T>> res = new ArrayList<>();
        int numOfVertices = graph.getAllVertices().size();
        boolean[] visited = new boolean[numOfVertices];
        boolean[] tempMarked = new boolean[numOfVertices];

        for (int i = 0; i < numOfVertices; i++) {
            if (!visited[i]) {
                if (!dfs(graph.getAllVertices().get(i), visited, tempMarked, res, graph)) {
                    throw new IllegalStateException(
                            "Граф содержит цикл, топологическая сортировка невозможна.");
                }
            }
        }

        Collections.reverse(res);
        return res;
    }

    private boolean dfs(Vertex<T> v,
                        boolean[] visited,
                        boolean[] tempMarked,
                        List<Vertex<T>> res,
                        Graph<T> graph) {
        tempMarked[graph.getAllVertices().indexOf(v)] = true;

        List<Vertex<T>> neighbors = graph.getNeighbors(v);
        if (neighbors == null) {
            tempMarked[graph.getAllVertices().indexOf(v)] = false;
            visited[graph.getAllVertices().indexOf(v)] = true;
            res.add(v);
            return true;
        }
        for (Vertex<T> n : neighbors) {
            if (tempMarked[graph.getAllVertices().indexOf(n)]) {
                return false;
            }

            if (!visited[graph.getAllVertices().indexOf(n)]) {
                if (!dfs(n, visited, tempMarked, res, graph)) {
                    return false;
                }
            }
        }

        tempMarked[graph.getAllVertices().indexOf(v)] = false;
        visited[graph.getAllVertices().indexOf(v)] = true;
        res.add(v);
        return true;
    }
}
