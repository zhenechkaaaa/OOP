package ru.nsu.odnostorontseva.zachetka;

/**
 * Class representing a grade.
 */
public class Grade {
    private final String subject;
    private final int semester;
    private String date;
    private final String gradeType; // "экзамен" or "зачет"
    private int gradeValue; // 5, 4, 3, or 2

    /**
     * Constructor.
     *
     * @param subject    (subject).
     * @param semester   (number of semester).
     * @param date       (date string representation).
     * @param gradeType  (grade type string representation).
     * @param gradeValue (number of grade value).
     */
    public Grade(String subject,
                 int semester,
                 String date,
                 String gradeType,
                 int gradeValue) {
        this.subject = subject;
        this.semester = semester;
        this.date = date;
        this.gradeType = gradeType;
        this.gradeValue = gradeValue;
    }

    /**
     * Getter for subject.
     *
     * @return (subject name).
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Getter for semester.
     *
     * @return (number of semester).
     */
    public int getSemester() {
        return semester;
    }


    /**
     * Setter for date.
     *
     * @param date (date string representation).
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Getter for grade value.
     *
     * @return (grade value).
     */
    public int getGradeValue() {
        return gradeValue;
    }

    /**
     * Setter for grade value.
     *
     * @param gradeValue (number of grade value).
     */
    public void setGradeValue(int gradeValue) {
        this.gradeValue = gradeValue;
    }

    /**
     * Getter fo grade type.
     *
     * @return (grade type string representation)
     */
    public String getGradeType() {
        return gradeType;
    }
}
