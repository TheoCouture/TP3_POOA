package drawing.shapes;

import drawing.ui.DrawingPane;

import java.util.ArrayList;

public class ShapeComposite implements IShape{
    private ArrayList<IShape> groupIShape;

    public ShapeComposite(){
        groupIShape = new ArrayList<>();
    }

    public void addshape(IShape newIShape){
        groupIShape.add(newIShape);
    }


    public ArrayList<IShape> getshapes(){
        return groupIShape;
    }

    public void offset(double x, double y){
        for (IShape o : groupIShape){
            o.offset(x,y);
        }
   }

    public void addShapeToPane(DrawingPane p){
        for (IShape o : groupIShape){
            o.addShapeToPane(p);
        }
    }
    public void removeShapeFromPane(DrawingPane p){
        for (IShape o : groupIShape){
            o.removeShapeFromPane(p);
        }
    }

    public boolean isOn(double x,double y){
        for (IShape o : groupIShape){
            if (o.isOn(x,y))
                return true;
        }
        return false;
    }

    public void setSelected(boolean isSelected){
        for (IShape o : groupIShape){
            o.setSelected(isSelected);
        }
    }

    public boolean isSelected(){
        for (IShape o : groupIShape){
            if (o.isSelected())
                return true;
        }
        return false;
    }
}
