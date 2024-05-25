package bg.tu_varna.sit.a1.f22621643;

import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private int facultyNumber;
    private int year;
    private String program;
    private String group;
    private Status status;
    private double averageGrade;
    private List<String> enrolledCourses;
    private Map<String, Double> grades;

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

    public double calculateAverage(Map<String, Double> grades, List<String> enrolledCourses) {
        double sum = 0.0;
        int count = 0;

        for (String enrolledCourse : enrolledCourses) {
            Double grade = grades.get(enrolledCourse);
            if (grade != null) {
                sum += grade;
                count++;
            }
        }

        return count > 0 ? sum / count : 0.0;
    }

    public double getAverageGrade() {
        return averageGrade = calculateAverage(grades, enrolledCourses);
    }
}
