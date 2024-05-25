package bg.tu_varna.sit.a1.f22621643;

import java.io.*;
import java.util.*;

public class AcademicSystem {
    private List<Student> students;
    private List<Discipline> disciplines;
    private Map<String, List<String>> programCourses;

    private String currentFilename;
    private boolean fileLoaded;

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

    public void advance(int facultyNumber) {
        for (Student student : students) {
            if (student.getFacultyNumber() == facultyNumber) {
                if (student.getStatus().equals(Status.ZAVYRSHIL)) {
                    System.out.println("Студентът " + student.getName() + " с факултетен номер " + facultyNumber + " е вече завършил.");
                } else {
                    List<String> coursesToPass = getCoursesToPass(student);
                    if (coursesToPass.isEmpty()) {
                        student.setYear(student.getYear() + 1);
                        System.out.println("Студентът " + student.getName() + " с факултетен номер " + facultyNumber + " преминава в следващата година.");
                    } else {
                        System.out.println("Студентът " + student.getName() + " с факултетен номер " + facultyNumber + " не може да премине в следваща година все още. Оставащи дисциплини: " + coursesToPass);
                    }
                }
                return;
            }
        }
        System.out.println("Стъдент с факултетен номер " + facultyNumber + " не е намерен.");
    }

    private List<String> getCoursesToPass(Student student) {
        List<String> coursesToPass = new ArrayList<>();
        for (String course : student.getEnrolledCourses()) {
            if (!student.getGrades().containsKey(course)) {
                coursesToPass.add(course);
            }
        }
        return coursesToPass;
    }

    public void change(int facultyNumber, String option, String value) {
        for (Student student : students) {
            if (student.getFacultyNumber() == facultyNumber) {
                switch (option) {
                    case "program":
                        student.setProgram(value);
                        break;
                    case "group":
                        student.setGroup(value);
                        break;
                    case "year":
                        try {
                            int newYear = Integer.parseInt(value);
                            student.setYear(newYear);
                        } catch (NumberFormatException e) {
                            System.out.println("Невалидна година.");
                        }
                        break;
                    default:
                        System.out.println("Невалидна опция.");
                        break;
                }
                break;
            }
        }
    }

    public void graduate(int facultyNumber) {
        for (Student student : students) {
            if (student.getFacultyNumber() == facultyNumber) {
                if (student.getGrades().size() == student.getEnrolledCourses().size()) {
                    boolean allPassed = true;
                    for (Double grade : student.getGrades().values()) {
                        if (grade < 3.00) {
                            allPassed = false;
                            break;
                        }
                    }
                    if (allPassed) {
                        student.setStatus(Status.ZAVYRSHIL);
                        System.out.println("Студентът " + student.getName() + " с факултетен номер " + facultyNumber + " завърши!");
                    } else {
                        System.out.println("Студентът " + student.getName() + " с факултетен номер " + facultyNumber + " не може да завърши поради незадоволителни оценки!");
                    }
                } else {
                    System.out.println("Студентът " + student.getName() + " с факултетен номер " + facultyNumber + " не е завършил всичките дисциплини, нужни за завършване.");
                }
                return;
            }
        }
        System.out.println("Стъдент с факултетен номер " + facultyNumber + " не е намерен.");
    }

    public void interrupt(int facultyNumber) {
        for (Student student : students) {
            if (student.getFacultyNumber() == facultyNumber) {
                student.setStatus(Status.PREKYSNAL);
                break;
            }
        }
    }

    public void resume(int facultyNumber) {
        for (Student student : students) {
            if (student.getFacultyNumber() == facultyNumber) {
                student.setStatus(Status.ZAPISAN);
                break;
            }
        }
    }

    public void printReport(int facultyNumber) {
        for (Student student : students) {
            if (student.getFacultyNumber() == facultyNumber) {
                System.out.println("Справка за студент с факултетен номер " + facultyNumber + ":");
                System.out.println("Име: " + student.getName());
                System.out.println("Специалност: " + student.getProgram());
                System.out.println("Група: " + student.getGroup());
                System.out.println("Статус: " + student.getStatus());
                System.out.println("Среден успех: " + student.getAverageGrade());
                System.out.println("Записани дисциплини:");
                for (String course : student.getEnrolledCourses()) {
                    System.out.println("- " + course);
                }
                System.out.println("Оценки:");
                for (Map.Entry<String, Double> entry : student.getGrades().entrySet()) {
                    System.out.println("- Дисциплина: " + entry.getKey() + ", Оценка: " + entry.getValue());
                }
                return;
            }
        }
        System.out.println("Студент с факултетен номер " + facultyNumber + " не е намерен.");
    }

    public void printAllReport(String program, String year) {
        System.out.println("Справка за всички студенти в специалност " + program + " и година " + year + ":");
        for (Student student : students) {
            if (student.getProgram().equals(program)) {
                System.out.println("Факултетен номер: " + student.getFacultyNumber());
                System.out.println("Име: " + student.getName());
                System.out.println("Група: " + student.getGroup());
                System.out.println("Статус: " + student.getStatus());
                System.out.println("Среден успех: " + student.getAverageGrade());
                System.out.println();
            }
        }
    }

    public void enrollIn(int facultyNumber, String course) {
        for (Student student : students) {
            if (student.getFacultyNumber() == facultyNumber) {
                if (programCourses.get(student.getProgram()).contains(disciplines)) {
                    student.getEnrolledCourses().add(String.valueOf(disciplines));
                    System.out.println("Студентът " + student.getName() + " с факултетен номер " + facultyNumber + " е записан в дисциплината " + disciplines + ".");
                } else {
                    System.out.println("Дисциплината " + disciplines + " не е достъпна за програмата " + student.getProgram() + ".");
                }
                return;
            }
        }
        System.out.println("Студент с факълтетен номер " + facultyNumber + " не е намерен.");
    }

    public void addGrade(int facultyNumber, String course, double grade) {
        for (Student student : students) {
            if (student.getFacultyNumber() == facultyNumber) {
                student.getGrades().put(course, grade);
                break;
            }
        }
    }

    public void printProtocol(String course) {
        System.out.println("Протокол за дисциплина: " + course);
        for (Student student : students) {
            if (student.getEnrolledCourses().contains(course)) {
                System.out.println("Студент: " + student.getName() + ", Оценка: " + student.getGrades().get(course));
            }
        }
    }

    public void printReportCard(int facultyNumber) {
        for (Student student : students) {
            if (student.getFacultyNumber() == facultyNumber) {
                System.out.println("Справка за студент: " + student.getName());
                for (Map.Entry<String, Double> entry : student.getGrades().entrySet()) {
                    System.out.println("Дисциплина: " + entry.getKey() + ", Оценка: " + entry.getValue());
                }

                double sum = 0;
                for (double grade : student.getGrades().values()) {
                    sum += grade;
                }
                double average = sum / student.getGrades().size();
                System.out.println("Среден успех: " + average);
                break;
            }
        }
    }

    public void openFile(String filename) throws IOException, ClassNotFoundException {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
                students.clear();
                fileLoaded = true;
                currentFilename = filename;
                System.out.println("Създаден е нов празен файл: " + filename);
            } else {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                    students = (List<Student>) ois.readObject();
                    fileLoaded = true;
                    currentFilename = filename;
                    System.out.println("Файлът е отворен успешно.");
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Грешка при отваряне на файла: " + e.getMessage());
        }
    }

    public void closeFile() {
        if (!fileLoaded) {
            System.out.println("Няма отворен файл.");
            return;
        }
        students.clear();
        currentFilename = null;
        fileLoaded = false;
        System.out.println("Файлът е затворен.");
    }

    public void saveFile() throws IOException {
        if (!fileLoaded) {
            System.out.println("Няма отворен файл за запис.");
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(currentFilename))) {
            oos.writeObject(students);
            System.out.println("Файлът е запазен успешно.");
        } catch (IOException e) {
            System.out.println("Грешка при запис на файла: " + e.getMessage());
        }
    }

    public void saveFileAs(String directory) throws IOException {
        if (!fileLoaded) {
            System.out.println("Няма отворен файл за запис.");
            return;
        }

        if (directory == null || directory.isEmpty()) {
            System.out.println("Невалидна директория.");
            return;
        }

        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        System.out.println("Въведете ново име на файла:");
        Scanner scanner = new Scanner(System.in);
        String newFilename = scanner.nextLine();
        File file = new File(dir, newFilename);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(students);
            currentFilename = file.getAbsolutePath();
            System.out.println("Файлът е запазен успешно като " + currentFilename);
        } catch (IOException e) {
            System.out.println("Грешка при запис на файла: " + e.getMessage());
        }
    }

    public void printHelp() {
        System.out.println("13. Изход - излиза от програмата");
        System.out.println("14. Отвори файл - отваря файл");
        System.out.println("15. Затвори файл - затваря отворения вече файл");
        System.out.println("16. Запази файл - запазва направените птомени в същия файл");
        System.out.println("17. Запази файл като (директория) - запазва направените промени в нов файл, със съответна директория");
    }
}

