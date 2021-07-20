package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import application.*;

public class Main extends Application {
	
	public App app;
	@Override
	public void start(Stage primaryStage) {
		try {
			app = new App();
			
			primaryStage= app.getMainStage();
			
			primaryStage.show();
			
		
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
