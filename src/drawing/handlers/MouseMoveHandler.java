package drawing.handlers;

import drawing.commands.ICommand;
import drawing.commands.MoveCommand;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class MouseMoveHandler implements EventHandler<MouseEvent> {

    private DrawingPane drawingPane;

    private double orgSceneX;
    private double orgSceneY;
    private double offsetX;
    private double offsetY;
    private double totalOffsetX;
    private double totalOffsetY;

    private IShape selectedShape;
    private ICommand command;

    public MouseMoveHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;

        drawingPane.setOnMousePressed(this);
        drawingPane.setOnMouseDragged(this);
        drawingPane.setOnMouseReleased(this);
    }

    @Override
    public void handle(MouseEvent event) {

        ArrayList<IShape> selectedShapes = drawingPane.getSelection();

        if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {

            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();


            totalOffsetX = 0;
            totalOffsetY = 0;




            /*for (IShape shape : drawingPane) {
                //if (shape.getBoundsInParent().contains(event.getX(), event.getY())) {
                    //selectedShape = shape;
                    //break;
                //}
                if (shape.isOn(event.getX(), event.getY())) {
                    selectedShape = shape;
                    selectedShape.setSelected(true);
                    break;
                }
            }*/

            //orgTranslateX = selectedShape == null ? 0 : selectedShape.getTranslateX();
            //orgTranslateY = selectedShape == null ? 0 : selectedShape.getTranslateY();

        }

        if (event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {

            offsetX = event.getSceneX() - orgSceneX;
            offsetY = event.getSceneY() - orgSceneY;

            /*for( IShape selectedShape : selectedShapes ) {
                if (selectedShape == null)
                    return;



                selectedShape.offset(offsetX, offsetY);

            }*/

            for(IShape shape : selectedShapes)
                shape.offset(offsetX, offsetY);

            totalOffsetX += offsetX;
            totalOffsetY += offsetY;

            orgSceneX += offsetX;
            orgSceneY += offsetY;




        }

        if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {


            this.command = new MoveCommand(drawingPane, totalOffsetX, totalOffsetY);
            for(IShape shape : selectedShapes)
                shape.offset(-totalOffsetX, -totalOffsetY);
            this.drawingPane.getHistory().exec(command);


        }
    }
}
