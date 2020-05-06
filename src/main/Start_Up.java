package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import cui.SokobanApplicatie;

import domein.DomeinController;
import gui.HoofdSchermController;
import gui.Taal;
import gui.TaalSchermController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Start_Up extends Application
{
	@Override
	public void start(Stage primaryStage) 
	{
		try {
			DomeinController dc = new DomeinController();
			HoofdSchermController hs = new HoofdSchermController(dc);
			Scene scene = new Scene(hs, 400, 300);
			Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
			primaryStage.getIcons().add(icon);
			primaryStage.setScene(scene);
			primaryStage.setTitle("SOKOBAN");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		Taal taal = new Taal();
		DomeinController dc = new DomeinController();
		SokobanApplicatie sa = new SokobanApplicatie(dc);
		
		sa.run();    //run methode van sokobanapplicatie wordt uitgevoerd
		
//		launch(args);
	}
	

}