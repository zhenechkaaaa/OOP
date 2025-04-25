package ru.nsu.odnostorontseva.autochecker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Assigment {
    private String taskId;
    private List<Student> students = new ArrayList<Student>();

    @Override
    public String toString() {
        return "Assigment [taskId=" + taskId + ", students=" + students + "]";
    }
}
