package drawing.handlers;

import drawing.commands.ClearCommand;
import drawing.commands.ICommand;
import drawing.ui.DrawingPane;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ClearButtonHandler implements EventHandler {

    private ICommand command;
    private DrawingPane pane;

    public ClearButtonHandler(DrawingPane pane){
        this.pane = pane;
    }
    @Override
    public void handle(Event event) {
        //this.pane.clear();
        this.command = new ClearCommand(pane);
        this.pane.getHistory().exec(command);
    }
}
