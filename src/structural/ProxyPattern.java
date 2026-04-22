package structural;

interface Database { void query(); }

class RealDatabase implements Database {
    public RealDatabase() { System.out.println("Підключення до важкої БД..."); }
    public void query() { System.out.println("Виконання запиту."); }
}

class ProxyDatabase implements Database {
    private RealDatabase realDb;
    public void query() {
        System.out.println("Замісник (Proxy): Перевірка доступу...");
        if (realDb == null) { realDb = new RealDatabase(); }
        realDb.query();
    }
}

public class ProxyPattern {
    public static void run() {
        Database db = new ProxyDatabase();
        db.query(); // Ініціалізує БД
        db.query(); // Використовує існуючу БД
    }
}