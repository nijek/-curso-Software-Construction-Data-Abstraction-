package test;

import Model.Transcript;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;

import java.util.Locale;

public class TranscriptTest {

    private Transcript testTranscript;

    @BeforeEach
    public void setUp() {
        testTranscript = new Transcript("Student Name", 1000);
        //TODO: write new values in testTranscript constructor
    }

    @Test
    public void testTemplate() {
        assertEquals(testTranscript.getStudentName(), "Student Name");
        assertEquals(testTranscript.getStudentID(), 1000);
    }

    @Test
    public void testSetStudentName() {
        testTranscript.setStudentName("Mafe");
        assertEquals(testTranscript.getStudentName(), "Mafe");
    }

    @Test
    public void testSetStudentID() {
        for (int i = 0; i < 9999; i++) {
            testTranscript.setStudentID(i);
            assertEquals(testTranscript.getStudentID(), i);
        }
    }

    @Test
    public void testGetStudentGPA() {
        double gpa = 0.0;
        for (int i = 1; i < 100; i++) {
            gpa = (gpa * (i - 1) + i )/ (double)i;
            testTranscript.addCourse("teste" + i);
            testTranscript.addGrade("teste" + i, (double) i);
            double a = testTranscript.getStudentGPA();
            assertEquals(a, gpa, 0.005);
        }

    }

    @Test
    public void testAddGradeUnaddedCourse() {
        for (int i = 0; i < 1000; i++) {
            testTranscript.addGrade("Curso" + i, (double) i % 4);
            assertEquals(testTranscript.getCourseAndGrade("Curso" + i), (("Curso" + i).toUpperCase() + '-' + (double) i % 4));
        }
    }
    @Test
    public void testAddGradeAlreadyAddedCourse() {
        for (int i = 0; i < 1000; i++) {
            testTranscript.addCourse("Curso" + i);
            testTranscript.addGrade("Curso" + i, (double) i % 4);
            assertEquals(testTranscript.getCourseAndGrade("Curso" + i), (("Curso" + i).toUpperCase() + '-' + (double) i % 4));
        }
    }
    @Test
    public void changeCourseGrade() {
        for (int i = 0; i < 100; i++) {
            String curso = "curso" + i;
            testTranscript.addCourse(curso);
            assertEquals(testTranscript.getGrade(curso), 0.0, 0.005);
            testTranscript.addGrade(curso, (double)i/40);
            assertEquals(testTranscript.getGrade(curso), (double)i/40, 0.005);
        }
    }
}

