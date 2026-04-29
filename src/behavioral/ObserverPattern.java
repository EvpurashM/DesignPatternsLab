package behavioral;
import java.util.ArrayList;
import java.util.List;

class Subject {
    private List<Observer> observers = new ArrayList<>();
    public void attach(Observer observer) { observers.add(observer); }
    public void notifyAllObservers() {
        for (Observer observer : observers) { observer.update(); }
    }
}

abstract class Observer { abstract public void update(); }

class TextObserver extends Observer {
    public void update() { System.out.println("Спостерігач отримав оновлення!"); }
}

public class ObserverPattern {
    public static void run() {
        Subject subject = new Subject();
        subject.attach(new TextObserver());
        subject.notifyAllObservers();
    }
}