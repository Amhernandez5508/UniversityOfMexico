package view;

import java.util.Scanner;

/**
 * Represents the User Interface of the application.
 */
public class UserInterface {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Displays a general message to the user.
     *
     * @param message The message to be displayed.
     */
    public static void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays an error message to the user.
     *
     * @param message The error message to be displayed.
     */
    public static void showMessageError(String message) {
        System.err.println(message);
    }

    /**
     * Shows the options to the user and prompts for input.
     *
     * @return The integer representing the user's selection.
     */
    public static Integer showOptions() {
        Integer selection;

        System.out.println("Ingrese la opción deseada:" +
                "\n1)_ Obtener datos." +
                "\n2)_ Salir.");

        while (!scanner.hasNextInt()) {
            System.out.print("Opción invalida, por favor intente nuevamente: ");
            scanner.next();
        }

        selection = scanner.nextInt();
        if (selection > 0 && selection < 3) {
            return selection;
        } else {
            System.out.println("Opción invalida, por favor intente nuevamente.\n");
            showOptions();
        }

        return null;
    }
}
