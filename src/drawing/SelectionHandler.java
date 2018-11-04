package drawing;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class SelectionHandler implements EventHandler<MouseEvent> {

    private ArrayList<IShape> iShapes ;

    private DrawingPane dp;

    public SelectionHandler(DrawingPane drawingPane) {
        this.dp = drawingPane;
        drawingPane.setOnMouseClicked(this);
        iShapes = new ArrayList<IShape>();

    }

    public ArrayList<IShape> getSelection(){
        return iShapes;
    }

    public void emptySelection(){
        iShapes.clear();
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

                    if (iShapes.contains(shape))
                        iShapes.remove(shape);
                    else
                        iShapes.add(shape);

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
