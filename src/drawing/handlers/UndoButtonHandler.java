package drawing.handlers;

import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UndoButtonHandler implements EventHandler<ActionEvent> {

    private DrawingPane dPane;

    public UndoButtonHandler(DrawingPane dPane) {
        this.dPane = dPane;
    }

    @Override
    public void handle(ActionEvent arg0) {
        this.dPane.getHistory().undo();
    }

}