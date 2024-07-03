package build.view;

import build.controller.Controller;

import java.util.Scanner;

public interface View {
    void setController(Controller controller);
    void showResult(String message);
    void showResult(String[] message);
    void run(Scanner scanner) throws Exception;
}
