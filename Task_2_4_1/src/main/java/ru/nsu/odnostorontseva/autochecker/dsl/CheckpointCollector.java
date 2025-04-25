package ru.nsu.odnostorontseva.autochecker.dsl;

import lombok.Getter;
import ru.nsu.odnostorontseva.autochecker.CourseConfigBaseListener;
import ru.nsu.odnostorontseva.autochecker.CourseConfigParser;
import ru.nsu.odnostorontseva.autochecker.model.Checkpoint;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CheckpointCollector extends CourseConfigBaseListener {
    private List<Checkpoint> checkpoints = new ArrayList<>();

    @Override
    public void enterCheckpointDef(CourseConfigParser.CheckpointDefContext ctx) {
        String checkpointId = ctx.ID().getText();
        LocalDate date = LocalDate.parse(stripQuotes(ctx.STRING().getText()));

        checkpoints.add(new Checkpoint(checkpointId, date));
    }

    private String stripQuotes(String s) {
        return s.substring(1, s.length() - 1);
    }
}
