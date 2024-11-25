package ru.nsu.odnostorontseva.zachetka;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class GradeBook {
    private final Student student;

    public GradeBook(Student student) {
        this.student = student;
    }

    public double calcGPA() {
        List<Grade> lastGrades = student.getGrades().stream()
                .collect(Collectors.groupingBy(
                        grade -> grade.getSubject() + '-' + grade.getSemester(),
                        Collectors.maxBy(Comparator.comparing(Grade::getSemester))
                )).values().stream()
                .flatMap(Optional::stream)
                .toList();

        int totalGrades = lastGrades.stream().mapToInt(Grade::getGradeValue).sum();
        int numOfGrades = lastGrades.size();

        return numOfGrades > 0 ? (double) totalGrades / numOfGrades : 0;
    }

    public boolean canSwitchToBudget() {
        List<Grade> grades = student.getGrades();

        int maxSemester = grades.stream()
                .mapToInt(Grade::getSemester)
                .max()
                .orElse(0);

        Set<Integer> lastTwoSemesters = Set.of(maxSemester, maxSemester - 1);

        return grades.stream()
                .filter(grade -> lastTwoSemesters.contains(grade.getSemester()))
                .allMatch(grade -> grade.getGradeValue() > 3);
    }

    public boolean canGetRedDiploma() {
        List<Grade> grades = student.getGrades();

        long excellentGrades = grades.stream()
                .filter(g -> g.getGradeValue() == 5)
                .count();

        long totalGradedSubjects = grades.stream()
                .filter(g -> g.getGradeValue() >= 3) // Only consider subjects with grades
                .count();

        boolean hasNoSatisfactory = grades.stream()
                .noneMatch(g -> g.getGradeValue() == 3);

        boolean hasExcellentQualificationWork = grades.stream()
                .anyMatch(grade -> grade.getSubject().equals("Qualification Work")
                        && grade.getGradeValue() == 5);

        double excellentPercentage = (double) excellentGrades / totalGradedSubjects;

        return excellentPercentage >= 0.75 && hasNoSatisfactory && hasExcellentQualificationWork;
    }

    public boolean canGetIncreasedScholarship(int currentSemester) {
        List<Grade> grades = student.getGrades();
        return grades.stream()
                .filter(g -> g.getSemester() == currentSemester)
                .allMatch(g -> g.getGradeValue() == 5 || g.getGradeType().equals("зачет"));
    }
}
