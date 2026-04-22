package creational;

interface Button { void paint(); }
interface GUIFactory { Button createButton(); }

class WinButton implements Button {
    public void paint() { System.out.println("Abstract Factory: Намальовано кнопку в стилі Windows"); }
}

public class AbstractFactoryDemo implements GUIFactory {
    public Button createButton() { 
        return new WinButton(); 
    }
}