package bg.tu_varna.sit.а1.f22621643;

import java.util.List;
import java.util.Map;

public class Student {
    String name;
    int facultyNumber;
    int year;
    String program;
    String group;
    Status status;
    double averageGrade;
    List<String> enrolledCourses;
    Map<String, Double> grades;

    public Student() {
        this.name = name;
        this.facultyNumber = facultyNumber;
        this.year = year;
        this.program = program;
        this.group = group;
        this.status = status;
        this.averageGrade = averageGrade;
        this.enrolledCourses = enrolledCourses;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(int facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<String> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public Map<String, Double> getGrades() {
        return grades;
    }

    public void setGrades(Map<String, Double> grades) {
        this.grades = grades;
    }
}
