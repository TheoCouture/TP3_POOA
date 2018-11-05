package drawing;

        import javafx.scene.control.Label;
        import javafx.scene.layout.HBox;

public class StatutBar extends HBox implements Observer {

    private Label mylabel;

    private DrawingPane p;

    private SelectionHandler selectHand;

    public StatutBar(DrawingPane p){
        mylabel = new Label("0 shape - 0 selected");
        this.getChildren().addAll(mylabel);
        this.p=p;
    }

    public void update(){
        this.mylabel.setText(p.getNbShape() + " shape(s) - "+ p.getNbSelectedShape() +" selected");
    }
}
