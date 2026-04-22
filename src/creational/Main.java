package creational;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Демонстрація породжувальних патернів ---");

        // 1. Singleton (Одинак)
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();

        // 2. Factory Method (Фабричний метод)
        Factory factory = new Factory();
        Product product = factory.createProduct();
        product.create();

        // 3. Abstract Factory (Абстрактна фабрика)
        GUIFactory guiFactory = new AbstractFactoryDemo();
        Button button = guiFactory.createButton();
        button.paint();

        // 4. Builder (Будівельник)
        Builder builder = new Builder();
        House house = builder.buildWalls().getResult();
        house.show();

        // 5. Prototype (Прототип)
        PrototypeItem original = new PrototypeItem();
        PrototypeItem clone = original.clone();
        if (clone != null) {
            clone.display();
        }

        // 6. Object Pool (Пул об'єктів)
        ConnectionPool pool = new ConnectionPool();
        String conn = pool.getConnection(); // Беремо підключення
        System.out.println("Object Pool: Отримано -> " + conn);
        pool.releaseConnection(conn); // Повертаємо підключення
    }
}