package application;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class Color_Changer extends Group {
    private Arc arc1;
    private Arc arc2;
    private Arc arc3;
    private Arc arc4;
    Color_Changer(double X,double Y)
    {
        super();
        arc1=new Arc(X,Y,10,10,0,90);
        arc1.setFill(Color.DEEPSKYBLUE);
        arc2=new Arc(X,Y,10,10,-90,90);
        arc2.setFill(Color.DEEPPINK);
        arc3=new Arc(X,Y,10,10,180,90);
        arc3.setFill(Color.YELLOW);
        arc4=new Arc(X,Y,10,10,90,90);
        arc4.setFill(Color.PURPLE);
        arc1.setType(ArcType.ROUND);
        arc2.setType(ArcType.ROUND);
        arc3.setType(ArcType.ROUND);
        arc4.setType(ArcType.ROUND);
        getChildren().add(arc1);
        getChildren().add(arc2);
        getChildren().add(arc3);
        getChildren().add(arc4);
    }

    public void move_down()
    {
        setLayoutY(getLayoutY()+10);
    }
}
