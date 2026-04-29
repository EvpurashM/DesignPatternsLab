package behavioral;

interface State { void doAction(); }

class StartState implements State {
    public void doAction() { System.out.println("Система в стані: СТАРТ"); }
}

class StopState implements State {
    public void doAction() { System.out.println("Система в стані: СТОП"); }
}

public class StatePattern {
    public static void run() {
        State start = new StartState();
        start.doAction();
        State stop = new StopState();
        stop.doAction();
    }
}