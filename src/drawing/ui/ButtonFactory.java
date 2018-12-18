package drawing.ui;

import drawing.handlers.ClearButtonHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonFactory {

    private int option;
    public static final String[] DELETEALL =  new String[] {"Clear","../images/deleteall.png"};
    public static final String[] CIRCLE =  new String[] {"Circle","../images/round.png"};
    public static final String[] SQUARE = new String[] {"Rectangle","../images/square.png"};
    public static final String[] TRIANGLE = new String[] {"Triangle","../images/triangle.png"};
    public static final String[] CLEARSELECT = new String[] {"Clear Select","../images/clearselect.png"};
    public static final String[] ASSOCIATE = new String[] {"Associate","../images/clearselect.png"};
    public static final String[] DISASSOCIATE = new String[] {"Disassociate","../images/clearselect.png"};
    public static final String[] REDO = new String[] {"Redo","../images/redo.png"};
    public static final String[] UNDO = new String[] {"Undo","../images/undo.png"};
    public static final int ICONSONLY = 0;
    public static final int TEXTONLY = 1;



    public ButtonFactory(int option){
        this.option= option;
    }

    public Button createButton(String[] buttonName){

        Button tempbutton = null;
        ImageView imageView = null;


        switch (option){
            case ICONSONLY:
                    imageView = new ImageView(new Image(getClass().getResourceAsStream(buttonName[1])));
                    tempbutton = new Button(null,imageView);
                break;
            case TEXTONLY:
                    tempbutton = new Button(buttonName[0]);
                break;

            default:
                tempbutton = new Button(buttonName[0]);
                break;

        }




        return tempbutton;

    }
}
