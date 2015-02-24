public class Command {
    public static enum COMMAND_TYPE {
        DISPLAY, ADD, DELETE, CLEAR, ERROR;
    }

    private COMMAND_TYPE commandType;
    private String argument;
    //private String input;


    public Command() {
        commandType = COMMAND_TYPE.ERROR;
    }

    public Command(String commandAction){

    }

    public Command(String commandAction, String argument) {

    }

    public COMMAND_TYPE getCommandType(){
        return null;
    }




}
