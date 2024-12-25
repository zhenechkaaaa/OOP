package ru.nsu.odnostorontseva.zachetka;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a student.
 */
public class Student implements Serializable {

    private String studentFullName;
    private List<Grade> grades;
    private boolean isPaidEducation;

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
     * @param subject    (subject name).
     * @param semester   (number of semester).
     * @param date       (string representing of date).
     * @param gradeType  (type of grade).
     * @param gradeValue (grade value).
     * @throws Exception (if the value is unreal or student has non-certification)
     */
    public void addGrade(String subject,
                         int semester,
                         String date,
                         String gradeType,
                         int gradeValue) throws Exception {

        if (gradeType.equals("зачёт")) {
            if (gradeValue < 0 || gradeValue > 1) {
                throw new IllegalArgumentException(
                        "Grade value for 'зачёт' must be 0 (false) or 1 (true).");
            }
        } else {
            if (gradeValue < 2 || gradeValue > 5) {
                throw new IllegalArgumentException("Grade value must be between 2 and 5");
            }
        }

        boolean hasNonCertification = grades.stream()
                .anyMatch(grade -> grade.getSemester() == (semester - 1)
                        && grade.getGradeValue() == 2);

        if (hasNonCertification) {
            throw new Exception(
                    "Can't add a new grade. Previous semester has non-certification");
        }

        boolean isExist = grades.stream()
                .anyMatch(grade -> grade.getSubject().equals(subject)
                        && grade.getSemester() == semester
                        && grade.getGradeType().equals(gradeType));

        if (isExist) {
            grades.stream()
                    .filter(grade -> grade.getSubject().equals(subject)
                            && grade.getSemester() == semester
                            && grade.getGradeType().equals(gradeType))
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
     * Returns information about student is studying on a paid basis or not.
     *
     * @return (true or false).
     */
    public boolean isPaidEducation() {
        return isPaidEducation;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.writeObject(studentFullName);
        out.writeBoolean(isPaidEducation);
        out.writeInt(grades.size());
        for (Grade grade : grades) {
            out.writeObject(grade.getSubject());
            out.writeInt(grade.getSemester());
            out.writeObject(grade.getDate());
            out.writeObject(grade.getGradeType());
            out.writeInt(grade.getGradeValue());
        }
    }

    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        studentFullName = (String) in.readObject();
        isPaidEducation = in.readBoolean();

        int size = in.readInt();
        grades = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String subject = (String) in.readObject();
            int semester = in.readInt();
            String date = (String) in.readObject();
            String gradeType = (String) in.readObject();
            int gradeValue = in.readInt();
            grades.add(new Grade(subject, semester, date, gradeType, gradeValue));
        }
    }

    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject) {
            return true;
        }
        if (anotherObject instanceof Student anotherStudent) {
            return studentFullName.equals(anotherStudent.studentFullName)
                    && isPaidEducation == anotherStudent.isPaidEducation
                    && grades.size() == anotherStudent.grades.size();
        }
        return false;
    }

}

