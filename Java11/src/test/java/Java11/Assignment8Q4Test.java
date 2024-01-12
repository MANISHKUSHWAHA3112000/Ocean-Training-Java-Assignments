package Java11;



import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class Assignment8Q4Test {

    @SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(Assignment8Q4.class.getName());

    @Test
    void testMainMethodWithValidFile() {
        // Given a valid file
        String testFilePath = "src/test/resources/TestStudentList.txt";
        @SuppressWarnings("unused")
		Path testFile = Paths.get(testFilePath);

        // When running the main method
        Assignment8Q4.main(new String[]{testFilePath});

        // Then no exception should be thrown
    }

   
    

    

    @Test
    void testReadStudentFileWithInvalidFile() {
        // Given an invalid file path
        String invalidFilePath = "src/test/resources/NonExistentFile.txt";

        // When reading the student file with an invalid file
        assertThrows(IOException.class, () -> Assignment8Q4.readStudentFile(Paths.get(invalidFilePath)));
    }

    

    
}
