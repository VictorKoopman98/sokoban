package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TaalSchermController extends GridPane{
	@FXML
	private Button btnNederlands;
	@FXML
	private Button btnFran�ais;
	@FXML
	private Button btnEnglish;
	@FXML
	private Label lblMessage;

	// Domeincontroller toevoegen
	
	// Constructor ==> link tussen controller en FXML-file
	public TaalSchermController() 
	{
		super();
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("TaalScherm.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();
			System.out.println("Taal kiezen...");
		} catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
	}
	
	// Event Listener on Button[#btnNederlands].onAction
	@FXML
	public void btnNederlandsAfhandeling() 
	{
		/**LoginSchermController ls = new LoginSchermController();
		Scene scene = new Scene(ls);
		Stage stage = (Stage)this.getScene().getWindow();
		stage.setScene(scene);
		stage.show();*/
	}
	
	
	// Event Listener on Button[#btnFran�ais].onAction
	@FXML
	public void btnFran�aisAfhandeling() 
	{
		 System.out.println("Le programme se d�roule en Fran�ais.");
	}
	
	// Event Listener on Button[#btnEnglish].onAction
	@FXML
	public void btnEnglishAfhandeling() 
	{
		 System.out.println("Program is running in English.");
	}
}
