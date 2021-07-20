package application;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class Obstacle3 extends Obstacle {
    private Line up;
    private Line down;
    private Line right;
    private Line left;


    Obstacle3(double X,double Y)
    {
        super();
        up = new  Line(X-100, Y-100, X+100, Y-100);
        up.setStrokeLineCap(StrokeLineCap.ROUND);
        up.setStrokeWidth(15);
        up.setStroke(Color.DEEPSKYBLUE);
        up.setFill(null);

        right = new  Line(X-100, Y-100, X-100, Y+100);
        right.setStrokeWidth(15);
        right.setStroke(Color.DEEPPINK);
        right.setStrokeLineCap(StrokeLineCap.ROUND);
        right.setFill(null);

        down = new  Line(X-100, Y+100, X+100, Y+100);
        down.setStrokeWidth(15);
        down.setStroke(Color.PURPLE);
        down.setStrokeLineCap(StrokeLineCap.ROUND);
        down.setFill(null);

        left = new  Line(X+100, Y-100, X+100, Y+100);
        left.setStrokeWidth(15);
        left.setStroke(Color.YELLOW);
        left.setStrokeLineCap(StrokeLineCap.ROUND);
        left.setFill(null);




        getChildren().add(up);
        getChildren().add(down);
        getChildren().add(right);
        getChildren().add(left);
    }

    @Override
    public void rotate() {
        RotateTransition rt = new RotateTransition(Duration.seconds(3),this);
        rt.setByAngle(-360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.play();

    }

    @Override
    public void move_down() {
        setLayoutY(getLayoutY()+25);

    }

    @Override
    public Color collision(Circle c) {
        if (intersect_shape(c, up))
        {
            return Color.DEEPSKYBLUE;
        }
        if (intersect_shape(c, down))
        {
            return Color.PURPLE;
        }
        if (intersect_shape(c, right))
        {
            return Color.DEEPPINK;
        }
        if (intersect_shape(c, left))
        {
            return Color.YELLOW;
        }
        return null;
    }
    @Override
    public boolean intersect_shape(Shape c1, Shape a)
    {
        Shape shape = null;
        shape = Shape.intersect(c1, a);
        boolean intersects = shape.getBoundsInLocal().getWidth() != -1;
        return intersects;
    }
}
