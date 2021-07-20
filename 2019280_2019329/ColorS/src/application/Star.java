package application;


import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class Star extends Group {
    private ImageView image;
    Star(double X,double Y)
    {
        super();
        image=new ImageView("application/Star_white.png");
        image.setFitHeight(20);
        image.setFitWidth(20);
        image.relocate(X-10,Y-10);
//        image.setX(X);
//        image.setY(Y);
        getChildren().add(image);
    }

    public void move_down() {
        setLayoutY(getLayoutY()+30);

    }
}
