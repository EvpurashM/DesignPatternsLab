package behavioral;

interface Command { void execute(); }
class Light { public void turnOn() { System.out.println("Світло увімкнено."); } }

class TurnOnLightCommand implements Command {
    private Light light;
    public TurnOnLightCommand(Light light) { this.light = light; }
    public void execute() { light.turnOn(); }
}

public class CommandPattern {
    public static void run() {
        Light lamp = new Light();
        Command switchOn = new TurnOnLightCommand(lamp);
        switchOn.execute();
    }
}