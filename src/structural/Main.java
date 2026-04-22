package structural;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Лабораторна №2: Структурні патерни ---");
        
        System.out.println("\n1. Adapter:");
        AdapterPattern.run();

        System.out.println("\n2. Bridge:");
        BridgePattern.run();

        System.out.println("\n3. Composite:");
        CompositePattern.run();

        System.out.println("\n4. Decorator:");
        DecoratorPattern.run();

        System.out.println("\n5. Facade:");
        FacadePattern.run();

        System.out.println("\n6. Flyweight:");
        FlyweightPattern.run();

        System.out.println("\n7. Proxy:");
        ProxyPattern.run();
    }
}