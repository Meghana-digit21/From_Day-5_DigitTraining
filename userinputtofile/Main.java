package userinputtofile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the content to be written: ");
        String content = sc.nextLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/userinputtofile/destination"));
        try {
            writer.write(content);
            System.out.println("Content written successfully");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            writer.close();
        }
    }
}