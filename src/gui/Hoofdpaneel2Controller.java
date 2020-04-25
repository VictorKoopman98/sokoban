package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import domein.DomeinController;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

public class Hoofdpaneel2Controller extends GridPane
{
	@FXML
	private ComboBox cmbSpelltjes;
	@FXML
	private Button btnVerlaten;
	private DomeinController dc;
	private HoofdSchermController hs;
	private Hoofdpaneel1Controller hp1;
	
	
	
	public Hoofdpaneel2Controller(DomeinController dc, HoofdSchermController hs)
	{
		super();
		this.dc = dc;
		this.hs = hs;
		hp1 = new Hoofdpaneel1Controller(dc, hs);
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Hoofdpaneel2.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();
		} catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
	}

	// Event Listener on ComboBox[#cmbSpelltjes].onAction
	@FXML
	public void cmbSpelletjesAfhandeling(ActionEvent event) 
	{
		
	}
	// Event Listener on Button[#btnVerlaten].onAction
	@FXML
	public void btnVerlatenAfhandeling(ActionEvent event) 
	{
		hs.update(hp1);
	}
}
