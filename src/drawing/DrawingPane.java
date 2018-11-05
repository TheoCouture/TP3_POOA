package drawing;

import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class DrawingPane extends Pane implements Iterable<IShape>,Observable {

    private List<Observer> observers = new ArrayList<>();
    private int state = 0;

    private MouseMoveHandler mouseMoveHandler;

    private SelectionHandler selectHandler;

    private ArrayList<IShape> shapes;

    public DrawingPane() {
        clipChildren();
        shapes = new ArrayList<>();
        mouseMoveHandler = new MouseMoveHandler(this);
        selectHandler = new SelectionHandler(this);
    }


    /**
     * Clips the children of this {@link Region} to its current size.
     * This requires attaching a change listener to the region’s layout bounds,
     * as JavaFX does not currently provide any built-in way to clip children.
     */
    void clipChildren() {
        final Rectangle outputClip = new Rectangle();
        this.setClip(outputClip);

        this.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
        });
    }

    public void addShape(IShape shape) {
        shapes.add(shape);
        //
        shape.addShapeToPane(this);
        notifyObservers();
    }

  /*  public ArrayList<Shape> getShapes() {
        return shapes;
    }*/

    public void clear() {
        for (IShape shap : shapes){
            shap.removeShapeFromPane(this);
        }
        shapes.clear();
        notifyObservers();
    }

    public void clearShape(ArrayList<IShape> shapes){
        for (IShape shape : shapes) {
            shape.removeShapeFromPane(this);
            this.shapes.remove(shape);
        }
        selectHandler.emptySelection();
        notifyObservers();

    }

    public Integer getNbShape(){
        return shapes.size();
    }

    public Integer getNbSelectedShape(){return selectHandler.getNbSelection(); }

    public ArrayList<IShape> getSelectedShape(){return selectHandler.getSelection();}

    public ArrayList<IShape> getSelection() { return selectHandler.getSelection();}

    @Override
    public Iterator<IShape> iterator() {
        return shapes.iterator();
    }

    public void addObserver(Observer o) {
        observers.add(o);
        selectHandler.addObserver(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    public void notifyObservers(){
        for(Observer obs : observers)
            obs.update();
    }
}
