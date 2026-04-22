package structural;
import java.util.ArrayList;
import java.util.List;

interface Component { void showDetails(); }

class Leaf implements Component {
    String name;
    public Leaf(String name) { this.name = name; }
    public void showDetails() { System.out.println(" - Файл: " + name); }
}

class Composite implements Component {
    String name;
    List<Component> components = new ArrayList<>();
    public Composite(String name) { this.name = name; }
    public void addComponent(Component com) { components.add(com); }
    public void showDetails() {
        System.out.println("Компонувальник (Composite): Папка " + name);
        for (Component c : components) { c.showDetails(); }
    }
}

public class CompositePattern {
    public static void run() {
        Composite folder = new Composite("Документи");
        folder.addComponent(new Leaf("Звіт.pdf"));
        folder.addComponent(new Leaf("Фото.jpg"));
        folder.showDetails();
    }
}