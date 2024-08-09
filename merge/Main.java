package merge;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path dirPath = Paths.get("src/merge");
        Path mergedFilePath = Paths.get("src/merge/merged.txt");

        try (Stream<Path> filePathStream = Files.list(dirPath);
             FileChannel mergedFileChannel = FileChannel.open(mergedFilePath, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE)) {

            filePathStream
                    .filter(Files::isRegularFile)
                    .filter(filePath -> !filePath.equals(mergedFilePath))
                    .forEach(filePath -> {
                        try (FileChannel fileChannel = FileChannel.open(filePath, StandardOpenOption.READ)) {
                            ByteBuffer buffer = ByteBuffer.allocateDirect(8192);
                            while (fileChannel.read(buffer) > 0) {
                                buffer.flip();
                                mergedFileChannel.write(buffer);
                                buffer.clear();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            System.out.println("Files merged successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
