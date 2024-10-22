import java.util.ArrayList;

public class Command {
    public interface ICommand {
        void Execute();
        void Undo();
    }

    public class Light {
        public void On() {
            System.out.println("Свет включен");
        }

        public void Off() {
            System.out.println("Свет выключен");
        }
    }

    public class LightOnCommand implements ICommand {
        private Light light;
        public LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void Execute() {
            this.light.On();
        }

        @Override
        public void Undo() {
            this.light.Off();
        }
    }

    public class LightOffCommand implements ICommand {
        private Light light;
        public LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void Execute() {
            this.light.Off();
        }

        @Override
        public void Undo() {
            this.light.On();
        }
    }

    public class Television {
        public void On() {
            System.out.println("Телевизор включен");
        }

        public void Off() {
            System.out.println("Телевизор выключен");
        }
    }

    public class TelevisionOnCommand implements ICommand {
        private Television tv;
        public TelevisionOnCommand(Television tv) {
            this.tv = tv;
        }

        @Override
        public void Execute() {
            this.tv.On();
        }

        @Override
        public void Undo() {
            this.tv.Off();
        }
    }

    public class TelevisionOffCommand implements ICommand {
        private Television tv;
        public TelevisionOffCommand(Television tv) {
            this.tv = tv;
        }

        @Override
        public void Execute() {
            this.tv.Off();
        }

        @Override
        public void Undo() {
            this.tv.On();
        }
    }

    public class AirConditioner {
        public void On() {
            System.out.println("Кондиционер включен");
        }

        public void Off() {
            System.out.println("Кондиционер выключен");
        }

        public void SetEcoMode() {
            System.out.println("Кондиционер переведен в режим экономии энергии");
        }

        public void UndoEcoMode() {
            System.out.println("Кондиционер переведет в нормальный режим");
        }
    }

    public class AirConditionerOnCommand implements ICommand {
        private AirConditioner airConditioner;
        public AirConditionerOnCommand(AirConditioner airConditioner) {
            this.airConditioner = airConditioner;
        }

        @Override
        public void Execute() {
            this.airConditioner.On();
        }

        @Override
        public void Undo() {
            this.airConditioner.Off();
        }
    }

    public class AirConditionerOffCommand implements ICommand {
        private AirConditioner airConditioner;
        public AirConditionerOffCommand(AirConditioner airConditioner) {
            this.airConditioner = airConditioner;
        }

        @Override
        public void Execute() {
            this.airConditioner.Off();
        }

        @Override
        public void Undo() {
            this.airConditioner.On();
        }
    }

    class AirConditionerEcoModeOnCommand implements ICommand {
        private AirConditioner airConditioner;

        public AirConditionerEcoModeOnCommand(AirConditioner airConditioner) {
            this.airConditioner = airConditioner;
        }

        public void Execute() {
            this.airConditioner.SetEcoMode();
        }

        public void Undo() {
            this.airConditioner.UndoEcoMode();
        }
    }

    class AirConditionerEcoModeOffCommand implements ICommand {
        private AirConditioner airConditioner;

        public AirConditionerEcoModeOffCommand(AirConditioner airConditioner) {
            this.airConditioner = airConditioner;
        }

        public void Execute() {
            this.airConditioner.UndoEcoMode();
        }

        public void Undo() {
            this.airConditioner.SetEcoMode();
        }
    }

    class MacroCommand implements ICommand {
        private ICommand[] commands;

        public MacroCommand(ICommand[] commands) {
            this.commands = commands;
        }

        public void Execute() {
            for (ICommand command : commands) {
                command.Execute();
            }
        }

        public void Undo() {
            for (int i = commands.length - 1; i >= 0; i--) {
                commands[i].Undo();
            }
        }
    }

    class RemoteControl {
        private ArrayList<ICommand> onCommands;
        private ArrayList<ICommand> offCommands;
        private ICommand undoCommand;

        public RemoteControl() {
            onCommands = new ArrayList<>();
            offCommands = new ArrayList<>();
            undoCommand = null;
        }

        public void setCommand(int slot, ICommand onCommand, ICommand offCommand) {
            ensureSlotSize(slot);

            onCommands.set(slot, onCommand);
            offCommands.set(slot, offCommand);
        }

        public void onButtonWasPressed(int slot) {
            if (onCommands.get(slot) != null) {
                onCommands.get(slot).Execute();
                undoCommand = onCommands.get(slot);
            }
        }

        public void offButtonWasPressed(int slot) {
            if (offCommands.get(slot) != null) {
                offCommands.get(slot).Execute();
                undoCommand = offCommands.get(slot);
            }
        }

        public void undoButtonWasPressed() {
            if (undoCommand != null) {
                undoCommand.Undo();
            }
        }

        private void ensureSlotSize(int slot) {
            while (onCommands.size() <= slot) {
                onCommands.add(null);
                offCommands.add(null);
            }
        }
    }


    public void main(String[] args) {
        RemoteControl remote = new RemoteControl();

        Light light = new Light();
        Television tv = new Television();
        AirConditioner ac = new AirConditioner();

        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        TelevisionOnCommand tvOn = new TelevisionOnCommand(tv);
        TelevisionOffCommand tvOff = new TelevisionOffCommand(tv);

        AirConditionerOnCommand acOn = new AirConditionerOnCommand(ac);
        AirConditionerOffCommand acOff = new AirConditionerOffCommand(ac);
        AirConditionerEcoModeOnCommand acEcoModeOn = new AirConditionerEcoModeOnCommand(ac);
        AirConditionerEcoModeOffCommand acEcoModeOff = new AirConditionerEcoModeOffCommand(ac);

        remote.setCommand(0, lightOn, lightOff);
        remote.setCommand(1, tvOn, tvOff);
        remote.setCommand(2, acOn, acOff);
        remote.setCommand(3, acEcoModeOn, acEcoModeOff);

        System.out.println("Тестирование света:");
        remote.onButtonWasPressed(0);
        remote.offButtonWasPressed(0);
        remote.undoButtonWasPressed();

        System.out.println("\nТестирование телевизора:");
        remote.onButtonWasPressed(1);
        remote.offButtonWasPressed(1);
        remote.undoButtonWasPressed();

        System.out.println("\nТестирование кондиционера:");
        remote.onButtonWasPressed(2);
        remote.offButtonWasPressed(2);
        remote.onButtonWasPressed(3);
        remote.offButtonWasPressed(3);
        remote.undoButtonWasPressed();

        System.out.println("\nТестирование макрокоманды:");
        ICommand[] macro = {lightOn, tvOn, acOn};
        MacroCommand partyMacro = new MacroCommand(macro);
        partyMacro.Execute();

        System.out.println("\nОтмена макрокоманды:");
        partyMacro.Undo();
    }
}