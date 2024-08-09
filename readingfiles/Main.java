
package readingfiles;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("src/readingfiles/text");

        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(line -> {
                System.out.println(line);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
