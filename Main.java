package bg.tu_varna.s22621643;

import bg.tu_varna.s22621643.Command.*;
import bg.tu_varna.s22621643.Core.StudentSystem;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem system = StudentSystem.getInstance();
        String filename = "student.dat";

        try {
            File f = new File(filename);
            if (f.exists() && f.length() > 0) {
                system.loadFromFile(filename);
                System.out.println("Данни заредени от " + filename);
            } else {
                if (!f.exists()) f.createNewFile();
                System.out.println("Файлът е нов или празен: " + filename);
            }
        } catch (Exception e) {
            System.out.println("Грешка при зареждане: " + e.getMessage());
        }

        CommandRegistry registry = new CommandRegistry();
        registry.register("enroll", new EnrollCommand());
        registry.register("advance", new AdvanceCommand());
        registry.register("change", new ChangeCommand());
        registry.register("graduate", new GraduateCommand());
        registry.register("interrupt", new InterruptCommand());
        registry.register("resume", new ResumeCommand());
        registry.register("print", new PrintCommand());
        registry.register("printall", new PrintAllCommand());
        registry.register("enrollin", new EnrollInCommand());
        registry.register("addgrade", new AddGradeCommand());
        registry.register("protocol", new ProtocolCommand());
        registry.register("report", new ReportCommand());
        registry.register("addcourse", new AddCourseCommand());
        registry.register("listcourses", new ListCoursesCommand());

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equals("exit")) {
                try {
                    system.saveToFile(filename);
                } catch (Exception e) {
                    System.out.println("Грешка при записване на файл: " + e.getMessage());
                }
                System.out.println("Записано. Изход.");
                break;
            }

            try {
                registry.execute(input);
            } catch (Exception e) {
                System.out.println("Грешка при изпълнение на командата: " + e.getMessage());
            }
        }
    }
}