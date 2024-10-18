package Command;

import Model.AirConditioner;

public class AirConditionerOffCommand implements ICommand {
    private AirConditioner airConditioner;

    public AirConditionerOffCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    public void execute() {
        airConditioner.off();
    }

    public void undo() {
        airConditioner.on();
    }
}
