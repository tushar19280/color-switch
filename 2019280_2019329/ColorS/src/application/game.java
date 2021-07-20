package application;


import java.awt.Canvas;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import application.*;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class game implements Serializable {
	private Ball b;
    private ArrayList<Color_Changer> colour_changer=new ArrayList<>();
    private ArrayList<Obstacle> obstacles=new ArrayList<>();
    private ArrayList<Star> stars=new ArrayList<>();
    private int current_score=0;
    private ArrayList<SaveState> saved_games=new ArrayList<>();
    private int qq;
   
    

public game(int i,ActionEvent event) {
	
	this.qq=i;
	// TODO Auto-generated constructor stub
}
public void prepare_game(int X,int Y,Pane canvas)
{
    ArrayList<Integer> arr_Y=new ArrayList<>();
    b.relocate(X/2-10, Y-40);
    canvas.getChildren().add(b);
    int initial_Y=350;
    for(int i=0;i<5;i++)
    {
        arr_Y.add(Y-initial_Y);
        initial_Y+=400;
    }
    Collections.shuffle(arr_Y);
    Obstacle obs1=new Obstacle1(X/2,arr_Y.get(0));
    Obstacle obs2=new Obstacle2(X/2+90,arr_Y.get(1));
    Obstacle obs3=new Obstacle3(X/2,arr_Y.get(2));
    Obstacle obs4=new Obstacle4(X/2,arr_Y.get(3));
    Obstacle obs5=new Obstacle5(X/2,arr_Y.get(4));
    Star s1=new Star(X/2,arr_Y.get(0));
    Star s2=new Star(X/2,arr_Y.get(2));
    Star s3=new Star(X/2,arr_Y.get(4));
    stars.add(s1);
    stars.add(s2);
    stars.add(s3);
    //Collections.shuffle(obstacles);
    obstacles.add(obs1);
    obstacles.add(obs2);
    obstacles.add(obs3);
    obstacles.add(obs4);
    obstacles.add(obs5);
    for(int i=0;i<obstacles.size();i++)
    {
        Obstacle ob=obstacles.get(i);
        canvas.getChildren().add(ob);
    }
    Color_Changer ch1=new Color_Changer(X/2,Y-550);
    Color_Changer ch2=new Color_Changer(X/2,Y-1350);
    colour_changer.add(ch1);
    colour_changer.add(ch2);
    for(int i=0;i<colour_changer.size();i++)
    {
        Color_Changer ob=colour_changer.get(i);
        canvas.getChildren().add(ob);
    }
    for(int i=0;i<stars.size();i++)
    {
        Star ob=stars.get(i);
        canvas.getChildren().add(ob);
    }
}

	    
	    public void runn(ActionEvent event) throws IOException, ClassNotFoundException{
	    	Pane canvas = new BorderPane();
			Stage primaryStage = (Stage)  (((Node) event.getSource()).getScene().getWindow());
	        
			primaryStage.setTitle("Colour Switch");
			int X=650,Y=700;
	        b = new Ball(10, Color.DEEPPINK);
	       
	        Scene dc = new Scene(canvas, X, Y, Color.BLACK);
	        
	        
	        
	        
	        
	        
	        ImageView bg=new ImageView("application/Untitled.png");
	        bg.setFitHeight(700);
	        bg.setFitWidth(650);
	        bg.relocate(0,0);
	        canvas.getChildren().add(bg);
	        
	        int z=5;
	        ImageView im=new ImageView("application/images.jpg");
	        im.setFitHeight(50);
	        im.setFitWidth(50);
	        im.relocate(X-50,Y-50);
	        canvas.getChildren().add(im);
	        
	        Text label=new Text();
	        label.setX(60);
	        label.setY(60);
	        label.setFill(Color.WHITE);
	        label.relocate(80,Y-20);
	        
	        label.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,40));
	        
	        //label.setTextFill(Color.BLACK);
	        canvas.getChildren().add(label);
	        label.setText(Integer.toString(current_score));

	        ImageView im_star=new ImageView("application/Star_white.png");
	        im_star.setFitHeight(60);
	        im_star.setFitWidth(60);
	        im_star.relocate(0,640);
	        canvas.getChildren().add(im_star);
	        
	     
	        if(qq==4) {
	        prepare_game(X,Y,canvas);
	        }
	        
	        else {
	        	LoadGame(qq, canvas);
	        }
	        //canvas.getChildren().add(colour_changer);
	        HashMap<Integer, Color> hp=new HashMap<>();
	        hp.put(0,Color.DEEPPINK);
	        hp.put(1,Color.DEEPSKYBLUE);
	        hp.put(2,Color.YELLOW);
	        hp.put(3,Color.PURPLE);
	        Random ran=new Random();
//	        Pane canvas = new BorderPane();

	        primaryStage.setScene(dc);

	        primaryStage.show();





	        new AnimationTimer() {
	        	public void pause()
	            {
	                b.pause();
	            }
	        	private boolean stage=true;
	        	private boolean val =true;
	        	private boolean resumew =true;
	        	private boolean resumep =true;
	        	private boolean savp =true;
	        	
            	ImageView sav=new ImageView("application/save.png");
    	        
	        	
	        	PauseMenu sub = new PauseMenu();
	        	
				
	        	
	            public void handle(long arg0) {
	          
	            	
	            	
	                dc.setOnMousePressed(new EventHandler<MouseEvent>() {
	                
	                	
	                	


	                    @Override
	                    public void handle(MouseEvent mouseEvent) {

	                        b.fall(canvas);
	                        if(b.getBoundsInParent().getMaxY()<0.65*Y)
	                            //obs1.setLayoutY(obs1.getLayoutY()+10);
	                        {
	                            for (int i = 0; i < obstacles.size(); i++) {
	                                Obstacle ob = obstacles.get(i);
	                                ob.move_down();
	                            }

	                            for(int i=0;i<colour_changer.size();i++) {
	                                Color_Changer ob = colour_changer.get(i);
	                                ob.move_down();
	                            }
	                            for(int i=0;i<stars.size();i++) {
	                                Star ob = stars.get(i);
	                                ob.move_down();
	                            }

	                        }


	                    }
	                });
	                for(int i=0;i<obstacles.size();i++)
	                {
	                    Obstacle ob=obstacles.get(i);
	                    ob.rotate();
	                }

	                for(int i=0;i<obstacles.size();i++)
	                {
	                    Obstacle ob=obstacles.get(i);
	                    if(ob.collision(b.getCircle())!=null)
	                    {
	                        if(ob.collision(b.getCircle())!=b.getColor()) {
	                        	pause();
	                        	ImageView hh=new ImageView("application/menu.png");
	                	        hh.setFitHeight(80);
	                	        hh.setFitWidth(200);
	                	      
	                	       
	                	        
	                	        ImageView rt=new ImageView("application/restart.png");
	                	        rt.setFitHeight(80);
	                	        rt.setFitWidth(200);
	                	 
	                	        
	                	        
	                	        ImageView rs=new ImageView("application/resume.png");
	                	        rs.setFitHeight(80);
	                	        rs.setFitWidth(200);
	                	        
	                	        
	                	        
	                	        
	                	        
	                	        if(resumew) {
		                	        rt.relocate(250,250);
		                	        hh.relocate(250,100);
		                	        rs.relocate(250,400);
		                	        resumew=false;
		                	        }
	                	        if(resumep) {
	                	        	canvas.getChildren().add(hh);
	  	                	        canvas.getChildren().add(rt);
	  	                	        canvas.getChildren().add(rs);
		                	        resumep=false;
		                	        }
	                	        
	                	        
	                	      
	                	        
	                	        
	                	        rs.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        	    	            @Override
	        	    	            public void handle(MouseEvent event) {
	        	    	            
	        	    	            	rs.relocate(1000,1000);
	    	                	        rt.relocate(1000,1000);
	    	                	        hh.relocate(1000,1000);
	    	                	        
	    	                	        ppp();
	    	                	        if (current_score==0){
	    	                	        	ActionEvent ae = new ActionEvent(event.getSource(), event.getTarget());
		        	    	            	BorderPane nnext = null;
											try {
												nnext = (BorderPane) FXMLLoader.load(getClass().getResource("APP.fxml"));
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
		        	    	        		Scene next = new Scene(nnext);
		        	    	        		next.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		        	    	        		Stage window = (Stage)  (((Node) event.getSource()).getScene().getWindow());
		        	    	        		window.setScene(next);
		        	    	        		window.show();
	                	        }
	    	                	        else {
	    	                	        current_score --;
	    	                	        label.setText(Integer.toString(current_score));
	    	                	        }
	    	                	        System.out.println("hello");
	    	                	        
	        	    	            }

									private void ppp() {
										resumew = true;
										
									}
	        	    	        });
	                	        
	                	        
	                	        
	                	        
	                	        hh.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        	    	            @Override
	        	    	            public void handle(MouseEvent event) {
	        	    	            
	        	    	            	
	        	    	            	
	        	    	            	
	        	    	            	ActionEvent ae = new ActionEvent(event.getSource(), event.getTarget());
	        	    	            	BorderPane nnext = null;
										try {
											nnext = (BorderPane) FXMLLoader.load(getClass().getResource("APP.fxml"));
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
	        	    	        		Scene next = new Scene(nnext);
	        	    	        		next.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        	    	        		Stage window = (Stage)  (((Node) event.getSource()).getScene().getWindow());
	        	    	        		window.setScene(next);
	        	    	        		window.show();
	        	    	            }
	        	    	        });
	                	        
	                	        
	                	        
	                	        
	                	        
	                	        
	                	        
	                	        
	                	        
	                	        
	                	        
	                	        rt.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        	    	            @Override
	        	    	            public void handle(MouseEvent event) {
	        	    	            
	        	    	            	ActionEvent ae = new ActionEvent(event.getSource(), event.getTarget());
	        	    	            	current_score=0;
	        	    	            	try {
	        	    	            		game gg = new game(4,ae);
	        	    	            		gg.runn(ae);
										} catch (IOException | ClassNotFoundException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
	        	    	            	
	        	    	            }
	        	    	        });
	                        
	                        	
	                        }

	                            
	                            //System.out.println("Helo");
	                            //b.change_color(Color.RED);
	                    }
	                }

	                for(int i=0;i<obstacles.size();i++) {
	                    Obstacle obc1 = obstacles.get(i);
	                    if (obc1.getBoundsInParent().getMinY() > 700.0) {
	                        obc1.setLayoutY(obc1.getLayoutY() - 2000);
//	                        obstacles.remove(0);
//	                        obstacles.add(obc1);
//	                    canvas.getChildren().add(obc1);
	                    }
	                }

	                for(int i=0;i<colour_changer.size();i++)
	                {
	                    Color_Changer ob=colour_changer.get(i);
	                    if(b.getBoundsInParent().intersects(ob.getBoundsInParent()))
	                    {
	                        int n= ran.nextInt(4);
	                        b.change_color(hp.get(n));
	                        ob.setLayoutY(ob.getLayoutY()-2000);
	                    }
	                }

	                for(int i=0;i<stars.size();i++)
	                {
	                    Star ob=stars.get(i);
	                    if(b.getBoundsInParent().intersects(ob.getBoundsInParent()))
	                    {
	                        current_score+=1;
	                        ob.setLayoutY(ob.getLayoutY()-2000);
	                        //System.out.println(current_score);
	                        label.setText(Integer.toString(current_score));
	                    }
	                }
	                
	                
	                im.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	            @Override
	    	            public void handle(MouseEvent event) {
	    	            	
	    	            
                	  
                	        
                	    
                	        
	    	            	
	    	            	if (val) {
	    	            		
	    	            		canvas.getChildren().add(sub);
	    	            		canvas.getChildren().add(sav);
	    	            		val= false;
	    	            	}
	    	            	if (stage) {
	    	    	           	pause();
	    	    	           	sav.setFitHeight(35);
	                	        sav.setFitWidth(125);
	    	    	           	stage = false;
	    	    	           	sub.setLayoutX(100);
	    	            		sub.setLayoutY(100);
	    	            		sav.relocate(235, 225);
	    	            		
	    	    	           	System.out.println("I am here");
	    	            	}
	    	            
	    	            
	    	            	else {
	    	            		System.out.println("yaahha");
//	    	            		canvas.getChildren().remove(sub);
	    	            		
	    	            		sub.setLayoutX(100);
	    	            		sub.setLayoutY(2000);
	    	            		
	    	            		canvas.getChildren().remove(sub);
	    	            		sav.relocate(1580, 2000);
	    	            		canvas.getChildren().remove(sav);
	    	            		
	    	            		
	    	            		stage = true;
	    	            	
	    	            	}
	    	            	
	    	            	
	    	            }
	    	        });
	                
	                
	                sav.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	            @Override
	    	            public void handle(MouseEvent event) {
	    	            
	    	            	try {
								serialize();
							} catch (ClassNotFoundException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    	            	
	    	            	
	    	            	
	    	            }
	    	        });

	            }
	        }.start();
	    	
	    }
	    
	    

	    public void prepare_game_1(int X,int Y,Pane canvas)
	    {
	        ArrayList<Integer> arr_Y=new ArrayList<>();
	        int initial_Y=350;
	        for(int i=0;i<5;i++)
	        {
	            arr_Y.add(Y-initial_Y);
	            initial_Y+=400;
	        }
//	        Collections.shuffle(arr_Y);
	        Obstacle obs1=new Obstacle1(X/2,arr_Y.get(0));
	        Obstacle obs2=new Obstacle2(X/2+90,arr_Y.get(1));
	        Obstacle obs3=new Obstacle3(X/2,arr_Y.get(2));
	        Obstacle obs4=new Obstacle4(X/2,arr_Y.get(3));
	        Obstacle obs5=new Obstacle5(X/2,arr_Y.get(4));
	        Star s1=new Star(X/2,arr_Y.get(0));
	        Star s2=new Star(X/2,arr_Y.get(2));
	        Star s3=new Star(X/2,arr_Y.get(4));
	        stars.add(s1);
	        stars.add(s2);
	        stars.add(s3);
	        //Collections.shuffle(obstacles);
	        obstacles.add(obs1);
	        obstacles.add(obs2);
	        obstacles.add(obs3);
	        obstacles.add(obs4);
	        obstacles.add(obs5);
	        for(int i=0;i<obstacles.size();i++)
	        {
	            Obstacle ob=obstacles.get(i);
//	            canvas.getChildren().add(ob);
	        }
	        Color_Changer ch1=new Color_Changer(X/2,Y-550);
	        Color_Changer ch2=new Color_Changer(X/2,Y-1350);
	        colour_changer.add(ch1);
	        colour_changer.add(ch2);
	        for(int i=0;i<colour_changer.size();i++)
	        {
	            Color_Changer ob=colour_changer.get(i);
//	            canvas.getChildren().add(ob);
	        }
	        for(int i=0;i<stars.size();i++)
	        {
	            Star ob=stars.get(i);
//	            canvas.getChildren().add(ob);
	        }
	    }

	    public void serialize() throws IOException, ClassNotFoundException
	    {
	    	System.out.println("helooooooooooooooooooooooooooooooooo");
	        try {
	            this.saved_games = deserialize();
	            System.out.println(saved_games.size());
	        }
	        catch (Exception e)
	        {
	            this.saved_games = new ArrayList<>();
	        }
	         ArrayList<Double> obstacle_y = new ArrayList<>();
	         ArrayList<Double> star_y = new ArrayList<>();
	         ArrayList<Double> colour_changer_y = new ArrayList<>();
	         double ball_y = b.getBoundsInParent().getMaxY()-20.0;
	         int current_score = this.current_score;

	         for(int i=0;i<obstacles.size();i++)
	         {
	             obstacle_y.add(obstacles.get(i).getLayoutY());
	         }

	        for(int i=0;i<stars.size();i++)
	        {
	            star_y.add(stars.get(i).getLayoutY());
	        }

	        for(int i=0;i<colour_changer.size();i++)
	        {
	            colour_changer_y.add(colour_changer.get(i).getLayoutY());
	        }

	        SaveState sv = new SaveState(obstacle_y, star_y, colour_changer_y, ball_y, current_score);

//	        int index = -1;
//	        if(saved_games.size() >= 4)
//	        {
//	            index = 0;
//	        }
	//
//	        if (index==-1)
//	        {
//	            saved_games.add(sv);
//	        }
//	        else
//	        {
//	            saved_games.set(index, sv);
//	        }

	        saved_games.add(sv);

	        if (saved_games.size()>4)
	            saved_games.remove(0);

	        ObjectOutputStream out = null;

	        try{
	            out = new ObjectOutputStream(new FileOutputStream("game.txt"));
	            out.writeObject(saved_games);
	        }
	        finally {
	            out.close();
	        }


	    }
	    public ArrayList<SaveState> deserialize() throws IOException, ClassNotFoundException
	    {

	        ObjectInputStream in=null;
	        ArrayList<SaveState> sv = null;

	        try {
	            in = new ObjectInputStream(new FileInputStream("game.txt"));
	            sv = (ArrayList<SaveState>) in.readObject();
	        }
	        finally {
	            in.close();
	        }

	        return sv;
	    }

	    public void LoadGame(int index, Pane canvas) throws IOException, ClassNotFoundException
	    {
	        ArrayList<SaveState> sg = deserialize();
	        SaveState sv = sg.get(index);

	        int X = 650, Y = 700;

	        prepare_game_1(X,Y,canvas);


	        for (int i = 0;i<obstacles.size();i++)
	        {
	            obstacles.get(i).setLayoutY(sv.getObstacle_y().get(i));
	            canvas.getChildren().add(obstacles.get(i));
	        }

	        for (int i = 0;i<stars.size();i++)
	        {
	            stars.get(i).setLayoutY(sv.getStar_y().get(i));
	            canvas.getChildren().add(stars.get(i));
	        }

	        for (int i = 0;i<colour_changer.size();i++)
	        {
	            colour_changer.get(i).setLayoutY(sv.getColour_changer_y().get(i));
	            canvas.getChildren().add(colour_changer.get(i));
	        }

//	        b.setLayoutY(sv.getBall_y());
	            b.relocate(X/2-10, sv.getBall_y());
	        canvas.getChildren().add(b);
	        this.current_score = sv.getCurrent_score();


	    }
}
