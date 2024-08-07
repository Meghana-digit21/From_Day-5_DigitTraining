package copyfilecontent;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        String source = "src/copyfilecontent/Source";
        String destination = "src/copyfilecontent/Destination";
        copyContent(source, destination);
    }


    public static void copyContent(String source, String destination){
        try(
                BufferedReader br = new BufferedReader(new FileReader(source));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destination))
                ) {
            String line;
            while((line = br.readLine()) != null){
                writer.write(line);
            }
            System.out.println("Content copied successfully");
        }
        catch(IOException e){
            System.out.println("Error processing files: "+e.getMessage());
        }
}















//
//package copyfilecontent;
//
//import java.io.*;
//
//public class Main {
//    public static void main(String[] args) {
//        String source = "src/copyfilecontent/source.txt";
//        String destination = "src/copyfilecontent/destination.txt";
//
//        copyContent(source, destination);
//    }
//
//    public static void copyContent(String source, String destination) {
//        try (
//                BufferedReader br = new BufferedReader(new FileReader(source));
//                BufferedWriter writer = new BufferedWriter(new FileWriter(destination));
//        ) {
//            String line;
//            while((line = br.readLine()) != null) {
//                writer.write(line);
//            }
//            System.out.println("Content copied successfully");
//
//        } catch (IOException e) {
//            System.out.println("Error processing files: " + e.getMessage());
//        }
//    }
}