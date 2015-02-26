import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.nio.file.Files;

public class Storage {
    private File file;
    private ArrayList<String> fileContent;
    private static final String TEMP_FILENAME = "temp.txt";

    public Storage(String fileName) {
        file = createFileIfNonExistent(fileName);
    }

    public static File createFileIfNonExistent(String fileName){
        File file = new File(fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e){
                System.out.println("Cannot create file!");
                System.exit(0);
            }
        }
        return file;
    }

    // Initialisation Methods
    public BufferedReader initBufferedReader(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            return reader;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public BufferedWriter initBufferedWriters(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            return writer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public PrintWriter initPrintWriter(String fileName) {
        try {
            PrintWriter printWriter = new PrintWriter(fileName);
            return printWriter;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public File initFile(String fileName) {
        try {
            File file = new File(fileName);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Exposed Methods
    public ArrayList<String> getFileContent(String fileName) throws Exception{
        BufferedReader reader = initBufferedReader(fileName);
        ArrayList<String> fileContent = new ArrayList<String>();
        String line = null;

        try {
            while ((line = reader.readLine()) != null) {
                fileContent.add(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        reader.close();

        return fileContent;
    }

    public boolean writeFile(String fileName, String toInsert) {
        try {
            BufferedWriter writer = initBufferedWriters(fileName);
            writer.write(toInsert);
            writer.newLine();
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean clearFile(String fileName) {
        try {
            PrintWriter printWriter = initPrintWriter(fileName);
            printWriter.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public String deleteLine(String fileName, int lineNumber) throws IOException{
        File current = initFile(fileName);
        File temp = initFile(TEMP_FILENAME);

        BufferedReader reader = initBufferedReader(fileName);
        PrintWriter printWriter = initPrintWriter(TEMP_FILENAME);

        List<String> allLines = Files.readAllLines(current.toPath());
        int numLines = allLines.size();

        // Validates line number for deletion
        if (!isValidLineNumber(lineNumber, numLines)){
            return null;
        }

        String line = null;
        String deletedLine = "not initialised";
        int currentLine = 1; // counter for line number
        while ((line = reader.readLine()) != null){
            if (currentLine != lineNumber) {
                printWriter.println(line);
            } else {
                deletedLine = line;
            }
            currentLine++;
        }
        printWriter.close();
        reader.close();
        current.delete();
        temp.renameTo(current);

        return deletedLine;
    }

    public ArrayList<String> sortFile(String fileName) throws Exception {
        fileContent = getFileContent(fileName);
        clearFile(fileName);

        Collections.sort(fileContent);

        for (String line : fileContent) {
            writeFile(fileName, line);
        }

        fileContent = getFileContent(fileName);
        return fileContent;
    }

    public ArrayList<String> searchFile(String fileName, String toFind) throws Exception {
        ArrayList<String> fileContent = getFileContent(fileName);
        ArrayList<String> foundLine = new ArrayList();
        Integer counter = new Integer(1);

        for (String line : fileContent) {
            if (toFind.equals(line)){
                foundLine.add(counter.toString());
            }
            counter++;
        }

        return foundLine;
    }

    // Private methods
    private boolean isValidLineNumber(int commandArguments, int totalNumLines){
        return commandArguments <= totalNumLines;
    }
}
