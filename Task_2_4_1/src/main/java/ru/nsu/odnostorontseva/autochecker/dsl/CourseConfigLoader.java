package ru.nsu.odnostorontseva.autochecker.dsl;

import lombok.Getter;
import ru.nsu.odnostorontseva.autochecker.CourseConfigBaseListener;
import ru.nsu.odnostorontseva.autochecker.CourseConfigLexer;
import ru.nsu.odnostorontseva.autochecker.CourseConfigParser;
import ru.nsu.odnostorontseva.autochecker.model.Task;
import ru.nsu.odnostorontseva.autochecker.model.Group;
import ru.nsu.odnostorontseva.autochecker.model.Student;
import ru.nsu.odnostorontseva.autochecker.model.Checkpoint;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

@Getter
public class CourseConfigLoader {

    public List<Task> loadTasks(Path path) throws IOException {
        CharStream input = CharStreams.fromPath(path);
        CourseConfigLexer lexer = new CourseConfigLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CourseConfigParser parser = new CourseConfigParser(tokens);
        ParseTree tree = parser.config();

        TaskCollector collector = new TaskCollector();
        ParseTreeWalker.DEFAULT.walk(collector, tree);

        return collector.getTasks();
    }

    public List<Group> loadGroups(Path path) throws IOException {
        CharStream input = CharStreams.fromPath(path);
        CourseConfigLexer lexer = new CourseConfigLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CourseConfigParser parser = new CourseConfigParser(tokens);
        ParseTree tree = parser.config();

        GroupCollector collector = new GroupCollector();
        ParseTreeWalker.DEFAULT.walk(collector, tree);

        return collector.getGroups();
    }

    public List<Checkpoint> loadCheckpoints(Path path) throws IOException {
        CharStream input = CharStreams.fromPath(path);
        CourseConfigLexer lexer = new CourseConfigLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CourseConfigParser parser = new CourseConfigParser(tokens);
        ParseTree tree = parser.config();

        CheckpointCollector collector = new CheckpointCollector();
        ParseTreeWalker.DEFAULT.walk(collector, tree);

        return collector.getCheckpoints();
    }
}

