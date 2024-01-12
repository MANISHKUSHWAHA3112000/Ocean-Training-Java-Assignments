package oopsassignments;

import static org.junit.Assert.assertEquals;

import java.util.Objects;
import java.util.logging.Logger;

import org.junit.Test;

interface Persistable {
    String persist();
}

abstract class Persistence implements Persistable {
    // Common methods or properties for all persistence classes
}

class FilePersistence extends Persistence {
    @SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(FilePersistence.class.getName());

    @Override
    public String persist() {
        return "I am a persist method in class FilePersistence";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}

class DatabasePersistence extends Persistence {
    @SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(DatabasePersistence.class.getName());

    @Override
    public String persist() {
        return "I am a persist method in class DatabasePersistence";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}

public class Assignment2Q6 {
	
	@Test
    public void testFilePersistence() {
        Persistable file = new FilePersistence();
        assertEquals("I am a persist method in class FilePersistence", file.persist());
    }

    @Test
    public void testDatabasePersistence() {
        Persistable database = new DatabasePersistence();
        assertEquals("I am a persist method in class DatabasePersistence", database.persist());
    }

    @Test
    public void testFilePersistenceMultipleInstances() {
        // Create multiple instances of FilePersistence and ensure persist method returns the correct result
        Persistable file1 = new FilePersistence();
        Persistable file2 = new FilePersistence();
        assertEquals("I am a persist method in class FilePersistence", file1.persist());
        assertEquals("I am a persist method in class FilePersistence", file2.persist());
    }

    @Test
    public void testDatabasePersistenceMultipleInstances() {
        // Create multiple instances of DatabasePersistence and ensure persist method returns the correct result
        Persistable database1 = new DatabasePersistence();
        Persistable database2 = new DatabasePersistence();
        assertEquals("I am a persist method in class DatabasePersistence", database1.persist());
        assertEquals("I am a persist method in class DatabasePersistence", database2.persist());
    }

    @Test
    public void testFilePersistenceEquals() {
        // Ensure two instances of FilePersistence are equal
        Persistable file1 = new FilePersistence();
        Persistable file2 = new FilePersistence();
        assertEquals(file1, file2);
    }

    @Test
    public void testDatabasePersistenceEquals() {
        // Ensure two instances of DatabasePersistence are equal
        Persistable database1 = new DatabasePersistence();
        Persistable database2 = new DatabasePersistence();
        assertEquals(database1, database2);
    }
	
    private static final Logger logger = Logger.getLogger(Assignment2Q6.class.getName());

    public static void main(String[] args) {
        Persistable file = new FilePersistence();
        logger.info(file.persist());

        Persistable database = new DatabasePersistence();
        logger.info(database.persist());
    }
}
