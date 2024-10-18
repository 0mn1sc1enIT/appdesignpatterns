import Model.*;
import Command.*;

public class Main {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light light = new Light();
        Door door = new Door();
        Thermostat thermostat = new Thermostat();

        thermostat.setTemperature(25);
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);
        DoorOpenCommand doorOpen = new DoorOpenCommand(door);
        DoorCloseCommand doorClose = new DoorCloseCommand(door);

        IncreaseTemperatureCommand increaseTemp = new IncreaseTemperatureCommand(thermostat, 5);
        DecreaseTemperatureCommand decreaseTemp = new DecreaseTemperatureCommand(thermostat, 4);

        remoteControl.setCommand(lightOn);
        remoteControl.pressButton();

        remoteControl.setCommand(lightOff);
        remoteControl.pressButton();
        remoteControl.pressUndo();
        remoteControl.pressUndo();

        remoteControl.setCommand(doorOpen);
        remoteControl.pressButton();

        remoteControl.setCommand(doorClose);
        remoteControl.pressButton();
        remoteControl.pressUndo();


        remoteControl.setCommand(increaseTemp);
        remoteControl.pressButton();
        remoteControl.pressUndo();

        remoteControl.setCommand(decreaseTemp);
        remoteControl.pressButton();
        remoteControl.pressUndo();
    }
}