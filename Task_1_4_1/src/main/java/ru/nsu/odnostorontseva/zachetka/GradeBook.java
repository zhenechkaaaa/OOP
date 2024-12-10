package ru.nsu.odnostorontseva.zachetka;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class representing a student's grade book.
 */
public class GradeBook {
    private final Student student;

    /**
     * Constructor.
     *
     * @param student (student).
     */
    public GradeBook(Student student) {
        this.student = student;
    }

    /**
     * Method to calculate an average grade.
     *
     * @return (average grade).
     */
    public double calcAverageGrade() {
        List<Grade> lastGrades = student.getGrades().stream()
                .collect(Collectors.groupingBy(
                        grade -> grade.getSubject() + '-' + grade.getSemester(),
                        Collectors.maxBy(Comparator.comparing(Grade::getSemester))
                )).values().stream()
                .flatMap(Optional::stream)
                .filter(grade -> !grade.getGradeType().equals("зачёт"))
                .toList();

        int totalGrades = lastGrades.stream().mapToInt(Grade::getGradeValue).sum();
        int numOfGrades = lastGrades.size();

        return numOfGrades > 0 ? (double) totalGrades / numOfGrades : 0;
    }

    /**
     * Method to check possibility of switching to the budget.
     *
     * @return (true or false - can or cannot).
     */
    public boolean canSwitchToBudget() throws Exception {
        if (!student.isPaidEducation()) {
            throw new Exception("Student is already on budget.");
        }

        List<Grade> grades = student.getGrades();

        int maxSemester = grades.stream()
                .mapToInt(Grade::getSemester)
                .max()
                .orElse(0);

        Set<Integer> lastTwoSemesters = Set.of(maxSemester, maxSemester - 1);

        return grades.stream()
                .filter(grade -> lastTwoSemesters.contains(grade.getSemester()))
                .allMatch(g -> g.getGradeType().equals("зачёт")
                        ? g.getGradeValue() == 1 : g.getGradeValue() > 3)
                && isOk(maxSemester);
    }

    /**
     * Method to check possibility of getting the red diploma.
     *
     * @return (true or false - can or cannot).
     */
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
                .anyMatch(grade -> grade.getSubject().equals("ВКР")
                        && grade.getGradeValue() == 5);

        double excellentPercentage = (double) excellentGrades / totalGradedSubjects;

        int lastSemester = grades.stream()
                .mapToInt(Grade::getSemester)
                .max()
                .orElse(0);

        return excellentPercentage >= 0.75
                && hasNoSatisfactory
                && hasExcellentQualificationWork
                && isOk(lastSemester);
    }

    /**
     * Method to check possibility of getting increased scholarship.
     *
     * @param semester (number of last semester)
     * @return (true or false - can or cannot)
     */
    public boolean canGetIncreasedScholarship(int semester) throws Exception {
        if (student.isPaidEducation()) {
            throw new Exception("Student can't get scholarship");
        }

        List<Grade> grades = student.getGrades();
        return grades.stream()
                .filter(g -> g.getSemester() == semester)
                .allMatch(g -> g.getGradeType().equals("зачёт")
                        ? g.getGradeValue() == 1 : g.getGradeValue() == 5)
                && isOk(semester);
    }

    public boolean isOk(int semester) {
        Map<Integer, Integer> grades = new HashMap<>();
        grades.put(1, 9);
        grades.put(2, 8);
        grades.put(3, 8);
        grades.put(4, 10);
        grades.put(5, 7);
        grades.put(6, 8);
        grades.put(7, 6);
        grades.put(8, 2);

        int all = student.getGrades().size();
        int cnt = 0;

        for (int i = 1; i <= semester; i++) {
            cnt += grades.get(i);
        }
        return all == cnt;
    }
}
