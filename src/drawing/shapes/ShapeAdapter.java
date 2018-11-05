package drawing.shapes;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.scene.shape.Shape;

public class ShapeAdapter implements IShape {

    private Shape shape;

    private boolean isSelected;

    public ShapeAdapter(Shape myshape) {
        this.shape = myshape;
    }

    @Override
    public void addShapeToPane(DrawingPane p) {
        p.getChildren().add(shape);
    }

    @Override
    public void removeShapeFromPane(DrawingPane p) {
        p.getChildren().remove(shape);
    }

    @Override
    public boolean isOn(double x, double y) {
        return shape.getBoundsInParent().contains(x, y);
    }

    @Override
    public void offset(double x, double y) {
        shape.setTranslateX(shape.getTranslateX()+x);
        shape.setTranslateY(shape.getTranslateY()+y);

    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public void setSelected(boolean isSelected){
        if (isSelected)
            shape.getStyleClass().add("selected");
        else
            shape.getStyleClass().remove("selected");
        this.isSelected = isSelected;
    }
}
