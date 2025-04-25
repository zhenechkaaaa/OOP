package ru.nsu.odnostorontseva.autochecker.dsl;

import lombok.Getter;
import ru.nsu.odnostorontseva.autochecker.CourseConfigBaseListener;
import ru.nsu.odnostorontseva.autochecker.CourseConfigParser;
import ru.nsu.odnostorontseva.autochecker.model.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class TaskCollector extends CourseConfigBaseListener {
    private List<Task> tasks = new ArrayList<>();

    @Override
    public void enterTaskDef(CourseConfigParser.TaskDefContext ctx) {
        String id = ctx.ID().getText();
        String title = stripQuotes(ctx.STRING(0).getText());
        int max = Integer.parseInt(ctx.NUMBER().getText());
        LocalDate soft = LocalDate.parse(stripQuotes(ctx.STRING(1).getText()));
        LocalDate hard = LocalDate.parse(stripQuotes(ctx.STRING(2).getText()));

        tasks.add(new Task(id, title, max, soft, hard));
    }

    private String stripQuotes(String s) {
        return s.substring(1, s.length() - 1);
    }
}
