package ru.nsu.odnostorontseva.autochecker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Group {
    private String id;
    private List<Student> students = new ArrayList<Student>();

    @Override
    public String toString() {
        return "Group [id=" + id + ", students=" + students + "]";
    }
}
