package drawing.commands;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

import javax.swing.*;

public class MoveCommand implements ICommand {

    private DrawingPane p;
    private double OffsetX;
    private double OffsetY;

    public MoveCommand(DrawingPane pane, double OffsetX,double OffsetY ){
        this.p = pane;
        this.OffsetX = OffsetX;
        this.OffsetY = OffsetY;
    }

    public void execute(){
        for (IShape shape : this.p.getShapes() ){
            shape.offset(OffsetX,OffsetY);
        }

    }

    public void undo(){
        for (IShape shape : this.p.getShapes() ){
            shape.offset(-OffsetX,-OffsetY);
        }
    }
}
