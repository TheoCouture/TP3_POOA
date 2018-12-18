package drawing.commands;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class ShapeCommand implements ICommand {

    private DrawingPane p;
    private IShape shape;

    public ShapeCommand(DrawingPane pane, IShape shape) {
        this.p = pane;
        this.shape = shape;
    }

    @Override
    public void execute() {
        p.addShape(shape);
    }

    @Override
    public void undo() {
        p.removeShape(shape);
    }

}