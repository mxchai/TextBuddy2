/**
 * Created by mx on 24/2/15.
 */

import java.util.Scanner;

public class TextBuddy {

    private static final String MESSAGE_COMMAND_PROMPT = "Command: ";
    private static final String MESSAGE_READY = "Welcome to TextBuddy. %s  is ready for use."; // this should be in controller actually

    private static final int PARAM_POSITION_FILENAME = 0;

    private static final String TERMINATE = "terminate";
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Declarations
        String fileName = args[PARAM_POSITION_FILENAME];
        Controller controller = new Controller(fileName);
        //Storage storage = new Storage(fileName);

        // Initialisation
        printWelcomeMessage(fileName);

        // Program loop
        while(true){
            System.out.print(MESSAGE_COMMAND_PROMPT);
            String input = getInput(sc);
            String result = controller.execute(input);
            display(result);
        }
    }

    public static String getInput(Scanner sc) {
        String input = sc.nextLine();
        return input;
    }

    public static Boolean notTerminated(String executionResult) {
        return executionResult.equals(TERMINATE);
    }

    public static void display(String result) {
        System.out.println(result);
    }

    public static void printWelcomeMessage(String fileName){
        System.out.println(String.format(MESSAGE_READY, fileName));
    }
}
