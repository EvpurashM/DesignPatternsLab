package behavioral;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Лабораторна робота: Поведінкові патерни ---");
        
        System.out.println("\n1. Chain of Responsibility:"); ChainPattern.run();
        System.out.println("\n2. Command:"); CommandPattern.run();
        System.out.println("\n3. Iterator:"); IteratorPattern.run();
        System.out.println("\n4. Mediator:"); MediatorPattern.run();
        System.out.println("\n5. Memento:"); MementoPattern.run();
        System.out.println("\n6. Observer:"); ObserverPattern.run();
        System.out.println("\n7. State:"); StatePattern.run();
        System.out.println("\n8. Strategy:"); StrategyPattern.run();
        System.out.println("\n9. Template Method:"); TemplatePattern.run();
        System.out.println("\n10. Visitor:"); VisitorPattern.run();
    }
}