package drawing.handlers;

import drawing.commands.ICommand;
import drawing.commands.ShapeCommand;
import drawing.ui.DrawingPane;
import drawing.shapes.IShape;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

/**
 * Created by lewandowski on 20/12/2017.
 */
public abstract class ShapeButtonHandler implements EventHandler<Event> {

    private DrawingPane drawingPane;
    private ICommand command;
    protected double originX;
    protected double originY;
    protected double destinationX;
    protected double destinationY;

    protected IShape shape;

    public ShapeButtonHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
    }

    @Override
    public void handle(Event event) {

        if (event instanceof ActionEvent) {
            drawingPane.addEventHandler(MouseEvent.MOUSE_PRESSED, this);
        }

        if (event instanceof MouseEvent) {
            if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
                drawingPane.addEventHandler(MouseEvent.MOUSE_RELEASED, this);
                originX = ((MouseEvent) event).getX();
                originY = ((MouseEvent) event).getY();
            }

            if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
                destinationX = ((MouseEvent) event).getX();
                destinationY = ((MouseEvent) event).getY();
                shape = createShape();
                //drawingPane.addShape(shape);
                //drawingPane.getShapes().add(shape);

                this.command = new ShapeCommand(drawingPane, shape);
                this.drawingPane.getHistory().exec(command);

                drawingPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, this);
                drawingPane.removeEventHandler(MouseEvent.MOUSE_RELEASED, this);
            }
        }
    }

    protected abstract IShape createShape();

}
