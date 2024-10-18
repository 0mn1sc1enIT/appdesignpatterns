package Command;

public class MacroCommand implements ICommand {
    private ICommand[] commands;

    public MacroCommand(ICommand[] commands) {
        this.commands = commands;
    }

    public void execute() {
        for (ICommand command : commands) {
            command.execute();
        }
    }

    public void undo() {
        for (ICommand command : commands) {
            command.undo();
        }
    }
}
