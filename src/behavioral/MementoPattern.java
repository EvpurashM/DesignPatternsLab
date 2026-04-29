package behavioral;

class Memento {
    private String state;
    public Memento(String state) { this.state = state; }
    public String getState() { return state; }
}

class Originator {
    private String state;
    public void setState(String state) { this.state = state; }
    public Memento saveStateToMemento() { return new Memento(state); }
    public void getStateFromMemento(Memento memento) { state = memento.getState(); }
}

public class MementoPattern {
    public static void run() {
        Originator originator = new Originator();
        originator.setState("Стан #1");
        Memento savedState = originator.saveStateToMemento();
        originator.setState("Стан #2 (Помилка)");
        originator.getStateFromMemento(savedState);
        System.out.println("Відновлений стан: " + originator.saveStateToMemento().getState());
    }
}