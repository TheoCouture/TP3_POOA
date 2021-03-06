package drawing.handlers;

import drawing.commands.DegroupCommand;
import drawing.commands.ICommand;
import drawing.shapes.IShape;
import drawing.shapes.ShapeComposite;
import drawing.ui.DrawingPane;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class DisassociateButtonHandler implements EventHandler {
    private DrawingPane pane;
    private ICommand command;

    public DisassociateButtonHandler(DrawingPane pane){
        this.pane = pane;
    }
    @Override
    public void handle(Event event) {

        /*ArrayList<IShape> selectedShape = this.pane.getSelectedShape();


        for (IShape o : selectedShape){
            if (o instanceof ShapeComposite )
            {
                this.pane.removeShape(o);
                for (IShape i : ((ShapeComposite) o).getshapes()){
                    this.pane.addShape(i);
                }
            }

        }*/

        this.command = new DegroupCommand(pane);
        this.pane.getHistory().exec(command);


    }
}
