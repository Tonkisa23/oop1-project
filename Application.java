package bg.tu_varna.sit.а1.f22621643;

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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 12:

                    break;
                case 13:
                    running = false;
                    break;
                default:
                    System.out.println("Невалидна команда");
                    break;
            }
        }
        scanner.close();
    }
}
