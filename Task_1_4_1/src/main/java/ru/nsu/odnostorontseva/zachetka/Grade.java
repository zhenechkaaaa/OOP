package ru.nsu.odnostorontseva.zachetka;

public class Grade {
    private String subject;
    private int semester;
    private String date;
    private String gradeType; // "экзамен" or "зачет"
    private int gradeValue; // 5, 4, 3, or 2

    public Grade(String subject, int semester, String date, String gradeType, int gradeValue) {
        this.subject = subject;
        this.semester = semester;
        this.date = date;
        this.gradeType = gradeType;
        this.gradeValue = gradeValue;
    }

    public String getSubject() {
        return subject;
    }

    public int getSemester() {
        return semester;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(int gradeValue) {
        this.gradeValue = gradeValue;
    }

    public String getGradeType() {
        return gradeType;
    }
}
