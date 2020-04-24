package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import cui.SokobanApplicatie;

import domein.DomeinController;
import gui.Taal;
import gui.TaalSchermController;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Start_Up 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try {
			TaalSchermController root = new TaalSchermController();
			Scene scene = new Scene(root);
			Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
			primaryStage.getIcons().add(icon);
			primaryStage.setScene(scene);
			primaryStage.setTitle("SOKOBAN");
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**public static void main(String[] args) 
	{
		Taal taal = new Taal();
		DomeinController dc = new DomeinController();
		SokobanApplicatie sa = new SokobanApplicatie(dc);
		
		sa.run();    //run methode van sokobanapplicatie wordt uitgevoerd
		
	
	}*/
	

}