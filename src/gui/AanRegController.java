package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import domein.DomeinController;
import javafx.event.ActionEvent;

public class AanRegController extends GridPane
{
	@FXML
	private Button btnAanmelden;
	@FXML
	private Button btnRegistreren;
	private DomeinController dc;
	private TaalSchermController ts;
	private LoginRegistreerSchermController ls;
	private HoofdSchermController hs;
	
	public AanRegController(DomeinController dc, HoofdSchermController hs)
	{
		this.dc = dc;
		this.hs = hs;
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AanReg.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();
		} catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
	}

	// Event Listener on Button[#btnAanmelden].onAction
	@FXML
	public void btnAanmeldenAfhandeling(ActionEvent event) 
	{
		ls = new LoginRegistreerSchermController(dc,hs,2);
		hs.update(ls);
	}
	// Event Listener on Button[#btnRegistreren].onAction
	@FXML
	public void btnRegistrerenAfhandeling(ActionEvent event) 
	{
		hs.update(ls);
		ls = new LoginRegistreerSchermController(dc,hs,4);

	}
}
