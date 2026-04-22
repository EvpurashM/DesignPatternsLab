package creational;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private List<String> availableConnections = new ArrayList<>();
    
    public ConnectionPool() {
        availableConnections.add("Підключення до БД #1");
    }
    
    public String getConnection() {
        if (availableConnections.isEmpty()) return "Немає вільних підключень";
        return availableConnections.remove(0);
    }
    
    public void releaseConnection(String connection) {
        availableConnections.add(connection);
        System.out.println("Object Pool: Підключення повернуто в пул");
    }
}