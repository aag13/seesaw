
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author AAG
 */
public class seesaw extends Application {
    
    int cx = 50;
    int cy = 295;
    int rx = 310;
    int ry = 85;
    
    int hr = 5;
    
    int horizontal = 165;
    int vertical = -25;
    
    int hhx = 38 + horizontal;
    int hhy = 215 + vertical;
    int hbx = 30 + horizontal;
    int hby = 220 + vertical;
    int w = 15;
    int h = 30;
    
    
    
    private SimpleDoubleProperty hy = new SimpleDoubleProperty(hhy);
    private SimpleDoubleProperty by = new SimpleDoubleProperty(hby);
    
    private SimpleDoubleProperty startx = new SimpleDoubleProperty(60);
    private SimpleDoubleProperty starty = new SimpleDoubleProperty(340);

    private SimpleDoubleProperty endx = new SimpleDoubleProperty(340);
    private SimpleDoubleProperty endy = new SimpleDoubleProperty(140);

    private SimpleDoubleProperty circlex = new SimpleDoubleProperty(cx);
    private SimpleDoubleProperty circley = new SimpleDoubleProperty(cy);

    private SimpleDoubleProperty rectx = new SimpleDoubleProperty(rx);
    private SimpleDoubleProperty recty = new SimpleDoubleProperty(ry);

    private Timeline time1;
    
    String up = "A";
    

    @Override
    public void start(Stage primaryStage) {
        
        Circle hcr = new Circle(hhx, hhy, hr);
        hcr.setStroke(Color.BLACK);
        hcr.setFill(Color.CRIMSON);
        hcr.setStrokeWidth(2);
        hcr.centerYProperty().bind(hy);
        
        Rectangle hrc = new Rectangle(hbx,hby,w,h);
        
        hrc.setStroke(Color.BLACK);
        hrc.setFill(Color.CRIMSON);
        hrc.setStrokeWidth(2);
        hrc.yProperty().bind(by);

        Line ss = new Line(60, 340, 340, 140);

        Line divider = new Line(0, 350, 450, 350);
        
        ss.setStroke(Color.BLACK);
        ss.setStrokeWidth(5);

        ss.startXProperty().bind(startx);
        ss.startYProperty().bind(starty);

        ss.endXProperty().bind(endx);
        ss.endYProperty().bind(endy);

        Circle cr = new Circle(cx, cy, 40);
        cr.setStroke(Color.RED);
        cr.setFill(Color.ORANGE);
        cr.setStrokeWidth(5);

        cr.centerXProperty().bind(circlex);
        cr.centerYProperty().bind(circley);

        Circle rc = new Circle(rx, ry, 70);

        rc.setStroke(Color.GREEN);
        rc.setFill(Color.YELLOWGREEN);
        rc.setStrokeWidth(5);

        rc.centerXProperty().bind(rectx);
        rc.centerYProperty().bind(recty);

        Line left = new Line(200, 240, 160, 340);
        left.setStrokeWidth(5);

        Line right = new Line(200, 240, 240, 340);
        right.setStrokeWidth(5);

        Button btn = new Button("Beware NO Turning Back !!!");
        
        
        time1 = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(starty, 340),
                        new KeyValue(endy, 140),
                        new KeyValue(circley, 295),
                        new KeyValue(rectx, rx),
                        new KeyValue(recty, ry)),
                new KeyFrame(
                        new Duration(5000),
                        new KeyValue(starty, 140),
                        new KeyValue(endy, 340),
                        new KeyValue(circley, 100),
                        new KeyValue(rectx, 365),
                        new KeyValue(recty, 270)),
                new KeyFrame(
                        new Duration(10000),
                        new KeyValue(starty, 340),
                        new KeyValue(endy, 140),
                        new KeyValue(circley, 295),
                        new KeyValue(rectx, rx),
                        new KeyValue(recty, ry)));
        
        time1.setOnFinished(event1 -> {
                time1.playFromStart();
            });
        
        btn.setOnAction(event2 -> {
            btn.setVisible(false);
            time1.play();
            
        });
        
        Group ground = new Group();
        ground.getChildren().addAll(btn, ss, cr, rc, divider, left, right);
        
        ground.getChildren().add(hcr);
        ground.getChildren().add(hrc);
        
        Scene scene = new Scene(ground, 450, 400, Color.SKYBLUE);
        
        scene.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                
            }
        });
        
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event3) {
                String key = event3.getText();
                //time1.play();
//                if (key.equalsIgnoreCase(up)) {
//                    Timeline tempTimeline = new Timeline(
//                            new KeyFrame(
//                                    Duration.ZERO,
//                                    new KeyValue(hy, hhy),
//                                    new KeyValue(by, hby)),
//                            new KeyFrame(
//                                    new Duration(5000),
//                                    new KeyValue(starty, 140),
//                                    new KeyValue(endy, 340)),
//                            new KeyFrame(
//                                    new Duration(10000),
//                                    new KeyValue(starty, 340),
//                                    new KeyValue(endy, 140)));
//                }
            }
        });

        primaryStage.setTitle("PLAY");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
