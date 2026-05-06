package lab5;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Лабораторна робота №5: Патерни у функціональному стилі ---");

        // ==========================================
        // 1. Стратегія (Strategy)[cite: 5]
        // Замість створення інтерфейсу Strategy і окремих класів для кожної знижки,
        // ми просто використовуємо лямбда-вирази (інтерфейс Function).
        // ==========================================
        System.out.println("\n1. Стратегія (Strategy):");
        Function<Double, Double> discount10 = price -> price * 0.9;
        Function<Double, Double> discount20 = price -> price * 0.8;
        Function<Double, Double> noDiscount = price -> price;
        
        double originalPrice = 100.0;
        System.out.println("Ціна без знижки: " + applyStrategy(originalPrice, noDiscount));
        System.out.println("Ціна зі знижкою 10%: " + applyStrategy(originalPrice, discount10));
        System.out.println("Ціна зі знижкою 20%: " + applyStrategy(originalPrice, discount20));

        // ==========================================
        // 2. Фабричний метод (Factory method)[cite: 5]
        // Замість створення абстрактної фабрики і її спадкоємців, 
        // ми зберігаємо лямбди (Supplier), які вміють створювати об'єкти, у Map.
        // ==========================================
        System.out.println("\n2. Фабричний метод (Factory method):");
        ProductFactory.registerProduct("Phone", Phone::new);
        ProductFactory.registerProduct("Laptop", Laptop::new);
        
        Product p1 = ProductFactory.createProduct("Phone");
        Product p2 = ProductFactory.createProduct("Laptop");
        System.out.println("Створено: " + p1.getName());
        System.out.println("Створено: " + p2.getName());

        // ==========================================
        // 3. Декоратор (Decorator)[cite: 5]
        // Замість класів-обгорток ми використовуємо стандартний метод .andThen() 
        // для послідовного виклику (композиції) функцій.
        // ==========================================
        System.out.println("\n3. Декоратор (Decorator):");
        Function<String, String> basicText = text -> text;
        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> addBrackets = text -> "[" + text + "]";
        
        // Збираємо декоратори в один ланцюг
        Function<String, String> decoratedText = basicText.andThen(toUpperCase).andThen(addBrackets);
        System.out.println("Результат декоратора: " + decoratedText.apply("привіт світ"));

        // ==========================================
        // 4. Навколишнє виконання (Execute around)[cite: 5]
        // Патерн ховає відкриття і закриття ресурсу всередині методу,
        // а користувач просто передає лямбду з тим, ЩО треба зробити з ресурсом.
        // ==========================================
        System.out.println("\n4. Навколишнє виконання (Execute around):");
        Resource.use(resource -> {
            System.out.println("  -> Читаємо дані з БД або файлу...");
            resource.doOperation();
        });
    }

    // --- ДОПОМІЖНІ МЕТОДИ ТА КЛАСИ ---

    // Метод для Стратегії
    public static double applyStrategy(double price, Function<Double, Double> strategy) {
        return strategy.apply(price);
    }

    // Інтерфейс та класи для Фабричного методу
    interface Product { String getName(); }
    static class Phone implements Product { public String getName() { return "Смартфон"; } }
    static class Laptop implements Product { public String getName() { return "Ноутбук"; } }
    
    // Сама функціональна Фабрика
    static class ProductFactory {
        private static final Map<String, Supplier<Product>> map = new HashMap<>();
        
        public static void registerProduct(String name, Supplier<Product> supplier) {
            map.put(name, supplier);
        }
        
        public static Product createProduct(String name) {
            Supplier<Product> supplier = map.get(name);
            if (supplier != null) return supplier.get();
            throw new IllegalArgumentException("Невідомий продукт: " + name);
        }
    }

    // Клас для Execute Around
    static class Resource {
        private Resource() { System.out.println("[Ресурс відкрито]"); }
        public void doOperation() { System.out.println("[Операція виконується]"); }
        private void close() { System.out.println("[Ресурс закрито]"); }
        
        // Метод Execute Around
        public static void use(Consumer<Resource> consumer) {
            Resource resource = new Resource();
            try {
                consumer.accept(resource); // Виконуємо код, який передали в лямбді
            } finally {
                resource.close(); // Гарантовано закриваємо ресурс, навіть якщо була помилка
            }
        }
    }
}