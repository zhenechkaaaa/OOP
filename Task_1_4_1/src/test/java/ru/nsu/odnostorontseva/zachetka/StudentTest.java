package ru.nsu.odnostorontseva.zachetka;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StudentTest {
    private Student student;

    @Test
    void addGrade() throws Exception {
        student = new Student("Vasya", true);
        student.addGrade("Math",
                1,
                "13.01.1995",
                "экзамен",
                3
        );
        student.addGrade("PE",
                2,
                "25.06.1995",
                "зачёт",
                1);
        assertEquals(2, student.getGrades().size());
    }

    @Test
    void addRetakeGrade() throws Exception {
        student = new Student("Vasya", true);
        student.addGrade("Math",
                1,
                "13.01.1995",
                "экзамен",
                2
        );
        student.addGrade("Math",
                1,
                "13.02.1995",
                "экзамен",
                5
        );
        assertEquals(1, student.getGrades().size());
    }

    @Test
    void addGradeExpressionsTest() throws Exception {
        student = new Student("Vasya", true);
        assertThrows(IllegalArgumentException.class,
                () -> student.addGrade("subject",
                        1,
                        "10.01.2005",
                        "зачёт",
                        8));
    }

    @Test
    void addGradeExpressionsTest2() throws Exception {
        student = new Student("Vasya", true);
        assertThrows(IllegalArgumentException.class,
                () -> student.addGrade("subject",
                        1,
                        "10.01.2005",
                        "дифф зачёт",
                        8));
    }

    @Test
    void addGradeExpressionsTest3() throws Exception {
        student = new Student("Vasya", true);
        student.addGrade("subject",
                1,
                "10.01.2005",
                "экзамен",
                2);
        assertThrows(Exception.class,
                () -> student.addGrade("subject2",
                        2,
                        "10.06.2005",
                        "экзамен",
                        3));
    }

    @Test
    void getStudentFullName() {
        student = new Student("Vasya", true);
        assertEquals("Vasya", student.getStudentFullName());
    }


    @Test
    void isPaidEducation() {
        student = new Student("Vasya", true);
        assertTrue(student.isPaidEducation());
    }
}