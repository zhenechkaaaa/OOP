package ru.nsu.odnostorontseva.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import ru.nsu.odnostorontseva.graph.basicparts.Edge;
import ru.nsu.odnostorontseva.graph.basicparts.Vertex;

public class Reader {

    /**
     * Read edges from file and add them into a graph.
     *
     * @param filename (имя файла).
     * @param graph (тип представления гарфа).
     */
    public static void readFromFile(String filename, Graph graph) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().trim().split(" ");
                Edge e;
                try {
                    if (line.length == 3) {
                        e = Edge.createEdge(new Vertex(line[0]), new Vertex(line[1]), 1, Boolean.parseBoolean(line[2]));
                    } else if (line.length == 4) {
                        e = Edge.createEdge(new Vertex(line[0]), new Vertex(line[1]), Integer.parseInt(line[2]), Boolean.parseBoolean(line[3]));
                    } else {
                        throw new IllegalArgumentException("Wrong number of arguments");
                    }
                } catch (IllegalArgumentException ex) {
                    throw new IllegalArgumentException("Wrong type of arguments");
                }
                graph.addEdge(e);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
