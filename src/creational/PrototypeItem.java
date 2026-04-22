package creational;

public class PrototypeItem implements Cloneable {
    public void display() { 
        System.out.println("Prototype: Це клонований об'єкт"); 
    }
    
    @Override
    public PrototypeItem clone() {
        try {
            return (PrototypeItem) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}