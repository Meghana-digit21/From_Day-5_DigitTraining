
package movefile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("src/movefile/source");
        Path targetPath = Paths.get("src/movefile/target");
        try {
            Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved successfully");
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
