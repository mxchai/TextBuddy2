/**
 *
 * This program is used to manipulate text files. The user runs the java program with a command line argument
 * that is the name of the file the user wishes to manipulate. The program allows for 5 operations:
 *      1. Add: a line is appended at the end to the text file, followed by a new line.
 *      2. Delete: the line specified by the user is deleted
 *      3. Clear: all content in the text file is deleted
 *      4. Display: the file contents are displayed to the user, and each line marked with its line number
 *      5. Sort: the file contents are sorted in alphabetical order, and saved immediately to the file.
 *      6: Search: if the word supplied can be found in the text, the lines and their respective line number
 *      will be displayed to the user. If not found, the user will be alerted.
 *      7. Exit: the program exits
 *
 *
 * The file is saved to disk after every user operation that modifies the text e.g. add, delete and clear.
 * This is the most intuitive way, since it takes considerable effort on the user's part to issue a command,
 * it is likely that the user wants the command to registered. The only downside here is that the user
 * might have accidentally deleted a line, due to accidental number input.
 *
 * These are some of the assumptions made:
 * 1. The command line argument supplied to the program is of .txt format.
 * 2. The add command followed by a space is treated as invalid argument.
 * 3. The delete command followed by a space, or a number that is more than the total number of lines, or
 * a string are treated as an invalid arguments.
 *
 *
 * @author: Chai Ming Xuan
 */

import java.util.Scanner;

public class TextBuddy {

    private static final String MESSAGE_COMMAND_PROMPT = "Command: ";
    private static final int PARAM_POSITION_FILENAME = 0;

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Declarations
        String fileName = args[PARAM_POSITION_FILENAME];
        Controller controller = new Controller(fileName);

        // Initialisation
        System.out.println(controller.welcomeMessage());

        // Program loop
        while (true) {
            System.out.print(MESSAGE_COMMAND_PROMPT);
            String input = getInput(sc);
            String result = controller.execute(input);
            if (result != null) {
                display(result);
            } else {
                display(controller.exitMessage());
                System.exit(1);
            }
        }
    }

    public static String getInput(Scanner sc) {
        String input = sc.nextLine();
        return input;
    }

    public static void display(String result) {
        System.out.print(result);
    }


}
