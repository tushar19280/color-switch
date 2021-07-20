package application;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class Obstacle4 extends Obstacle {
//    private Arc arc1;
//    private Arc arc2;
//    private Arc arc3;
//    private Arc arc4;
//    private Arc arc11;
//    private Arc arc12;
//    private Arc arc13;
//    private Arc arc14;
    Obstacle1 obs1,obs2;
    Obstacle4(double X,double Y)
    {
        super();
        obs1=new Obstacle1(X-100,Y);
        obs2=new Obstacle1(X+100,Y);
        obs2.getArc1().setStroke(Color.YELLOW);
        obs2.getArc2().setStroke(Color.PURPLE);
        obs2.getArc3().setStroke(Color.DEEPPINK);
        obs2.getArc4().setStroke(Color.DEEPSKYBLUE);
//        arc1=new Arc(X+100,Y,100,100,0,90);
//        arc1.setType(ArcType.OPEN);
//        arc1.setStrokeWidth(10);
//        arc1.setStroke(Color.DEEPSKYBLUE);
//        arc1.setStrokeLineJoin(StrokeLineJoin.ROUND);
//        arc1.setFill(null);
//
//        arc2=new Arc(X+100,Y,100,100,-90,90);
//        arc2.setType(ArcType.OPEN);
//        arc2.setStrokeWidth(10);
//        arc2.setStroke(Color.DEEPPINK);
//        arc2.setStrokeLineJoin(StrokeLineJoin.ROUND);
//        arc2.setFill(null);
//
//        arc3=new Arc(X+100,Y,100,100,180,90);
//        arc3.setType(ArcType.OPEN);
//        arc3.setStrokeWidth(10);
//        arc3.setStroke(Color.YELLOW);
//        arc3.setStrokeLineJoin(StrokeLineJoin.ROUND);
//        arc3.setFill(null);
//
//        arc4=new Arc(X+100,Y,100,100,90,90);
//        arc4.setType(ArcType.OPEN);
//        arc4.setStrokeWidth(10);
//        arc4.setStroke(Color.PURPLE);
//        arc4.setStrokeLineJoin(StrokeLineJoin.ROUND);
//        arc4.setFill(null);
//
//
//
//
//        arc11=new Arc(X-100,Y,100,100,0,90);
//        arc11.setType(ArcType.OPEN);
//        arc11.setStrokeWidth(10);
//        arc11.setStroke(Color.PURPLE);
//        arc11.setStrokeLineJoin(StrokeLineJoin.ROUND);
//        arc11.setFill(null);
//
//        arc12=new Arc(X-100,Y,100,100,-90,90);
//        arc12.setType(ArcType.OPEN);
//        arc12.setStrokeWidth(10);
//        arc12.setStroke(Color.YELLOW);
//        arc12.setStrokeLineJoin(StrokeLineJoin.ROUND);
//        arc12.setFill(null);
//
//        arc13=new Arc(X-100,Y,100,100,180,90);
//        arc13.setType(ArcType.OPEN);
//        arc13.setStrokeWidth(10);
//        arc13.setStroke(Color.DEEPPINK);
//        arc13.setStrokeLineJoin(StrokeLineJoin.ROUND);
//        arc13.setFill(null);
//
//        arc14=new Arc(X-100,Y,100,100,90,90);
//        arc14.setType(ArcType.OPEN);
//        arc14.setStrokeWidth(10);
//        arc14.setStroke(Color.DEEPSKYBLUE);
//        arc14.setStrokeLineJoin(StrokeLineJoin.ROUND);
//        arc14.setFill(null);
//
//        getChildren().add(arc1);
//        getChildren().add(arc2);
//        getChildren().add(arc3);
//        getChildren().add(arc4);
//        getChildren().add(arc11);
//        getChildren().add(arc12);
//        getChildren().add(arc13);
//        getChildren().add(arc14);
        getChildren().add(obs1);
        getChildren().add(obs2);
    }

    @Override
    public void rotate() {
        RotateTransition rt = new RotateTransition(Duration.seconds(7),obs1);
        rt.setByAngle(360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);

        RotateTransition rt1 = new RotateTransition(Duration.seconds(7),obs2);
        rt1.setByAngle(-360);
        rt1.setCycleCount(Animation.INDEFINITE);
        rt1.setInterpolator(Interpolator.LINEAR);
        ParallelTransition p = new ParallelTransition();
        p.getChildren().add(rt);
        p.getChildren().add(rt1);
        p.playFromStart();


    }

    @Override
    public void move_down() {
        setLayoutY(getLayoutY()+25);

    }

    @Override
    public Color collision(Circle c) {
        if (intersect_shape(c, obs1.getArc1()))
        {
            return Color.DEEPSKYBLUE;
        }
        if (intersect_shape(c, obs1.getArc2()))
        {
            return Color.DEEPPINK;
        }
        if (intersect_shape(c, obs1.getArc3()))
        {
            return Color.PURPLE;
        }
        if (intersect_shape(c, obs1.getArc4()))
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
