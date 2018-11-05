package drawing.ui;

import drawing.handlers.ClearButtonHandler;
import drawing.handlers.ClearSelectedButtonHandler;
import drawing.handlers.RectangleButtonHandler;
import drawing.handlers.EllipseButtonHandler;
import drawing.handlers.TriangleButtonHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


public class ToolBar extends HBox {

    private DrawingPane pane;
    private Button clearButton;
    private Button rectangleButton;
    private Button circleButton;
    private Button triangleButton;
    private Button clearSelectedButton;


    public ToolBar(DrawingPane pane){
        this.pane = pane;

        clearButton = new Button("Clear");
        clearButton.addEventFilter(ActionEvent.ACTION, new ClearButtonHandler(pane));
        rectangleButton = new Button("Rectangle");
        rectangleButton.addEventFilter(ActionEvent.ACTION, new RectangleButtonHandler(pane));
        circleButton = new Button("Circle");
        circleButton.addEventFilter(ActionEvent.ACTION, new EllipseButtonHandler(pane));
        triangleButton = new Button("Triangle");
        triangleButton.addEventFilter(ActionEvent.ACTION, new TriangleButtonHandler(pane));
        clearSelectedButton = new Button("ClearSelected");
        clearSelectedButton.addEventFilter(ActionEvent.ACTION, new ClearSelectedButtonHandler(pane));
        this.getChildren().addAll(clearButton, rectangleButton, circleButton, triangleButton, clearSelectedButton);

        this.setPadding(new Insets(5));
        this.setSpacing(5.0);
        this.getStyleClass().add("toolbar");
    }

}
