package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;;
public class Ball extends Group {
    private Circle c1;
    private Animation timeline;
    Ball(double v, Color cl)
    {
        super();
        c1=new Circle(v,cl);
        getChildren().add(c1);
        timeline=null;
    }
    public void change_color(Color colour)
    {
        c1.setFill(colour);
    }

    public Paint getColor()
    {
        return c1.getFill();
    }
    public Circle getCircle()
    {
        return c1;
    }
    public void pause()
    {
        if(timeline!=null)
            timeline.stop();
        timeline = new PauseTransition(Duration.seconds(20));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.playFromStart();
    }
    
    
    public void fall(Pane canvas)
    {
        if(timeline!=null)
            timeline.stop();
         timeline = new Timeline(new KeyFrame(Duration.ZERO, new EventHandler<ActionEvent>() {

            double dx = 0; //Step on x or velocity
            double dy = -5;
            @Override
            public void handle(ActionEvent t) {

                c1.setLayoutX(c1.getLayoutX() + dx);
                c1.setLayoutY(c1.getLayoutY() + dy);
                dy += 0.2;
                Bounds bounds = canvas.getBoundsInLocal();
                if (((bounds.getMaxY() - c1.getRadius() - 0.01) <= c1.getLayoutY())) {
                    dy = 0;
                    c1.setLayoutY(bounds.getMaxY() - c1.getRadius());
                }
            }

        }), new KeyFrame(Duration.millis(20)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.playFromStart();
    }

}

