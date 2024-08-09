
package compare;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {
    private static final int BUFFER_SIZE = 1024 * 1024;

    public static void main(String[] args) {
        Path filePath1 = Paths.get("src/compare/file1");
        Path filePath2 = Paths.get("src/compare/file2");

        try (FileChannel fileChannel1 = FileChannel.open(filePath1, StandardOpenOption.READ);
             FileChannel fileChannel2 = FileChannel.open(filePath2, StandardOpenOption.READ)) {

            if (fileChannel1.size() != fileChannel2.size()) {
                System.out.println("Files are not equal.");
                return;
            }

            long fileSize = fileChannel1.size();
            long position = 0;

            while (position < fileSize) {
                long bytesToRead = Math.min(BUFFER_SIZE, fileSize - position);

                ByteBuffer buffer1 = fileChannel1.map(FileChannel.MapMode.READ_ONLY, position, bytesToRead);
                ByteBuffer buffer2 = fileChannel2.map(FileChannel.MapMode.READ_ONLY, position, bytesToRead);

                for (int i = 0; i < bytesToRead; i++) {
                    if (buffer1.get(i) != buffer2.get(i)) {
                        System.out.println("Files are not equal.");
                        return;
                    }
                }
                position += bytesToRead;
            }

            System.out.println("Files are equal.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
