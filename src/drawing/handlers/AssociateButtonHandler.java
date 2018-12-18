package drawing.handlers;

import drawing.commands.DegroupCommand;
import drawing.commands.GroupCommand;
import drawing.commands.ICommand;
import drawing.shapes.IShape;
import drawing.shapes.ShapeComposite;
import drawing.ui.DrawingPane;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class AssociateButtonHandler implements EventHandler {
    private DrawingPane pane;
    private ICommand command;

    public AssociateButtonHandler(DrawingPane pane){
        this.pane = pane;
    }
    @Override
    public void handle(Event event) {
        /*ArrayList<IShape> selectedShape = this.pane.getSelectedShape();

        ShapeComposite shapeComposite = new ShapeComposite();
        for (IShape o : selectedShape){
            shapeComposite.addshape(o);
        }
        this.pane.clearShape(selectedShape);
        this.pane.addShape(shapeComposite);*/

        this.command = new GroupCommand(pane);
        this.pane.getHistory().exec(command);


    }
}
