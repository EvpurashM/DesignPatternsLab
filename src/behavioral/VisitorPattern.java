package behavioral;

interface ComputerPart { void accept(ComputerPartVisitor computerPartVisitor); }

class Keyboard implements ComputerPart {
    public void accept(ComputerPartVisitor visitor) { visitor.visit(this); }
}

interface ComputerPartVisitor { void visit(Keyboard keyboard); }

class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    public void visit(Keyboard keyboard) { System.out.println("Відвідувач: перевіряємо клавіатуру."); }
}

public class VisitorPattern {
    public static void run() {
        ComputerPart keyboard = new Keyboard();
        keyboard.accept(new ComputerPartDisplayVisitor());
    }
}