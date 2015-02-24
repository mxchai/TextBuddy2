import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Controller {
    private static final String MESSAGE_HELLO = "hello";

    private Parser parser = new Parser();
    private Storage storage;
    private String fileName;

    public Controller(String fileName) {
        this.fileName = fileName;
        storage = new Storage(fileName);
    }

    public String execute(String input) {
        // Makes a call to the parser
        Command command = parser.parse(input);

        // Execute the command here and returns the result to the View
        Command.COMMAND_TYPE commandType = command.getCommandType();

        switch (commandType) {
            case DISPLAY:
                ArrayList<String> fileContent = storage.getFileContent(fileName);
                return displayFile(fileContent);
            case ADD:
                return null;
            case DELETE:
                return null;
            case CLEAR:
                return null;
            case ERROR:
                return null;
        }
        return null;
    }

    public void processCommand(Command command) {

    }

    public String addLine(){
        return MESSAGE_HELLO;
    }

    public String displayFile(ArrayList<String> fileContent) {
        String display = "";

        int counter = 1;
        for (String line : fileContent){
            display += counter + ". " + line + "\n";
            counter++;
        }

        return display;
    }



}
