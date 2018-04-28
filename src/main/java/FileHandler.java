import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    File file;
    FileWriter fileWriter;
    BufferedWriter bf;
    String filename;
    String pathname;

    public FileHandler() throws IOException{
        filename = System.getProperty("java.version") + ".txt";
        pathname = System.getProperty("user.dir") + System.getProperty("file.separator") + filename;
        file = new File(pathname);

        fileWriter = new FileWriter(file, true);

        bf = new BufferedWriter(fileWriter);
        System.out.println(file);
    }

    public String givePath(){
        return pathname;
    }
}
