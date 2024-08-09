
package writingdata;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("src/writingdata/destination");
        List<String> lines = Arrays.asList("The below are two lines that are written in to a file", "Line1", "Line2");

        try {
            Files.write(filePath, lines);
            System.out.println("Data written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
