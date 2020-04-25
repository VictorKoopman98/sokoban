package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import domein.DomeinController;
import javafx.event.ActionEvent;

public class LoginRegistreerSchermController  extends GridPane{
	@FXML
	private Button btnLoginRegistreer;
	private DomeinController dc;
	private HoofdSchermController hs;
	private int aantalRijen;
	private Label lblGebruikersnaam, lblWachtwoord, lblNaam,lblVoornaam;
	private TextField txfGebruikersnaam, txfWachtwoord, txfNaam, txfVoornaam;
	private Hoofdpaneel1Controller hp1;
	
	public LoginRegistreerSchermController(DomeinController dc, HoofdSchermController hs, int aantalRijen)
	{	
		super();
		this.dc = dc;
		this.hs = hs;
		this.aantalRijen = aantalRijen;
		hp1 = new Hoofdpaneel1Controller(dc, hs);
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginRegistreerScherm.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();
		} catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
		buildGui();
	}
	
	private void buildGui()
	{
		Label[] arrayLabel = {lblGebruikersnaam,lblWachtwoord,lblNaam,lblVoornaam};
		String[] waardeLabel = {Taal.getText("geefGebruikersnaam"), Taal.getText("geefWachtwoord"), Taal.getText("naam"), Taal.getText("voornaam")};
		TextField[] arrayTextField = {txfGebruikersnaam, txfWachtwoord, txfNaam, txfVoornaam};
		for(int i = 0; i < aantalRijen; i++)
		{
			arrayLabel[i] = new Label(waardeLabel[i]);
			this.add(arrayLabel[i], 0, i);
			arrayTextField[i] = new TextField();
			this.add(arrayTextField[i], 1, i);
		}
		if(aantalRijen == 4)
			btnLoginRegistreer.setText("Registreer");
		else
			btnLoginRegistreer.setText("Meld aan");
	}

	// Event Listener on Button[#btnLoginRegistreer].onAction
	@FXML
	public void btnLoginRegistreerAfhandeling(ActionEvent event) 
	{
		hs.update(hp1);
	}
}
