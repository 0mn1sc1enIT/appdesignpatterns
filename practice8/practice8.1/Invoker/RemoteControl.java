package Invoker;

import java.util.Stack;
import Command.ICommand;

public class RemoteControl {
    private ICommand[] onCommands;
    private ICommand[] offCommands;
    private Stack<ICommand> commandHistory;

    public RemoteControl() {
        onCommands = new ICommand[7];
        offCommands = new ICommand[7];
        commandHistory = new Stack<>();
    }

    public void setCommand(int slot, ICommand onCommand, ICommand offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonPressed(int slot) {
        if (onCommands[slot] != null) {
            onCommands[slot].execute();
            commandHistory.push(onCommands[slot]);
        } else {
            System.out.println("Команда для слота не назначена.");
        }
    }

    public void offButtonPressed(int slot) {
        if (offCommands[slot] != null) {
            offCommands[slot].execute();
            commandHistory.push(offCommands[slot]);
        } else {
            System.out.println("Команда не назначена.");
        }
    }

    public void undoButtonPressed() {
        if (!commandHistory.isEmpty()) {
            ICommand lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("Нет команд для отмены.");
        }
    }
}

