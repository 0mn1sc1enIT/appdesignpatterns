import Invoker.*;
import Model.*;
import Command.*;

public class Main {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light();
        AirConditioner airConditioner = new AirConditioner();
        TV tv = new TV();

        ICommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        ICommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        ICommand airConditionerOn = new AirConditionerOnCommand(airConditioner);
        ICommand airConditionerOff = new AirConditionerOffCommand(airConditioner);
        ICommand tvOn = new TVOnCommand(tv);
        ICommand tvOff = new TVOffCommand(tv);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, airConditionerOn, airConditionerOff);
        remoteControl.setCommand(2, tvOn, tvOff);

        remoteControl.onButtonPressed(0);
        remoteControl.offButtonPressed(0);
        remoteControl.onButtonPressed(1);
        remoteControl.offButtonPressed(1);

        remoteControl.undoButtonPressed();

        ICommand[] commands = {livingRoomLightOn, airConditionerOn, tvOn};
        MacroCommand partyMacro = new MacroCommand(commands);

        System.out.println("Выполнение макрокоманды");
        partyMacro.execute();

        System.out.println("Отмена макрокоманды");
        partyMacro.undo();
    }
}
