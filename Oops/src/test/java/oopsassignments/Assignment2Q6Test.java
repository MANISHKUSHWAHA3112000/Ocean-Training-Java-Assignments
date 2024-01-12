package oopsassignments;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class Assignment2Q6Test {

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
}

