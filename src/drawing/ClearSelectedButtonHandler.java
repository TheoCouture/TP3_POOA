package drawing;

import javafx.event.Event;
import javafx.event.EventHandler;

public class ClearSelectedButtonHandler  implements EventHandler {

    private DrawingPane pane;

    public ClearSelectedButtonHandler(DrawingPane pane){
        this.pane = pane;
    }
    @Override
    public void handle(Event event) {
        this.pane.clearShape(this.pane.getSelectedShape());

    }
}
