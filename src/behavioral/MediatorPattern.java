package behavioral;

class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println("[" + user.getName() + "]: " + message);
    }
}

class User {
    private String name;
    public User(String name) { this.name = name; }
    public String getName() { return name; }
    public void sendMessage(String message) { ChatRoom.showMessage(this, message); }
}

public class MediatorPattern {
    public static void run() {
        User user1 = new User("Олег");
        user1.sendMessage("Привіт усім!");
    }
}