package exceptionhandling;


class DatabaseConnection implements AutoCloseable {
    public void connect() {
        System.out.println("Connected to database");
    }

    public void execute() {
        throw new RuntimeException("Database error");
    }

    @Override
    public void close() {
        System.out.println("Connection closed");
    }
}

public class ResourceCleanupExample {
    public static void main(String[] args) {
        try (DatabaseConnection db = new DatabaseConnection()) {
            db.connect();
            db.execute();

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}

