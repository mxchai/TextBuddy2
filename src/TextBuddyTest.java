import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class TextBuddyTest {

    @Test
    public void storageTest() throws Exception {

        Storage storage = new Storage("temp.txt");
        storage.clearFile("temp.txt");
        ArrayList<String> testArray = new ArrayList<String>();

        testArray.add("line 1");

        storage.writeFile("temp.txt", "line 1");

        assertEquals("[line 1]", storage.getFileContent("temp.txt").toString());
    }

    @Test
    public void sortTest() throws Exception {
        Storage storage = new Storage("sort.txt");
        storage.clearFile("sort.txt");
        ArrayList<String> sortArray = new ArrayList<String>();

        sortArray.add("delta");
        sortArray.add("alpha");
        sortArray.add("charlie");
        sortArray.add("bravo");

        Collections.sort(sortArray);
        System.out.println(sortArray.toString());

        storage.sortFile("sort.txt");
        assertEquals(sortArray.toString(), storage.getFileContent("sort.txt").toString());




    }
}