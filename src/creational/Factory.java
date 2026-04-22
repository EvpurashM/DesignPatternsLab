package creational;

// Допоміжні класи без модифікатора public (щоб помістились в один файл)
interface Product { void create(); }

class ConcreteProduct implements Product { 
    public void create() { System.out.println("Factory: Продукт успішно створено"); } 
}

// Головний публічний клас
public class Factory {
    public Product createProduct() { 
        return new ConcreteProduct(); 
    }
}