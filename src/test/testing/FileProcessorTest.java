package testing;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {
    FileProcessor processor = new FileProcessor();

    @Test
    void testWriteAndRead() throws Exception {
        String filename = "testfile.txt";
        processor.writeToFile(filename, "Hello");

        File file = new File(filename);
        assertTrue(file.exists());

        String content = processor.readFromFile(filename);
        assertEquals("Hello", content);

        file.delete();
    }
}
