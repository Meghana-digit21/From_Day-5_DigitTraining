
package findandreplace;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        Path originalFilePath = Paths.get("src/findandreplace/original");
        Path tempFilePath = Paths.get("src/findandreplace/temp");

        String targetText = "unmodified";
        String replacementText = "modified";

        try (BufferedReader reader = Files.newBufferedReader(originalFilePath);
             BufferedWriter writer = Files.newBufferedWriter(tempFilePath, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String modifiedLine = line.replace(targetText, replacementText);
                writer.write(modifiedLine);
                writer.newLine();
            }
            Files.delete(originalFilePath);

            Files.move(tempFilePath, originalFilePath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Text replaced successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
