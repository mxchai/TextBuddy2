public class Command {
    public static enum COMMAND_TYPE {
        DISPLAY, ADD, DELETE, CLEAR, ERROR;
    }

    private static final String PARAM_DISPLAY = "display";
    private static final String PARAM_ADD = "add";
    private static final String PARAM_DELETE = "delete";
    private static final String PARAM_CLEAR = "clear";

    private COMMAND_TYPE commandType;
    private String argument;

    public Command() {
        commandType = COMMAND_TYPE.ERROR;
    }

    public Command(String commandAction){
        if (commandAction.equals(PARAM_DISPLAY)){
            commandType = COMMAND_TYPE.DISPLAY;
        } else if (commandAction.equals(PARAM_CLEAR)){
            commandType = COMMAND_TYPE.CLEAR;
        }
    }

    public Command(String commandAction, String argument) {
        if (commandAction.equals(PARAM_ADD)){
            commandType = COMMAND_TYPE.ADD;
        } else if (commandAction.equals(PARAM_DELETE)){
            commandType = COMMAND_TYPE.DELETE;
        }
    }

    // Public getters
    public COMMAND_TYPE getCommandType(){
        return commandType;
    }

    public String getArgument(){
        return argument;
    }
}
