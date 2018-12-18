package drawing.commands;

import drawing.shapes.IShape;
import drawing.shapes.ShapeComposite;
import drawing.ui.DrawingPane;

import java.util.ArrayList;

public class GroupCommand implements ICommand {

    private DrawingPane p;
    private ShapeComposite composite;

    public GroupCommand(DrawingPane pane){
        this.p = pane;

    }

    public void undo(){

        this.p.removeShape(composite);
        for (IShape i : ((ShapeComposite) composite).getshapes()){
            this.p.addShape(i);
        }

    }

    public void execute(){
        ArrayList<IShape> selectedShapes = this.p.getSelectedShape();

        ShapeComposite shapeComposite = new ShapeComposite();
        for (IShape o : selectedShapes){
            shapeComposite.addshape(o);
        }
        this.p.clearShape(selectedShapes);
        composite = shapeComposite;
        this.p.addShape(shapeComposite);


    }
}
