package application;

import java.io.IOException;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class Killed extends SubScene {
	private  boolean isHidden;
	int width= 400;
	int height=500;
	
	public Killed() throws IOException {
		
		super(new BorderPane(), 400,500);
		
		
//		BorderPane root2 = (BorderPane) this.getRoot();
		this.setRoot((BorderPane) FXMLLoader.load(getClass().getResource("pause.fxml")));
//		root2 =(BorderPane) FXMLLoader.load(getClass().getResource("Load.fxml"));
		
		isHidden = true ;
		
		// TODO Auto-generated constructor stub
	}
	public void moveSubScene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);
		
		if (isHidden) {
			
			transition.setToX(-676);
			isHidden = false;
			
		} else {
			
			transition.setToX(0);
			isHidden = true ;
		}
		
		
		transition.play();
	}




}
