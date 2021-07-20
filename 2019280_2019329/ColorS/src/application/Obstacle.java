package application;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public abstract class Obstacle extends Group {
    public abstract void rotate();
    public abstract Color collision(Circle c);
    public abstract void move_down();
    public abstract boolean intersect_shape(Shape a, Shape b);



}
