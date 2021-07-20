package application;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class Obstacle5 extends Obstacle {
    private Arc arc1;
    private Arc arc2;
    private Arc arc3;
    private Arc arc4;
    Obstacle1 obs4;
    Obstacle5(double X,double Y)
    {
        super();
        arc1=new Arc(X,Y,100,100,0,90);
        arc1.setType(ArcType.CHORD);
        arc1.setStrokeWidth(12);
        arc1.setStroke(Color.DEEPSKYBLUE);
        arc1.setStrokeLineJoin(StrokeLineJoin.ROUND);
        arc1.setFill(null);

        arc2=new Arc(X,Y,100,100,-90,90);
        arc2.setType(ArcType.CHORD);
        arc2.setStrokeWidth(12);
        arc2.setStroke(Color.DEEPPINK);
        arc2.setStrokeLineJoin(StrokeLineJoin.ROUND);
        arc2.setFill(null);

        arc3=new Arc(X,Y,100,100,180,90);
        arc3.setType(ArcType.CHORD);
        arc3.setStrokeWidth(12);
        arc3.setStroke(Color.PURPLE);
        arc3.setStrokeLineJoin(StrokeLineJoin.ROUND);
        arc3.setFill(null);

        arc4=new Arc(X,Y,100,100,90,90);
        arc4.setType(ArcType.CHORD);
        arc4.setStrokeWidth(12);
        arc4.setStroke(Color.YELLOW);
        arc4.setStrokeLineJoin(StrokeLineJoin.ROUND);
        arc4.setFill(null);





        getChildren().add(arc1);
        getChildren().add(arc2);
        getChildren().add(arc3);
        getChildren().add(arc4);

    }

    @Override
    public void rotate() {
        RotateTransition rt = new RotateTransition(Duration.seconds(7),this);
        rt.setByAngle(360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.play();

    }

    @Override
    public boolean intersect_shape(Shape c1, Shape a)
    {
        Shape shape = null;
        shape = Shape.intersect(c1, a);
        boolean intersects = shape.getBoundsInLocal().getWidth() != -1;
        return intersects;
    }

    @Override
    public Color collision(Circle c) {
        if(intersect_shape(c,arc1))
        {
            return Color.DEEPSKYBLUE;
        }
        if(intersect_shape(c,arc2))
        {
            return Color.DEEPPINK;

        }
        if(intersect_shape(c,arc3))
        {

                return Color.PURPLE;

        }
        if(intersect_shape(c,arc4))
        {
            return Color.YELLOW;
        }
        return null;
    }

	@Override
	public void move_down() {
		// TODO Auto-generated method stub
		
	}

}
