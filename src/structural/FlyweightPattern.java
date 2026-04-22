package structural;
import java.util.HashMap;

class TreeType {
    private String name;
    public TreeType(String name) { 
        this.name = name; 
        System.out.println(" [Створено новий тип дерева: " + name + "]");
    }
    public void plant(int x, int y) { 
        System.out.println("Легковаговик (Flyweight): Садимо " + name + " на координатах " + x + "," + y); 
    }
}

class TreeFactory {
    private static final HashMap<String, TreeType> treeMap = new HashMap<>();
    public static TreeType getTreeType(String name) {
        TreeType type = treeMap.get(name);
        if (type == null) {
            type = new TreeType(name);
            treeMap.put(name, type);
        }
        return type;
    }
}

public class FlyweightPattern {
    public static void run() {
        TreeType oak1 = TreeFactory.getTreeType("Дуб");
        oak1.plant(10, 20);
        TreeType oak2 = TreeFactory.getTreeType("Дуб"); // Перевикористання об'єкту
        oak2.plant(30, 40);
    }
}