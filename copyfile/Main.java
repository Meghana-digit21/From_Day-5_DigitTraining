
package copyfile;

import java.io.IOException;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("src/copyfile/source");
        Path destPath = Paths.get("src/copyfile/destination");
        try {
            Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully");
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
