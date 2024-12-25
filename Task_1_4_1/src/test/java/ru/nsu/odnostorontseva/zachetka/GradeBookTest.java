package ru.nsu.odnostorontseva.zachetka;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
    private GradeBook gradeBook;

    @BeforeEach
    void setUp() throws Exception {
        Student student = new Student("Zhenechka", false);
        gradeBook = new GradeBook(student);
        student.addGrade(
                "ОРГ",
                1,
                "23.12.2023",
                "дифф зачёт",
                5);
        student.addGrade(
                "Цифровые платформы",
                1,
                "25.12.2023",
                "зачёт",
                1);
        student.addGrade(
                "Введение в алгебру и анализ",
                1,
                "11.01.2024",
                "экзамен",
                4);
        student.addGrade(
                "Введение в дискретную математику и мат. лог.",
                1,
                "16.01.2024",
                "экзамен",
                4);
        student.addGrade(
                "Императивное программирование",
                1,
                "27.12.2023",
                "дифф зачёт",
                4);
        student.addGrade(
                "Иностранный язык",
                1,
                "25.12.2023",
                "зачёт",
                1);
        student.addGrade(
                "История России",
                1,
                "22.01.2024",
                "экзамен",
                5);
        student.addGrade(
                "Физкультура",
                1,
                "25.12.2023",
                "зачёт",
                1);
        student.addGrade(
                "Декларативное программирование",
                1,
                "27.12.2023",
                "дифф зачёт",
                4);
        student.addGrade(
                "Введение в дискретную математику и мат. лог.",
                2,
                "13.06.2024",
                "экзамен",
                5);
        student.addGrade(
                "Императивное программирование",
                2,
                "18.06.2024",
                "экзамен",
                4);
        student.addGrade(
                "Введение в алгебру и анализ",
                2,
                "25.06.2024",
                "экзамен",
                5);
        student.addGrade(
                "Физкультура",
                2,
                "30.05.2024",
                "зачёт",
                1);
        student.addGrade(
                "Иностранный язык",
                2,
                "01.06.2024",
                "дифф зачёт",
                5);
        student.addGrade(
                "История России",
                2,
                "05.06.2024",
                "зачёт",
                1);
        student.addGrade(
                "Декларативное программирование",
                2,
                "07.06.2024",
                "дифф зачёт",
                4);
        student.addGrade(
                "Цифровые платформы",
                2,
                "07.06.2024",
                "дифф зачёт",
                5);
    }

    @Test
    void calcAverageGradeTest() {
        double res = gradeBook.calcAverageGrade();
        double expected = 4.5;
        assertEquals(expected, res);
    }

    @Test
    void canSwitchToBudgetExceptionTest() {
        assertThrows(Exception.class, () -> gradeBook.canSwitchToBudget());
    }

    @Test
    void canSwitchToBudgetTest() throws Exception {
        Student newStudent = new Student("Vasya", true);
        newStudent.addGrade("Math",
                1,
                "10.02.2002",
                "экзамен",
                5);
        newStudent.addGrade("Physics",
                1,
                "05.02.2002",
                "зачёт",
                1
        );
        newStudent.addGrade("Baldupinanie",
                1,
                "29.02.2002",
                "экзамен",
                5
        );
        newStudent.addGrade("Hihihaha",
                1,
                "29.02.2002",
                "экзамен",
                5
        );
        newStudent.addGrade("Domashniy son",
                1,
                "29.02.2002",
                "зачёт",
                1
        );
        newStudent.addGrade("Pokushat",
                1,
                "29.02.2002",
                "зачёт",
                1
        );
        newStudent.addGrade("Igra v fermu",
                1,
                "29.02.2002",
                "зачёт",
                1
        );
        newStudent.addGrade("Potikatsa v komputer",
                1,
                "29.02.2002",
                "зачёт",
                1
        );
        newStudent.addGrade("Psmotret filmi",
                1,
                "29.02.2002",
                "зачёт",
                1
        );
        GradeBook newGradeBook = new GradeBook(newStudent);
        assertTrue(newGradeBook.canSwitchToBudget());
    }

    @Test
    void canGetRedDiplomaTest() {
        assertFalse(gradeBook.canGetRedDiploma());
    }

    @Test
    void canGetIncreasedScholarshipTest() throws Exception {
        assertFalse(gradeBook.canGetIncreasedScholarship(2));
    }

    @Test
    void canGetIncreasedScholarshipExceptionTest() {
        Student newStudent = new Student("Vasya", true);
        GradeBook newGradeBook = new GradeBook(newStudent);
        assertThrows(Exception.class, () -> newGradeBook.canGetIncreasedScholarship(2));
    }

}

