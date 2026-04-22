package creational;

class House {
    private String walls;
    public void setWalls(String walls) { this.walls = walls; }
    public void show() { System.out.println("Builder: Побудовано будинок. Стіни: " + walls); }
}

public class Builder {
    private House house = new House();
    
    public Builder buildWalls() { 
        house.setWalls("Цегляні"); 
        return this; 
    }
    
    public House getResult() { 
        return house; 
    }
}