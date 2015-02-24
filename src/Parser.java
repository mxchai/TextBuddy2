/*

The Parser object parses the input from the user, and creates a Command object.
The Parser object makes no assumption about the input. It only separates it into
the commandAction and argument.
Validity check is done by the Command object.

 */

public class Parser {
    private Command command;

    private static final int PARAM_POSITION_COMMAND = 0;
    private static final int PARAM_NO_ARGUMENT_THRESHOLD = 1;
    private static final String PARAM_ADD = "add";

    public Command parse(String input) {
        Command.COMMAND_TYPE commandType = command.getCommandType();
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
            String toInsert = String.join(" ", inputArray).substring(4).trim();
            return toInsert;
        } else {
            String lineNumber = String.join(" ", inputArray).substring(7);
            return lineNumber;
        }
    }

    /**
     *
     * Add and Delete cannot have no arguments i.e. length must be > 1
     */
    public static boolean invalidArgument(String[] inputArray){
        if (inputArray.length == 1){
            return true;
        } else {
            return false;
        }
    }

    private boolean noArgument(String[] inputArray){
        return !(inputArray.length > PARAM_NO_ARGUMENT_THRESHOLD);
    }

    private Command createCommand(String[] inputArray){
        String commandAction = extractCommandAction(inputArray);

        if (noArgument(inputArray)){
            command = new Command(commandAction);
        } else {
            String argument = extractArgument(inputArray, commandAction);
            command = new Command(commandAction, argument);
        }
        return command;
    }

}
