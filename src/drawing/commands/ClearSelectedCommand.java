package drawing.commands;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

import java.util.ArrayList;

public class ClearSelectedCommand implements ICommand{

    private DrawingPane p;
    private ArrayList<IShape> iShapes;

    public ClearSelectedCommand(DrawingPane pane){
        this.p = pane;

    }

    public void undo(){
        for (IShape shape : iShapes){
            this.p.addShape(shape);
        }


    }

    public void execute(){
        iShapes = new ArrayList<>();
        iShapes = this.p.getSelectedShape();
        this.p.clearShape(iShapes);
    }
}
