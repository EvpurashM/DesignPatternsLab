package structural;

interface Color { void fill(); }
class Red implements Color { public void fill() { System.out.print("червоним кольором"); } }

abstract class Shape {
    protected Color color;
    public Shape(Color c) { this.color = c; }
    abstract public void draw();
}

class Circle extends Shape {
    public Circle(Color c) { super(c); }
    public void draw() {
        System.out.print("Міст (Bridge): Малюємо коло ");
        color.fill();
        System.out.println();
    }
}

public class BridgePattern {
    public static void run() {
        Shape circle = new Circle(new Red());
        circle.draw();
    }
}