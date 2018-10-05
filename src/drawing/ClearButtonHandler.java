package drawing;

import javafx.event.Event;
import javafx.event.EventHandler;

public class ClearButtonHandler implements EventHandler {

    private DrawingPane pane;

    public ClearButtonHandler(DrawingPane pane){
        this.pane = pane;
    }
    @Override
    public void handle(Event event) {
        this.pane.clear();
    }
}
