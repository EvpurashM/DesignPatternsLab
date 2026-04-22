package structural;

class Audio { public void on() { System.out.println("Аудіо увімкнено."); } }
class Video { public void on() { System.out.println("Відео увімкнено."); } }

class HomeTheaterFacade {
    private Audio audio = new Audio();
    private Video video = new Video();
    public void watchMovie() {
        System.out.println("Фасад (Facade): Підготовка до перегляду фільму...");
        audio.on();
        video.on();
    }
}

public class FacadePattern {
    public static void run() {
        HomeTheaterFacade theater = new HomeTheaterFacade();
        theater.watchMovie();
    }
}