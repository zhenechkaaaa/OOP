package ru.nsu.odnostorontseva.autochecker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class Checkpoint {
    private String id;
    private LocalDate date;

    @Override
    public String toString() {
        return "Checkpoint [id=" + id + ", date=" + date + "]";
    }
}
