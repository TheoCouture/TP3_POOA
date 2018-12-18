package drawing.commands;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

import java.util.ArrayList;

public class ClearCommand implements ICommand{

    private DrawingPane pane;
    private ArrayList<IShape> iShapesSaves;

    public ClearCommand(DrawingPane p){
        this.pane = p;
    }

    public void undo(){
        for (IShape shape : iShapesSaves){
            this.pane.addShape(shape);
        }

    }

    public void execute(){
        iShapesSaves = new ArrayList<>();
        for (IShape shape : this.pane.getShapes()){
            iShapesSaves.add(shape);
        }
        this.pane.clear();

    }
}
