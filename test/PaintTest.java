import drawing.PaintApplication;
import drawing.shapes.IShape;
import drawing.shapes.ShapeAdapter;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.util.Iterator;

import static org.junit.Assert.*;

public class PaintTest extends ApplicationTest {

    PaintApplication app;

    @Override
    public void start(Stage stage) {
        try {
            app = new PaintApplication();
            app.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_draw_circle_programmatically() {
        interact(() -> {
                    app.getDrawingPane().addShape(new ShapeAdapter(new Ellipse(20, 20, 30, 30)));
                });
        Iterator it = app.getDrawingPane().iterator();
        assertTrue(it.next() instanceof IShape);
        assertFalse(it.hasNext());
    }

    @Test
    public void should_draw_circle() {
        // given:
        clickOn("Circle");
        moveBy(60,60);

        // when:
        drag().dropBy(30,30);
        //press(MouseButton.PRIMARY); moveBy(30,30); release(MouseButton.PRIMARY);

        // then:
        Iterator it = app.getDrawingPane().iterator();
        assertTrue(it.next() instanceof IShape);
        assertFalse(it.hasNext());
    }

    @Test
    public void should_draw_rectangle() {
        // given:
        clickOn("Rectangle");
        moveBy(0,60);

        // when:
        drag().dropBy(70,40);

        // then:
        Iterator it = app.getDrawingPane().iterator();
        assertTrue(it.next() instanceof IShape);
        assertFalse(it.hasNext());
    }

    @Test
    public void should_draw_triangle() {
        // given:
        clickOn("Triangle");
        moveBy(0,60);

        // when:
        drag().dropBy(70,40);

        // then:
        Iterator it = app.getDrawingPane().iterator();
        assertTrue(it.next() instanceof IShape);
        assertFalse(it.hasNext());
    }

    @Test
    public void should_clear() {
        // given:
        clickOn("Rectangle");
        moveBy(30,60).drag().dropBy(70,40);
        clickOn("Circle");
        moveBy(-30,160).drag().dropBy(70,40);
        clickOn("Triangle");
        moveBy(50,160).drag().dropBy(70,40);

        // when:
        clickOn("Clear");

        // then:
        assertFalse(app.getDrawingPane().iterator().hasNext());
    }

    @Test
    public void should_display_right_number() {
        clickOn("Triangle");
        moveBy(50,80).drag().dropBy(60,100);
        clickOn("Circle");
        moveBy(60,80).drag().dropBy(70,40);

        assertTrue(app.getDrawingPane().getNbShape() == 2);
    }

    @Test
    public void should_display_right_number_clear() {
        clickOn("Triangle");
        moveBy(50,80).drag().dropBy(60,100);
        clickOn("Circle");
        moveBy(60,80).drag().dropBy(70,40);
        clickOn("Clear");
        assertTrue(app.getDrawingPane().getNbShape() == 0);
    }

    @Test
    public void should_display_right_number_select() {
        clickOn("Triangle");
        moveBy(50,80).drag().dropBy(60,100);
        clickOn("Circle");
        moveBy(60,80).drag().dropBy(70,40);
        clickOn(app.getDrawingPane().getChildren().get(1));
        press(KeyCode.CONTROL).clickOn(app.getDrawingPane().getChildren().get(0));
        assertTrue(app.getDrawingPane().getNbSelectedShape() == 2);
    }

    @Test
    public void should_display_right_number_remove_one() {
        clickOn("Triangle");
        moveBy(50,80).drag().dropBy(60,100);
        clickOn("Circle");
        moveBy(10,10).drag().dropBy(70,40);
        clickOn(app.getDrawingPane().getChildren().get(0));
        clickOn("Clear Select");
        assertTrue(app.getDrawingPane().getNbShape() == 1);
    }

}