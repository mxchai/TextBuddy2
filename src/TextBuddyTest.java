import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class TextBuddyTest {

    @Test
    public void oldTest() throws Exception {

        Storage storage = new Storage("temp.txt");
        storage.clearFile("temp.txt");
        ArrayList<String> testArray = new ArrayList<String>();

        testArray.add("line 1");

        storage.writeFile("temp.txt", "line 1");

        assertEquals("[line 1]", storage.getFileContent("temp.txt").toString());
    }

    @Test
    public void storageTest() throws Exception {
        Storage storage = new Storage("sort.txt");
        storage.clearFile("sort.txt");
        ArrayList<String> sortArray = new ArrayList<String>();

        sortArray.add("delta");
        sortArray.add("alpha");
        sortArray.add("charlie");
        sortArray.add("bravo");

        storage.writeFile("sort.txt", "delta");
        storage.writeFile("sort.txt", "alpha");
        storage.writeFile("sort.txt", "charlie");
        storage.writeFile("sort.txt", "bravo");

        storage.sortFile("sort.txt");

        Collections.sort(sortArray);

        storage.sortFile("sort.txt");
        assertEquals("Storage sorts in alphabetical order", sortArray.toString(), storage.sortFile("sort.txt").toString());
    }

    @Test
    public void commandTest() throws Exception {
        Command command = new Command();
        
    }

    @Test
    public void parserTest() throws Exception {

    }

    @Test
    public void controllerTest() throws Exception {

    }
}