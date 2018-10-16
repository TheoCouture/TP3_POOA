package drawing;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class MouseMoveHandler implements EventHandler<MouseEvent> {

    private DrawingPane drawingPane;

    private double orgSceneX;
    private double orgSceneY;
    private double orgTranslateX;
    private double orgTranslateY;

    private IShape selectedShape;

    public MouseMoveHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
        drawingPane.setOnMousePressed(this);
        drawingPane.setOnMouseDragged(this);
        drawingPane.setOnMouseReleased(this);
    }

    @Override
    public void handle(MouseEvent event) {

        if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {

            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();


            for (IShape shape : drawingPane) {
                /*if (shape.getBoundsInParent().contains(event.getX(), event.getY())) {
                    selectedShape = shape;
                    break;
                }*/
                if (shape.isOn(event.getX(), event.getY())) {
                    selectedShape = shape;
                    selectedShape.setSelected(true);
                    break;
                }
            }

            //orgTranslateX = selectedShape == null ? 0 : selectedShape.getTranslateX();
            //orgTranslateY = selectedShape == null ? 0 : selectedShape.getTranslateY();


        }

        if (event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
            if (selectedShape == null)
                return;


            double offsetX = event.getSceneX() - orgSceneX;
            double offsetY = event.getSceneY() - orgSceneY;

            selectedShape.offset(offsetX,offsetY);

            orgSceneX += offsetX;
            orgSceneY += offsetY;

            //double newTranslateX = orgTranslateX + offsetX;
            //double newTranslateY = orgTranslateY + offsetY;

            //selectedShape.setTranslateX(newTranslateX);
            //selectedShape.setTranslateY(newTranslateY);
        }

        if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
            if (selectedShape == null)
                return;
            
            if (selectedShape.isSelected())
                selectedShape.setSelected(false);
            selectedShape = null;
        }
    }
}
