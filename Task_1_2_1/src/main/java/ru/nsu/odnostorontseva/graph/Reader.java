package ru.nsu.odnostorontseva.graph;

import java.io.InputStream;
import java.util.Scanner;
import java.util.function.Function;

import ru.nsu.odnostorontseva.graph.basicparts.Edge;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;

/**
 * Special class to read an info from file.
 *
 * @param <T> параметр.
 */
public class Reader<T> {

    /**
     * Read edges from file and add them into a graph.
     *
     * @param file  (поток ввода).
     * @param graph (тип представления гарфа).
     * @param parse (функция для парсинга в нужный тип).
     */
    public void readFromFile(InputStream file, Graph<T> graph, Function<String, T> parse) {
        Scanner scanner = new Scanner(file);

        if (!scanner.hasNextLine()) {
            throw new IllegalArgumentException("The file is empty.");
        }

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().trim().split(" ");

            Edge<T> e;
            try {
                if (line.length == 3) {
                    e = new Edge<>(new Vertex<>(parse.apply(line[0])),
                            new Vertex<>(parse.apply(line[1])),
                            Integer.parseInt(line[2]), false);
                } else if (line.length == 4) {
                    e = new Edge<>(new Vertex<>(parse.apply(line[0])),
                            new Vertex<>(parse.apply(line[1])),
                            Integer.parseInt(line[2]), true);
                } else {
                    throw new IllegalArgumentException("Wrong number of arguments");
                }
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Wrong type of arguments");
            }
            graph.addEdge(e);
        }
    }
}
