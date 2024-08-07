package countwords;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int counter = 0;
        FileReader reader = new FileReader("src/countwords/text_file.txt");
        try {
            int i;
            while ((i = reader.read()) != -1) {
                if(i == 32) {
                    counter++;
                }
            }
            System.out.println("The text file has " + (counter + 1) + " words");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            reader.close();
        }
    }
}