package drawing.handlers;

import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RedoButtonHandler implements EventHandler<ActionEvent> {

    private DrawingPane dPane;

    public RedoButtonHandler(DrawingPane drawingPane) {
        this.dPane = drawingPane;
    }

    @Override
    public void handle(ActionEvent arg0) {
        this.dPane.getHistory().redo();
    }

}