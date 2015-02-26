public class Command {
    public static enum COMMAND_TYPE {
        DISPLAY, ADD, DELETE, CLEAR, EXIT, ERROR, SORT, SEARCH;
    }

    private static final String PARAM_DISPLAY = "display";
    private static final String PARAM_ADD = "add";
    private static final String PARAM_DELETE = "delete";
    private static final String PARAM_CLEAR = "clear";
    private static final String PARAM_EXIT = "exit";
    private static final String PARAM_SORT = "sort";
    private static final String PARAM_SEARCH = "search";

    private COMMAND_TYPE commandType = COMMAND_TYPE.ERROR;
    private String argument;

    // Error constructor
    public Command() {
        commandType = COMMAND_TYPE.ERROR;
    }

    // Only commandAction, no argument
    public Command(String commandAction){
        if (commandAction.equals(PARAM_DISPLAY)){
            commandType = COMMAND_TYPE.DISPLAY;
        } else if (commandAction.equals(PARAM_CLEAR)){
            commandType = COMMAND_TYPE.CLEAR;
        } else if (commandAction.equals(PARAM_EXIT)){
            commandType = COMMAND_TYPE.EXIT;
        } else if (commandAction.equals(PARAM_SORT)){
            commandType = COMMAND_TYPE.SORT;
        }
    }

    // commandAction and argument
    public Command(String commandAction, String argument) {
        if (commandAction.equals(PARAM_ADD)){
            commandType = COMMAND_TYPE.ADD;
            this.argument = argument;
        } else if (commandAction.equals(PARAM_DELETE)){
            commandType = COMMAND_TYPE.DELETE;
            this.argument = argument;
        } else if (commandAction.equals(PARAM_SEARCH)){
            commandType = COMMAND_TYPE.SEARCH;
            this.argument = argument;
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
