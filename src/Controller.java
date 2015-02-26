import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Controller {
    private static final String MESSAGE_ERROR = "Your command was invalid. \n";
    private static final String MESSAGE_READY = "Welcome to TextBuddy. %s is ready for use.";
    private static final String MESSAGE_CLEAR = "All file content has been cleared. \n";
    private static final String MESSAGE_LINE_ADDED = "added to %s: '%s' \n";
    private static final String MESSAGE_LINE_DELETED = "deleted from %s: '%s' \n";
    private static final String MESSAGE_EMPTY = "%s is empty \n";
    private static final String MESSAGE_EXIT = "%s has been successfully closed. \n";

    private Parser parser = new Parser();
    private Storage storage;
    private String fileName;

    public Controller(String fileName) {
        this.fileName = fileName;
        storage = new Storage(fileName);
    }

    public String execute(String input) {
        // Makes a call to the parser which returns a Command object
        Command command = parser.parse(input);

        // Execute the command here and returns the result to the View
        Command.COMMAND_TYPE commandType = command.getCommandType();

        // Maybe can factor out into individual methods
        try {
            switch (commandType) {
                case DISPLAY:
                    ArrayList<String> fileContent = storage.getFileContent(fileName);
                    return displayFile(fileContent);
                case ADD:
                    String addArgument = command.getArgument();
                    if (storage.writeFile(fileName, addArgument)) {
                        return addLineToFile(addArgument);
                    } else {
                        return errorMessage();
                    }
                case DELETE:
                    int deleteArgument = Integer.parseInt(command.getArgument());
                    String response = storage.deleteLine(fileName, deleteArgument);
                    if (response != null){
                        return deleteLineFromFile(response);
                    } else {
                        return errorMessage();
                    }
                case CLEAR:
                    if (storage.clearFile(fileName)) {
                        return MESSAGE_CLEAR;
                    } else {
                        return errorMessage();
                    }
                case EXIT:
                    return exit();
                case SORT:
                    ArrayList<String> sortedFileContent = storage.sortFile(fileName);
                    return displayFile(sortedFileContent);
                case ERROR:
                    return errorMessage();
            }
        } catch (Exception e) {
            return errorMessage();
        }
        return errorMessage();
    }


    public String welcomeMessage() {
        return String.format(MESSAGE_READY, fileName);
    }

    public String exitMessage() {
        return String.format(MESSAGE_EXIT, fileName);
    }

    public String errorMessage() {
        return MESSAGE_ERROR;
    }

    public String displayFile(ArrayList<String> fileContent) {
        if (fileContent.size() == 0){
            return String.format(MESSAGE_EMPTY, fileName);
        }

        String display = "";

        int counter = 1;
        for (String line : fileContent){
            display += counter + ". " + line + "\n";
            counter++;
        }
        return display;
    }

    public String addLineToFile(String argument) {
        String toInsert = String.format(MESSAGE_LINE_ADDED, fileName, argument);
        return toInsert;
    }

    public String deleteLineFromFile(String argument) {
        String output = String.format(MESSAGE_LINE_DELETED, fileName, argument);
        return output;
    }

    public String searchLineFromFile(String argument, ArrayList<String> fileContent) {
        return null;
    }

    // Private methods
    private String exit() {
        return null;
    }
}
