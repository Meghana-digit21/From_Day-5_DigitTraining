package FileCombiner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCombiner {
    public static void combineFiles(String file1Path, String file2Path, String outputPath) {
        try (
                BufferedReader reader1 = new BufferedReader(new FileReader(file1Path));
                BufferedReader reader2 = new BufferedReader(new FileReader(file2Path));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))
        ) {
            String line;
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Files combined successfully into " + outputPath);

        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String file1Path = "src/filecombiner/file1.txt";
        String file2Path = "src/filecombiner/file2.txt";
        String outputPath = "src/filecombiner/combined_output.txt";

        combineFiles(file1Path, file2Path, outputPath);
    }
}