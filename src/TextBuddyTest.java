import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TextBuddyTest {

    @Test
    public void storageTest() throws Exception {

        Storage storage = new Storage("temp.txt");
        storage.clearFile("temp.txt");
        ArrayList<String> testArray = new ArrayList<String>();

        testArray.add("line 1");

        storage.writeFile("temp.txt", "line 1");

        assertEquals(storage.getFileContent("temp.txt").toString(), "[line 1]");
    }
}