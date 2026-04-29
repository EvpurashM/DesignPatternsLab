package behavioral;

abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
    public final void play() { // Шаблонний метод
        initialize();
        startPlay();
        endPlay();
    }
}

class Football extends Game {
    void initialize() { System.out.println("Гра ініціалізована."); }
    void startPlay() { System.out.println("Гра почалася!"); }
    void endPlay() { System.out.println("Гра завершена."); }
}

public class TemplatePattern {
    public static void run() {
        Game game = new Football();
        game.play();
    }
}