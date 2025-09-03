package bg.tu_varna.s22621643.Command;

import bg.tu_varna.s22621643.Core.StudentSystem;

public class ListCoursesCommand implements Command {
    public void execute(String[] args) { StudentSystem.getInstance().listCourses(args[1]); }
}
