import java.io.File;
import java.io.IOException;

public class Storage {
    private File file;

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
}
