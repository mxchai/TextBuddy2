/*

The Parser object parses the input from the user, and creates a Command object,
which is then returned to the Controller.

 */

public class Parser {
    private Command command;

    private static final int PARAM_POSITION_COMMAND = 0;
    private static final int PARAM_ADD_POSITION = 4;
    private static final int PARAM_DELETE_POSITION = 7;
    private static final int PARAM_NO_ARGUMENT_THRESHOLD = 1;
    private static final String PARAM_ADD = "add";

    public Command parse(String input) {
        String[] inputArray = splitInputIntoArray(input);
        command = createCommand(inputArray);
        return command;
    }

    private String[] splitInputIntoArray(String input) {
        return input.trim().split("\\s+");
    }

    private String extractCommandAction(String[] inputArray) {
        return inputArray[PARAM_POSITION_COMMAND];
    }

    private String extractArgument(String[] inputArray, String commandAction) {
        if (commandAction.equals(PARAM_ADD)){
            String toInsert = String.join(" ", inputArray).substring(PARAM_ADD_POSITION).trim();
            return toInsert;
        } else {
            String lineNumber = String.join(" ", inputArray).substring(PARAM_DELETE_POSITION);
            return lineNumber;
        }
    }

    public static boolean hasValidArguments(String[] commandParameters){
        if (commandParameters.length == 1){
            // add and delete must take in additional arguments, so commandParameters
            // cannot only have 1 word
            return false;
        } else {
            return true;
        }
    }

    private boolean noArgument(String[] inputArray){
        return !(inputArray.length > PARAM_NO_ARGUMENT_THRESHOLD);
    }

    private Command createCommand(String[] inputArray){
        String commandAction = extractCommandAction(inputArray);

        if (commandAction.equals("add") || commandAction.equals("delete")) {
            if (hasValidArguments(inputArray)){
                String argument = extractArgument(inputArray, commandAction);
                command = new Command(commandAction, argument);
                System.out.println("delet workzxc");
            } else {
                command = new Command();
            }
        } else {
            command = new Command(commandAction);
        }
        return command;
    }

}
