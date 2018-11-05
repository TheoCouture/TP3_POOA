package drawing;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class SelectionHandler implements EventHandler<MouseEvent>,Observable {

    private ArrayList<IShape> iShapes ;

    private DrawingPane dp;

    private int state = 0;

    private List<Observer> observers = new ArrayList<>();

    public SelectionHandler(DrawingPane drawingPane) {
        this.dp = drawingPane;
        drawingPane.setOnMouseClicked(this);
        iShapes = new ArrayList<IShape>();

    }

    public void addObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    public void notifyObservers(){
        for(Observer obs : observers){
            obs.update();
        }
    }

    public ArrayList<IShape> getSelection(){
        return iShapes;
    }

    public Integer getNbSelection(){
        System.out.println(iShapes);
        return iShapes.size();
    }

    public void emptySelection(){
        iShapes.clear();
        notifyObservers();
        for (IShape shape : dp) {
            shape.setSelected(false);
        }
    }

    @Override
    public void handle(MouseEvent event){
        boolean formHasBeenSelected = false;
        System.out.println("Hello");
        if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED )) {

            if (!event.isControlDown()) {
                emptySelection();

            }

            for (IShape shape : dp) {
                if (shape.isOn(event.getX(), event.getY())) {
                    formHasBeenSelected = true;

                    if (iShapes.contains(shape)) {
                        iShapes.remove(shape);

                    }
                    else{
                        iShapes.add(shape);
                    }
                    notifyObservers();

                    shape.setSelected(!shape.isSelected());
                    break;
                }
            }

            if (!formHasBeenSelected){
                emptySelection();

            }
        }
    }

}
