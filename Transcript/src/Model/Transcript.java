package Model;

import java.util.ArrayList;
import java.util.List;

public class Transcript {
    String studentName;
    int studentID;
    List<String> courses;
    List<Double> grades;
    public Transcript(String name, int id) {
        studentName = name;
        studentID = id;
        courses = new ArrayList<String>();
        grades = new ArrayList<Double>();
    }

    public String getStudentName() {return studentName; }
    public int getStudentID() {return studentID; }
    public double getGrade(String course) {
        if (!courses.contains(course)) {
            System.out.println("Student not in course " + course);
        }
        return grades.get(courses.indexOf(course));
    }

    public double getStudentGDA(String course) {
        int index = courses.indexOf(course);
        if (index == -1) {
            System.out.println("Student is not in course " + course);
            return 0.0;
        }
        return grades.get(index);
    }

    public void setStudentName(String name) {
        studentName = name;
    }
    public void setStudentID (int id) {
        studentID = id;
    }
    //REQUIRES: a string with the course code and a non-negative float grade
    //MODIFIES: this
    //EFFECTS: if courseCode is not added, it adds courseCode to student courses and associates the grade to the course code
    public void addGrade(String courseCode, Double grade) {
        int index;
        if (courses.indexOf(courseCode) == -1) {
            addCourse(courseCode);
        }
        index = courses.indexOf(courseCode);
        grades.set(index, grade);
    }

    //REQUIRES: a string with the course codea string with the course code
    //MODIFIES: this
    //EFFECTS: add course if not already added
    public void addCourse (String course) {
        if (!courses.contains(course)) {
            courses.add(course);
            grades.add(0.0);
        }
    }

    //EFFECTS: return course name and grade in string format: "COURSE XX-GRADE"
    public String getCourseAndGrade(String course){
        int index = courses.indexOf(course);
        if (index == -1) {
            System.out.println("Student is not in course " + course);
            return "";
        }
        return course.toUpperCase() + "-" + grades.get(courses.indexOf(course));

    }


    //EFFECTS: pretty print the transcript
    public void printTranscript(){
        StringBuilder str = new StringBuilder(studentName + ", " + studentID + ": ");
        for (String course : courses){
            str.append(getCourseAndGrade(course));
            str.append(", ");
        }
        str = new StringBuilder(str.substring(0, str.length() - 2));
        System.out.println(str);
    }


    //EFFECTS: returns GPA
    public double getStudentGPA(){
        double sum = 0.0;
        double i = 0.0;
        for (double grade : grades) {
            sum = sum + grade;
            i++;
        }
        return sum / i;
    }

}
