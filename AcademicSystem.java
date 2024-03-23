package bg.tu_varna.sit.а1.f22621643;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcademicSystem {
    List<Student> students;
    List<Discipline> disciplines;
    Map<String, List<String>> programCourses;

    public AcademicSystem() {
        students = new ArrayList<>();
        disciplines = new ArrayList<>();
        programCourses = new HashMap<>();
    }

    public void enroll(String name, int facultyNumber, String program, String group) {
        Student student = new Student();
        student.setFacultyNumber(facultyNumber);
        student.setProgram(program);
        student.setGroup(group);
        student.setName(name);
        student.setStatus(Status.ZAPISAN);
        students.add(student);
    }

    
}

