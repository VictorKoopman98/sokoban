package gui;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Hoofdpaneel1Controller  extends GridPane
{
	@FXML
	private Button btnSpeelSpel;
	@FXML
	private Button btnAfmelden;
	private DomeinController dc;
	private HoofdSchermController hs;
	private Button btnWijzigSpel;
	private Button btnMaakNieuwSpel;
	

	public Hoofdpaneel1Controller(DomeinController dc, HoofdSchermController hs)
	{
		super();
		this.dc = dc;
		this.hs = hs;
		
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Hoofdpaneel1.fxml"));
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
	
		if(dc.isAdmin())
		{
			btnWijzigSpel = new Button("Wijzig spel");
			this.add(btnWijzigSpel, 0, 1, 2, 1);
			btnMaakNieuwSpel = new Button("Maak nieuw spel");
			this.add(btnMaakNieuwSpel, 0, 2, 2, 1);
		}
		
		btnWijzigSpel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{
				hs.update(new SpelwijzigenController(dc, hs));
			}
		});
		
		btnMaakNieuwSpel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{
				hs.update(new SpelMakenSchermController(dc, hs));
			}
		});
	}
	
	// Event Listener on Button[#btnSpeelSpel].onAction
	@FXML
	public void btnSpeelSpelAfhandeling(ActionEvent event) 
	{
		hs.update(new Hoofdpaneel2Controller(dc, hs));
	}
	// Event Listener on Button[#btnAfmelden].onAction
	@FXML
	public void btnAfmeldenAfhandeling(ActionEvent event) 
	{
		hs.update(new AanRegController(dc, hs));
	}
}
