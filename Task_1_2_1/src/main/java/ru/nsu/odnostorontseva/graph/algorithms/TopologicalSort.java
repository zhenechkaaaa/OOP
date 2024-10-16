package ru.nsu.odnostorontseva.graph.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.nsu.odnostorontseva.graph.Algorithm;
import ru.nsu.odnostorontseva.graph.Graph;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;


public class TopologicalSort implements Algorithm {

    @Override
    public List<Vertex> sort(Graph graph) {
        List<Vertex> res = new ArrayList<>();
        int numOfVertices = graph.getAllVertices().size();
        boolean[] visited = new boolean[numOfVertices];
        boolean[] tempMarked = new boolean[numOfVertices];

        for (int i = 0; i < numOfVertices; i++) {
            if (!visited[i]) {
                if (!dfs(graph.getAllVertices().get(i), visited, tempMarked, res, graph)) {
                    throw new IllegalStateException("Граф содержит цикл, топологическая сортировка невозможна.");
                }
            }
        }

        Collections.reverse(res);
        return res;
    }

    private boolean dfs(Vertex v, boolean[] visited, boolean[] tempMarked, List<Vertex> res, Graph graph) {
        tempMarked[graph.getAllVertices().indexOf(v)] = true;

        for (Vertex n : graph.getNeighbors(v)) {
            if (tempMarked[graph.getAllVertices().indexOf(n)]) {
                return false;
            }

            if(!visited[graph.getAllVertices().indexOf(n)]) {
                if(!dfs(n, visited, tempMarked, res, graph)) {
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
