package creational;

public class Singleton {
    private static Singleton instance;
    
    // Приватний конструктор, щоб не можна було створити об'єкт через new
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    public void doSomething() { 
        System.out.println("Singleton: Працює єдиний екземпляр класу!"); 
    }
}