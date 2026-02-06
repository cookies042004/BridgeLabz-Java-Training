package testing;

public class DatabaseConnection {
    private boolean connected = false;

    public void connect() {
        connected = true;
        System.out.println("Connected");
    }

    public void disconnect() {
        connected = false;
        System.out.println("Disconnected");
    }

    public boolean isConnected() {
        return connected;
    }
}
