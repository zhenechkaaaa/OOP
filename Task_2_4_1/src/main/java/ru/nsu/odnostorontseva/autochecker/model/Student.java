package ru.nsu.odnostorontseva.autochecker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private String id;
    private String name;
    private String github;
    private String repo;

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", github=" + github + ", repo=" + repo + "]";
    }
}
