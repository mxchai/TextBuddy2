public class Controller {
    private static final String MESSAGE_HELLO = "hello";



    private Parser parser = new Parser();
    private Storage storage;
    private String fileName;

    public Controller(String fn) {
        fileName = fn;
        storage = new Storage(fileName);
    }

    public String execute(String input) {
        // Makes a call to the parser
        Command command = parser.parse(input);


        // Execute the command here and returns the result to the View
        Command.COMMAND_TYPE commandType = command.getCommandType();

        switch (commandType) {
            case ADD:
                return null;
        }







        return null;
    }

    public void processCommand(Command command) {

    }

    public String addLine(){
        return MESSAGE_HELLO;
    }


}
