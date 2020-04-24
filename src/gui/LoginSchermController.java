package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class LoginSchermController extends GridPane {
	@FXML
	private Button btnMeldAan;
	@FXML
	private Button btnRegistreren;
	@FXML
	private Label lblMessage;
	@FXML
	private TextField txfGebruikersnaam;
	@FXML
	private TextField txfWachtwoord;

	public LoginSchermController() 
	{
		super();
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScherm.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();
		} catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
	}
	
	// Event Listener on Button[#btnMeldAan].onAction
	@FXML
	public void btnMeldAanAfhandeling(ActionEvent event) {
		System.out.println("Aangemeld.");
	}
	// Event Listener on Button[#btnRegistreren].onAction
	@FXML
	public void btnRegistrerenAfhandeling(ActionEvent event) {
		System.out.println("Registratie in behandeling...");
	}
}
