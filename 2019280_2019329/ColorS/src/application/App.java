package application;

import java.io.IOException;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import application.*;

public class App {
	
	private static final int HEIGHT = 650;
	private static final int WIDTH = 700;
	private BorderPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	public Group obs1;
	public Group obs2;
	public Button close;
	public Button load;
	public Button startGame;
	
	
	
	
	
	
	
	
	
	public App() throws IOException {
	
		
//		mainPane = new AnchorPane();
		mainPane = FXMLLoader.load(getClass().getResource("APP.fxml"));
//		mainn.Play();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT );
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		

	}
	public Stage getMainStage() {
		return mainStage;
		
	}
	
}
