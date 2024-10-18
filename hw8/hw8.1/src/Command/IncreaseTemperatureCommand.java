package Command;

import Model.Thermostat;

public class IncreaseTemperatureCommand implements ICommand {
    private Thermostat thermostat;
    private int temperature;

    public IncreaseTemperatureCommand(Thermostat thermostat, int temperature) {
        this.thermostat = thermostat;
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        thermostat.increaseTemperature(temperature);
    }

    @Override
    public void undo() {
        thermostat.decreaseTemperature(temperature);
    }
}