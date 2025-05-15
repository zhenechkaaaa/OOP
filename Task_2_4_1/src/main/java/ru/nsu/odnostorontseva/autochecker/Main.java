package ru.nsu.odnostorontseva.autochecker;

import ru.nsu.odnostorontseva.autochecker.dsl.CourseConfigLoader;
import ru.nsu.odnostorontseva.autochecker.model.Checkpoint;
import ru.nsu.odnostorontseva.autochecker.model.Group;
import ru.nsu.odnostorontseva.autochecker.model.Task;

import java.nio.file.Path;
import java.util.List;

public class Main{
    public static void main(String[] args) throws Exception {
        CourseConfigLoader loader = new CourseConfigLoader();
        List<Task> tasks = loader.loadTasks(Path.of("config/Tasks.gdsl"));
        List<Group> groups = loader.loadGroups(Path.of("config/Groups.gdsl"));
        List<Checkpoint> checkpoints = loader.loadCheckpoints(Path.of("config/Checkpoints.gdsl"));

        for (Task task : tasks) {
            System.out.println(task);
        }

        for (Group group : groups) {
            System.out.println(group);
        }

        for (Checkpoint checkpoint : checkpoints) {
            System.out.println(checkpoint);
        }
    }
}
