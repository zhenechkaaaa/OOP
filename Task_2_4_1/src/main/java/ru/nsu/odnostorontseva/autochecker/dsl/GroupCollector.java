package ru.nsu.odnostorontseva.autochecker.dsl;

import lombok.Getter;
import ru.nsu.odnostorontseva.autochecker.CourseConfigBaseListener;
import ru.nsu.odnostorontseva.autochecker.CourseConfigParser;
import ru.nsu.odnostorontseva.autochecker.model.Group;
import ru.nsu.odnostorontseva.autochecker.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class GroupCollector extends CourseConfigBaseListener {
    private List<Group> groups = new ArrayList<>();
    private Map<String, Student> studentsMap = new HashMap<>();
    private Group currentGroup;

    @Override
    public void enterGroupDef(CourseConfigParser.GroupDefContext ctx) {
        String groupId = ctx.ID().getText();
        currentGroup = new Group(groupId, new ArrayList<>());
        groups.add(currentGroup);
    }

    @Override
    public void enterStudentDef(CourseConfigParser.StudentDefContext ctx) {
        String studentId = ctx.ID().getText();
        String name = stripQuotes(ctx.STRING(0).getText());
        String github = stripQuotes(ctx.STRING(1).getText());
        String repo = stripQuotes(ctx.STRING(2).getText());

        Student student = new Student(studentId, name, github, repo);
        studentsMap.put(studentId, student);

        if(currentGroup !=null) {
            currentGroup.getStudents().add(student);
        }
    }

    private String stripQuotes(String s) {
        return s.substring(1, s.length() - 1);
    }
}
