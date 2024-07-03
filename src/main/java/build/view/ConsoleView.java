package build.view;

import build.controller.Controller;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleView implements View {
    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void showResult(String message) {
        System.out.println(message);
    }

    public void showResult(String[] message) {
        for (String string : message) {
            System.out.println(string);
        }
    }

    @Override
    public void run(Scanner scanner) throws Exception {
        int menuValue;
        int operation = 0;
        int inputPublicationYear = 0;
        String inputTitle = "";
        String inputAuthor = "";
        String inputIsbn = "";

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Добавить книгу.");
            System.out.println("2. Удалить книгу.");
            System.out.println("3. Найти книгу.");
            System.out.println("4. Список всех книг.");
            System.out.println("5. Выход.");

            System.out.print("Введите пункт меню: ");

            try {
                menuValue = scanner.nextInt();
                scanner.nextLine(); // TODO: Разобраться со сканер
                System.out.println();
            }catch (Exception e){
                throw new IOException("Ошибка ввода пункта меню. Метод run строка 51.");
            }

            if (menuValue == 5) {
                System.out.println("Благодарим Вас за использование нашего приложения. До новых встреч.");
                break;
            }

            if (menuValue == 4) {
                operation = 4;
                menuValue = 0;
            }

            if (menuValue == 3) {
                System.out.println("Укажите тип поиска:");
                System.out.println("1. По названию.");
                System.out.println("2. По автору.");
                System.out.println("3. По году издания.");
                System.out.println("4. По коду ISBN.");
                System.out.print("Введите пункт меню: ");

                try {
                    menuValue = scanner.nextInt();
                    scanner.nextLine(); // TODO: Разобраться со сканер
                    System.out.println();
                }catch (Exception e){
                    throw new IOException("Ошибка ввода пункта меню. Метод run строка 77.");
                }

                if (menuValue == 1) {
                    operation = 31;
                } else if (menuValue == 2) {
                    operation = 32;
                } else if (menuValue == 3) {
                    operation = 33;
                } else if (menuValue == 4) {
                    operation = 34;
                }

                menuValue = 0;
            }

            if (menuValue == 2) {
                operation = 2;
            } else if (menuValue == 1) {
                operation = 1;
            }

            if (operation == 1 || operation == 2 || operation == 31) {
                System.out.print("Укажите название: ");

                try {
                    inputTitle = scanner.nextLine();
                }catch (Exception e){
                    throw new IOException("Ошибка ввода названия книги. Метод run строка 104.");
                }
            }

            if (operation == 1 || operation == 2 || operation == 32) {
                System.out.print("Укажите автора: ");

                try {
                    inputAuthor = scanner.nextLine();
                }catch (Exception e){
                    throw new IOException("Ошибка ввода названия автора. Метод run строка 113.");
                }
            }

            if (operation == 1 || operation == 2 || operation == 33) {
                System.out.print("Укажите год издания: ");

                try {
                    inputPublicationYear = scanner.nextInt();
                    scanner.nextLine(); // TODO: Разобраться со сканер
                }catch (Exception e){
                    throw new IOException("Ошибка ввода года издания. Метод run строка 123.");
                }
            }

            if (operation == 1 || operation == 2 || operation == 34) {
                System.out.print("Укажите код ISBN: ");

                try {
                    inputIsbn = scanner.nextLine();
                }catch (Exception e){
                    throw new IOException("Ошибка ввода кода ISBN. Метод run строка 136.");
                }
            }

            try {
                controller.doOperation(operation, inputTitle, inputAuthor, inputPublicationYear, inputIsbn);
            }catch (Exception e){
                throw new Exception("Ошибка выполнения запроса");
            }
        }
    }
}
