package ru.nsu.odnostorontseva.zachetka;

import java.util.ArrayList;
import java.util.List;

/**
 *  Class representing a student.
 */
public class Student {

    private final String studentFullName;
    private final List<Grade> grades;
    private final boolean isPaidEducation;

    /**
     * Constructor.
     *
     * @param studentFullName (student's full name).
     * @param isPaidEducation (true or false - paid or not).
     */
    public Student(String studentFullName, boolean isPaidEducation) {
        this.studentFullName = studentFullName;
        this.isPaidEducation = isPaidEducation;
        this.grades = new ArrayList<>();
    }

    /**
     * Method to add a grade.
     *
     * @param subject (subject name).
     * @param semester (number of semester).
     * @param date (string representing of date).
     * @param gradeType (type of grade).
     * @param gradeValue (grade value).
     * @throws Exception (if the value is unreal or student has non-certification)
     */
    public void addGrade(String subject,
                         int semester,
                         String date,
                         String gradeType,
                         int gradeValue)  throws Exception{

        if (gradeType.equals("зачёт")) {
            if (gradeValue < 0 || gradeValue > 1) {
                throw new IllegalArgumentException("Grade value for 'зачёт' must be 0 (false) or 1 (true).");
            }
        } else {
            if(gradeValue < 2 || gradeValue > 5) {
                throw new IllegalArgumentException("Grade value must be between 2 and 5");
            }
        }

        boolean hasNonCertification = grades.stream()
                        .anyMatch(grade -> grade.getSemester() == (semester - 1)
                        && grade.getGradeValue() == 2);

        if(hasNonCertification) {
            throw new Exception("Can't add a new grade. Previous semester has non-certification");
        }

        boolean isExist = grades.stream()
                        .anyMatch(grade -> grade.getSubject().equals(subject)
                        && grade.getSemester() == semester && grade.getGradeType().equals(gradeType));

        if(isExist) {
            grades.stream()
                    .filter(grade -> grade.getSubject().equals(subject)
                            && grade.getSemester() == semester && grade.getGradeType().equals(gradeType))
                    .forEach(grade -> {
                        grade.setDate(date);
                        grade.setGradeValue(gradeValue);
                    });
        } else {
            grades.add(new Grade(subject, semester, date, gradeType, gradeValue));
        }
    }

    /**
     * Getter for student's name.
     *
     * @return (full name of student).
     */
    public String getStudentFullName() {
        return studentFullName;
    }

    /**
     * Getter for all student's grade.
     *
     * @return (list of grades).
     */
    public List<Grade> getGrades() {
        return grades;
    }

    /**
     * Returns information about student is studying on a paid basis or not
     *
     * @return (true or false).
     */
    public boolean isPaidEducation() {
        return isPaidEducation;
    }
}

