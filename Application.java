package bg.tu_varna.sit.a1.f22621643;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        AcademicSystem academicSystem = new AcademicSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Записване в 1 курс");
            System.out.println("2. Записване в следващ курс");
            System.out.println("3. Прехвърляне в друга специалност");
            System.out.println("4. Завършване на студент");
            System.out.println("5. Прекъсеане на студент");
            System.out.println("6. Възстановяване на студентски права");
            System.out.println("7. Справка за студент");
            System.out.println("8. Справка за всички студенти в специалност и курс");
            System.out.println("9. Записване на студент в дисциплина");
            System.out.println("10. Добаввяне на оценка");
            System.out.println("11. Протокол за студенти, записани в дисциплина");
            System.out.println("12. Академична справка за студент");
            System.out.println("13. Изход");
            System.out.println("Команда(число): ");
            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    System.out.println("Въведете факултетен номер, програма, група и име на студента:");
                    int facultyNumber = scanner.nextInt();
                    String program = scanner.next();
                    String group = scanner.next();
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    academicSystem.enroll(name,facultyNumber, program, group);
                    break;
                case 2:
                    System.out.println("Въведете факултетен номер на студента:");
                    int facultyNumberAdvance = scanner.nextInt();
                    academicSystem.advance(facultyNumberAdvance);
                    break;
                case 3:
                    System.out.println("Въведете факултетен номер на студента, опция(program, group, year) и стойност:");
                    int facultyNumberChange = scanner.nextInt();
                    String option = scanner.next();
                    String value = scanner.next();
                    academicSystem.change(facultyNumberChange, option, value);
                    break;
                case 4:
                    System.out.println("Въведете факултетен номер на завършващия студент:");
                    int facultyNumberGraduate = scanner.nextInt();
                    academicSystem.graduate(facultyNumberGraduate);
                    break;
                case 5:
                    System.out.println("Въведете факултетен номер на прекъсващия студент:");
                    int facultyNumberInterrupt = scanner.nextInt();
                    academicSystem.interrupt(facultyNumberInterrupt);
                    break;
                case 6:
                    System.out.println("Въведете факултетен номер на възстановявания студент:");
                    int facultyNumberResume = scanner.nextInt();
                    academicSystem.resume(facultyNumberResume);
                    break;
                case 7:
                    System.out.println("Въведете факултетен номер на студента за справка:");
                    int facultyNumberReport = scanner.nextInt();
                    academicSystem.printReport(facultyNumberReport);
                    break;
                case 8:
                    System.out.println("Въведете програма и курс за справка:");
                    String programReport = scanner.next();
                    String yearReport = scanner.next();
                    academicSystem.printAllReport(programReport, yearReport);
                    break;
                case 9:
                    System.out.println("Въведете факултетен номер на студента и име на дисциплината:");
                    int facultyNumberEnrollIn = scanner.nextInt();
                    String courseEnrollIn = scanner.next();
                    academicSystem.enrollIn(facultyNumberEnrollIn, courseEnrollIn);
                    break;
                case 10:
                    System.out.println("Въведете факултетен номер на студента, име на дисциплината и оценка:");
                    int facultyNumberAddGrade = scanner.nextInt();
                    String courseAddGrade = scanner.next();
                    double gradeAddGrade = scanner.nextDouble();
                    academicSystem.addGrade(facultyNumberAddGrade, courseAddGrade, gradeAddGrade);
                    break;
                case 11:
                    System.out.println("Въведете име на дисциплината за протокол:");
                    String courseProtocol = scanner.next();
                    academicSystem.printProtocol(courseProtocol);
                    break;
                case 12:
                    System.out.println("Въведете факултетен номер на студента за академична справка:");
                    int facultyNumberReportCard = scanner.nextInt();
                    academicSystem.printReportCard(facultyNumberReportCard);
                    break;
                case 13:
                    running = false;
                    break;
                case 14:
                    try {
                        System.out.println("Въведете име на файла за отваряне:");
                        String openFilename = scanner.next();
                        academicSystem.openFile(openFilename);
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Грешка при работа с файла: " + e.getMessage());
                    }
                    break;
                case 15:
                    academicSystem.closeFile();
                    break;
                case 16:
                    try {
                        academicSystem.saveFile();
                    } catch (IOException e) {
                        System.out.println("Грешка при запис на файла: " + e.getMessage());
                    }
                    break;
                case 17:
                    try {
                        System.out.println("Въведете директория за запазване:");
                        String saveAsDirectory = scanner.next();
                        academicSystem.saveFileAs(saveAsDirectory);
                    } catch (IOException e) {
                        System.out.println("Грешка при запис на файла: " + e.getMessage());
                    }
                    break;
                case 18:
                    academicSystem.printHelp();
                    break;
                default:
                    System.out.println("Невалидна команда");
                    break;
            }
        }
        scanner.close();
    }
}
