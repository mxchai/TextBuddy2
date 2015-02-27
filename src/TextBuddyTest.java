import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class TextBuddyTest {
    private static final String PARAM_TEST_FILE_NAME = "test.txt";
    private static final String[] PARAM_POPULATE = {"delta", "bravo", "alpha", "charlie", "bravo"};

    @Test
    public void oldTest() throws Exception {

        Storage storage = new Storage(PARAM_TEST_FILE_NAME);
        storage.clearFile(PARAM_TEST_FILE_NAME);
        ArrayList<String> testArray = new ArrayList<String>();

        testArray.add("line 1");

        storage.writeFile(PARAM_TEST_FILE_NAME, "line 1");

        assertEquals("[line 1]", storage.getFileContent(PARAM_TEST_FILE_NAME).toString());
    }

    @Test
    public void storageTest() throws Exception {
        Storage storage = populateStorage(PARAM_TEST_FILE_NAME);
        ArrayList<String> sortArray = populateArrayListString();
        storage.sortFile(PARAM_TEST_FILE_NAME);
        Collections.sort(sortArray);

        assertEquals("Storage sorts in alphabetical order", sortArray.toString(),
                storage.sortFile(PARAM_TEST_FILE_NAME).toString());

        Storage searchStorage = populateStorage(PARAM_TEST_FILE_NAME);
        String[] lines = {"2", "5"};
        ArrayList<String> foundLines = new ArrayList(Arrays.asList(lines));
        assertEquals("Storage returns searched lines as an ArrayList<String>",
                foundLines, searchStorage.searchFile(PARAM_TEST_FILE_NAME, "bravo"));
    }

    @Test
    public void commandTest() throws Exception {
        Command command = new Command();
        assertEquals("Command constructor without argument has error command type", Command.COMMAND_TYPE.ERROR,
                command.getCommandType());
        assertEquals("Command constructor without argument has no argument", null, command.getArgument());

    }

    @Test
    public void parserTest() throws Exception {
        Parser parser;
        Command command;

        parser = new Parser();
        command = parser.parse("search this");
        assertEquals("Parser 'search this' should return correct COMMAND_TYPE", Command.COMMAND_TYPE.SEARCH,
                command.getCommandType());

        parser = new Parser();
        command = parser.parse("add this");
        assertEquals("Parser 'add this' should return correct COMMAND_TYPE", Command.COMMAND_TYPE.ADD,
                command.getCommandType());
    }

    @Test
    public void controllerTest() throws Exception {

    }

    // Private methods
    private Storage populateStorage(String fileName) throws Exception {
        Storage storage = new Storage(fileName);
        storage.clearFile(PARAM_TEST_FILE_NAME);
        ArrayList<String> entries = new ArrayList(Arrays.asList(PARAM_POPULATE));

        for (String entry : entries) {
            storage.writeFile(fileName, entry);
        }

        return storage;
    }

    private ArrayList<String> populateArrayListString() {
        ArrayList<String> entries = new ArrayList(Arrays.asList(PARAM_POPULATE));
        return entries;
    }
}