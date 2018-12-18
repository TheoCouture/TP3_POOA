package drawing.commands;

import java.util.Stack;

public class CommandHistory {
    private Stack<ICommand> undos;
    private Stack<ICommand> redos;

    public CommandHistory() {
        this.undos = new Stack<>();
        this.redos = new Stack<>();
    }

    public void exec(ICommand command) {
        command.execute();
        this.undos.push(command);
        this.redos.clear();
    }

    public void undo() {
        if(this.undos.isEmpty())
            return;
        ICommand command = this.undos.pop();
        command.undo();
        redos.push(command);
    }

    public void redo() {
        if(this.redos.isEmpty())
            return;
        ICommand command = this.redos.pop();
        command.execute();
        this.undos.push(command);
    }
}