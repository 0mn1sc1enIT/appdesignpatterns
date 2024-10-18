import java.util.Stack;

import Command.ICommand;

public class RemoteControl {
    private ICommand lastCommand;
    private Stack<ICommand> commandHistory = new Stack<>();

    public void setCommand(ICommand command) {
        lastCommand = command;
    }

    public void pressButton() {
        lastCommand.execute();
        commandHistory.push(lastCommand);
    }

    public void pressUndo() {
        if (!commandHistory.isEmpty()) {
            ICommand commandToUndo = commandHistory.pop();
            commandToUndo.undo();
        } else {
            System.out.println("Нет команд для отмены.");
        }
    }
}