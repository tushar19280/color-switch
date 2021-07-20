package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import javafx.animation.RotateTransition;
import application.*;

public class mainmenu {
	
	public Group obs1;
	public Group obs2;
	public Button obs11;
	public Button obs111;
	public Button menu;
	public Button but;
	public Button close;
	public Button play;
	public Button next;
	public Circle c1;
	public Button prev;
	public Button load;
	public Button restart;
	
	public Button starting;

	BorderPane nnext;
	
	
	public void Play(ActionEvent event) {
		setRotate(obs1, false, -360, 10);
		setRotate(obs2, false, 360, 5);

//		c1.setTranslateY(10);;
		
	}
	public void exitGame(ActionEvent event) throws IOException {
		 System.exit(0);

		
	}
	
	public void startGame(ActionEvent event) throws IOException, ClassNotFoundException {
		game gg = new game(4,event);
		gg.runn(event);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void obs1(ActionEvent event) throws IOException, ClassNotFoundException {
		game gg = new game(0,event);
		gg.runn(event);
	}
	public void obs2(ActionEvent event) throws IOException, ClassNotFoundException {
		game gg = new game(1,event);
		gg.runn(event);
	}
	public void obs3(ActionEvent event) throws IOException, ClassNotFoundException {
		game gg = new game(2,event);
		gg.runn(event);
	}
	public void obs4(ActionEvent event) throws IOException, ClassNotFoundException {
		game gg = new game(3,event);
		gg.runn(event);
	}
	
	
	
	
	public void restart(ActionEvent event) throws IOException, ClassNotFoundException {
		game gg = new game(4,event);
		gg.runn(event);
	}
	public void start(ActionEvent event) throws IOException {
		Play(event);
		starting.setDisable(true);
		starting.setVisible(false);
//		nnext.getChildren().remove(starting);
		
		
	}

	public void prev(ActionEvent event) throws IOException {
		nnext =(BorderPane) FXMLLoader.load(getClass().getResource("obs1.fxml"));
		Scene next = new Scene(nnext);
		next.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage window = (Stage)  (((Node) event.getSource()).getScene().getWindow());
		window.setScene(next);
		window.show();
	}
	
	public void obs11(ActionEvent event) throws IOException {
		nnext =(BorderPane) FXMLLoader.load(getClass().getResource("obs4.fxml"));
		Scene next = new Scene(nnext);
		next.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage window = (Stage)  (((Node) event.getSource()).getScene().getWindow());
		window.setScene(next);
		window.show();
	}
	
	public void menu(ActionEvent event) throws IOException {
		nnext =(BorderPane) FXMLLoader.load(getClass().getResource("APP.fxml"));
		Scene next = new Scene(nnext);
		next.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage window = (Stage)  (((Node) event.getSource()).getScene().getWindow());
		window.setScene(next);
		window.show();
	}
	public void loadGame(ActionEvent event) throws IOException {
		 nnext =(BorderPane) FXMLLoader.load(getClass().getResource("Load.fxml"));
		Scene next = new Scene(nnext);
		next.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage window = (Stage)  (((Node) event.getSource()).getScene().getWindow());
		window.setScene(next);
		window.show();
	}
	
	private void setRotate(Group p, boolean reverse, int angle, int duration) {
		RotateTransition rt = new RotateTransition(Duration.seconds(duration),p); 
		rt.setByAngle(angle);
		rt.setDelay(Duration.seconds(0));
		rt.setRate(3);
		rt.setCycleCount(18);
		rt.play();
		
		
	}
	


	
	
}
