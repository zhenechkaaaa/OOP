package ru.nsu.odnostorontseva.zachetka;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String studentFullName;
    private final List<Grade> grades;
    private final boolean isPaidEducation;

    public Student(String studentFullName, boolean isPaidEducation) {
        this.studentFullName = studentFullName;
        this.isPaidEducation = isPaidEducation;
        this.grades = new ArrayList<>();
    }

    public void addGrade(String subject,
                         int semester,
                         String date,
                         String gradeType,
                         int gradeValue)  throws Exception{

        if(gradeValue < 2 || gradeValue > 5) {
            throw new IllegalArgumentException("Grade value must be between 2 and 5");
        }

        boolean hasNonCertification = grades.stream()
                        .anyMatch(grade -> grade.getSemester() == (semester - 1)
                        && grade.getGradeValue() == 2);

        if(hasNonCertification) {
            throw new Exception("Cannot add a new grade. Previous semester has non-certification");
        }

        boolean isExist = grades.stream()
                        .anyMatch(grade -> grade.getSubject().equals(subject)
                        && grade.getSemester() == semester && grade.getGradeType().equals(gradeType));

        if(isExist) {
            grades.stream()
                    .filter(grade -> grade.getSubject().equals(subject)
                            && grade.getSemester() == semester)
                    .forEach(grade -> {
                        grade.setDate(date);
                        grade.setGradeValue(gradeValue);

                    });
        } else {
            grades.add(new Grade(subject, semester, date, gradeType, gradeValue));
        }
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public boolean isPaidEducation() {
        return isPaidEducation;
    }


}

