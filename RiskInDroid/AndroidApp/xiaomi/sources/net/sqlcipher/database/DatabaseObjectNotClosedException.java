package net.sqlcipher.database;

public class DatabaseObjectNotClosedException extends RuntimeException {
    public DatabaseObjectNotClosedException() {
        super("Application did not close the cursor or database object that was opened here");
    }
}
