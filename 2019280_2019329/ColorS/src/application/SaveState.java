package application;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveState implements Serializable {
    private ArrayList<Double> obstacle_y;
    private ArrayList<Double> star_y;
    private ArrayList<Double> colour_changer_y;
    private double ball_y;
    private int current_score;
    private static final long serialVersionUID = 42L;

    SaveState(ArrayList<Double> obstacle_y, ArrayList<Double> star_y, ArrayList<Double> colour_changer_y, double ball_y, int current_score)
    {
        this.obstacle_y = obstacle_y;
        this.star_y = star_y;
        this.colour_changer_y = colour_changer_y;
        this.ball_y = ball_y;
        this.current_score = current_score;
    }

    public ArrayList<Double> getObstacle_y() {
        return obstacle_y;
    }

    public ArrayList<Double> getStar_y() {
        return star_y;
    }

    public ArrayList<Double> getColour_changer_y() {
        return colour_changer_y;
    }

    public double getBall_y() {
        return ball_y;
    }

    public int getCurrent_score() {
        return current_score;
    }
}
