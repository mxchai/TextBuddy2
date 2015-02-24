import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.List;

import java.nio.file.Files;

public class Storage {
    private File file;
    private FileReader fileReader;
    private BufferedReader reader;


    public Storage(String fileName) {
        file = createFileIfNonExistent(fileName);
        try {
            fileReader = new FileReader(fileName);
        } catch (Exception e){
            e.printStackTrace();
        }
        reader = new BufferedReader(fileReader);

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

    // Refactor this to store the file content, then you no need to concern yourself with reader.close();
    public ArrayList<String> getFileContent(String fileName) {
        ArrayList<String> fileContents = new ArrayList<String>();
        String line = null;

        try {
            while ((line = reader.readLine()) != null) {
                fileContents.add(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileContents;
    }
/*

    public static void writeFile(String fileName, String toInsert) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

        writer.write(toInsert);
        writer.newLine();
        writer.close();

        System.out.println("added to " + fileName + ": " + '"' + toInsert + '"');
    }

    public static void clearFile(String fileName) throws Exception{
        PrintWriter printWriter = new PrintWriter(fileName);
        printWriter.close();
    }


    public static void deleteFile(String fileName, int lineNumber) throws IOException{
        File current = new File(fileName);
        File temp = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        PrintWriter printWriter = new PrintWriter(new FileWriter(temp));

        List<String> allLines = Files.readAllLines(current.toPath());
        int numLines = allLines.size();

        // Validates line number for deletion
        if (!isValidLineNumber(lineNumber, numLines)){
            printResponse("error", fileName);
            return;
        }

        String line = null;
        int currentLine = 1; // counter for line number
        while ((line = reader.readLine()) != null){
            if (currentLine != lineNumber) {
                printWriter.println(line);
            } else {
                System.out.println("deleted from " + fileName + ": " + '"' + line + '"');
            }
            currentLine++;
        }
        printWriter.close();
        reader.close();
        current.delete();
        temp.renameTo(current);
    }

    public static boolean isValidLineNumber(int commandArguments, int totalNumLines){
        return commandArguments <= totalNumLines;
    }*/
}
