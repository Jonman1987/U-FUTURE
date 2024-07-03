package build;

import build.controller.LibraryController;
import build.model.LibraryModel;
import build.model.Model;
import build.view.ConsoleView;
import build.view.View;

import java.util.Scanner;

public class LibraryAppMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Model model = new LibraryModel();
        View view = new ConsoleView();

        new LibraryController(view, model);

        try{
            view.run(scanner);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Ошибка выполнения программы");
        }
    }
}