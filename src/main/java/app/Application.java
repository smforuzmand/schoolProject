package app;

import java.util.Scanner;

public class Application {
    static void displayMenu() {
        System.out.println(
                "**********************Welcome to School management program choose a number from menu********************" + "\n" +
                        "select 1 to create a new student!" + "\n" +
                        "select 2 to create a new course!" + "\n" +
                        "select 3 to register a student in the course!" + "\n" +
                        "select 4 to remove a student from the course!" + "\n" +
                        "select 5 to find a student by ID!" + "\n" +
                        "select 6 to find a course by ID!" + "\n" +
                        "select 7 to retrieve a course by name!" + "\n" +
                        "select 8 to edit a student profile !" + "\n" +
                        "select 9 to to edit a course profile !" + "\n" +
                        "select 0 to exit the menu ! :" + "\n");
    }

    public static String getStringFromUser() {
        Scanner scanner = new Scanner(System.in);
        boolean invalid = true;
        String string = null;
        while (invalid) {
            try {
                string = scanner.nextLine();
                invalid = false;
            } catch (RuntimeException ex) {
                System.out.println("Not a valid string, Try again! ");
            }

        }


        return string;
    }

    public static String countinueProgram() {
        System.out.println("Do you want to continue ? (Y/N)");
        String choice = getStringFromUser();
            if (choice.equalsIgnoreCase("y")) {
                displayMenu();
            }
                return null;
            }


    public static int getNumberFromUser() {

        Scanner sc = new Scanner(System.in);
        boolean invalid = true;
        int Id = 0;
        while (invalid) {
            try {
                Id = Integer.parseInt(sc.nextLine());
                invalid = false;
            } catch (NumberFormatException ex) {
                System.out.println("Not a valid number, Try again! ");
            }

        }

        return Id;
    }
}
