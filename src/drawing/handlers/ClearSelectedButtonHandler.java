package drawing.handlers;

import drawing.commands.ClearCommand;
import drawing.commands.ClearSelectedCommand;
import drawing.commands.DegroupCommand;
import drawing.commands.ICommand;
import drawing.ui.DrawingPane;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ClearSelectedButtonHandler  implements EventHandler {

    private DrawingPane pane;
    private ICommand command;

    public ClearSelectedButtonHandler(DrawingPane pane){
        this.pane = pane;
    }
    @Override
    public void handle(Event event) {
        //this.pane.clearShape(this.pane.getSelectedShape());

        this.command = new ClearSelectedCommand(pane);
        this.pane.getHistory().exec(command);

    }
}
