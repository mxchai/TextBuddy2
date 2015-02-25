/**
 * Created by mx on 24/2/15.
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
        while(true){
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
