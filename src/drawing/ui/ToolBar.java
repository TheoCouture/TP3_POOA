package drawing.ui;

import drawing.handlers.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


public class ToolBar extends HBox {

    private DrawingPane pane;
    private Button clearButton;
    private Button rectangleButton;
    private Button circleButton;
    private Button triangleButton;
    private Button clearSelectedButton;
    private Button associateButton;
    private Button disassociateButton;
    private ButtonFactory bf;


    public ToolBar(DrawingPane pane){
        this.pane = pane;
        this.bf = new ButtonFactory(ButtonFactory.TEXTONLY);


        clearButton = bf.createButton(ButtonFactory.DELETEALL);
        clearButton.addEventFilter(ActionEvent.ACTION, new ClearButtonHandler(pane));
        rectangleButton = bf.createButton(ButtonFactory.SQUARE);
        rectangleButton.addEventFilter(ActionEvent.ACTION, new RectangleButtonHandler(pane));
        circleButton = bf.createButton(ButtonFactory.CIRCLE);
        circleButton.addEventFilter(ActionEvent.ACTION, new EllipseButtonHandler(pane));
        triangleButton = bf.createButton(ButtonFactory.TRIANGLE);
        triangleButton.addEventFilter(ActionEvent.ACTION, new TriangleButtonHandler(pane));


        associateButton = bf.createButton(ButtonFactory.ASSOCIATE);
        associateButton.addEventFilter(ActionEvent.ACTION, new AssociateButtonHandler(pane));

        disassociateButton = bf.createButton(ButtonFactory.DISASSOCIATE);
        disassociateButton.addEventFilter(ActionEvent.ACTION, new DisassociateButtonHandler(pane));

        clearSelectedButton = bf.createButton(ButtonFactory.CLEARSELECT);
        clearSelectedButton.addEventFilter(ActionEvent.ACTION, new ClearSelectedButtonHandler(pane));
        this.getChildren().addAll(clearButton, rectangleButton, circleButton, triangleButton, clearSelectedButton,associateButton,disassociateButton);

        this.setPadding(new Insets(5));
        this.setSpacing(5.0);
        this.getStyleClass().add("toolbar");
    }

}
