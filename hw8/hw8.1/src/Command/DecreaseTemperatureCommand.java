package Command;

import Model.Thermostat;

public class DecreaseTemperatureCommand implements ICommand {
    private Thermostat thermostat;
    private int temperature;

    public DecreaseTemperatureCommand(Thermostat thermostat, int temperature) {
        this.thermostat = thermostat;
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        thermostat.decreaseTemperature(temperature);
    }

    @Override
    public void undo() {
        thermostat.increaseTemperature(temperature);
    }
}