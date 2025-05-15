package ru.nsu.odnostorontseva.autochecker.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Task {
    public String id;
    public String title;
    public int maxPoints;
    public LocalDate softDeadline;
    public LocalDate hardDeadline;

    @Override
    public String toString() {
        return "Task[" + id + ", " + title + ", " + maxPoints + ", " + softDeadline + ", " + hardDeadline + "]";
    }
}
