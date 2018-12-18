package drawing.commands;

import drawing.shapes.IShape;
import drawing.shapes.ShapeComposite;
import drawing.ui.DrawingPane;

import java.util.ArrayList;

public class DegroupCommand implements ICommand {

    private DrawingPane p;
    private ArrayList<IShape> selectedShape;

    public DegroupCommand (DrawingPane pane){
        this.p = pane;
    }

    public void undo(){
        this.p.clearShape(this.p.getSelectedShape());
        for (IShape iShape : selectedShape){
            this.p.addShape(iShape);
        }
    }

    public void execute(){
        selectedShape = this.p.getSelectedShape();


        for (IShape o : selectedShape){
            if (o instanceof ShapeComposite)
            {
                this.p.removeShape(o);
                for (IShape i : ((ShapeComposite) o).getshapes()){
                    this.p.addShape(i);
                }
            }

        }
    }
}
