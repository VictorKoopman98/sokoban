package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VoltooiSpelbordSchermController extends GridPane
{
	@FXML
	private GridPane gridSpelbord;
	@FXML
	private Button btnOmlaag;
	@FXML
	private Button btnLinks;
	@FXML
	private Button btnRechts;
	@FXML
	private Button btnOmhoog;
	@FXML
	private Button btnAfsluiten;
	@FXML
	private Label lblAantalVerplaatsingenBoodschap;
	@FXML
	private Label lblAantalVerplaatsingen;
	private DomeinController dc;
	private HoofdSchermController hs;
	@FXML
	private Button btnReset;
	
	public VoltooiSpelbordSchermController(DomeinController dc, HoofdSchermController hs)
	{
		this.dc = dc;
		this.hs = hs;
		
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("VoltooiSpelbordScherm.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();
		} catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
		
		btnOmhoog.setFocusTraversable(false);
		btnRechts.setFocusTraversable(false);
		btnLinks.setFocusTraversable(false);
		btnAfsluiten.setFocusTraversable(false);
		btnReset.setFocusTraversable(false);
		
		btnOmlaag.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				try {
					switch(event.getCode())
					{
					case UP:
						dc.verplaatsMan("omhoog");
						break;
					case DOWN:
						dc.verplaatsMan("omlaag");
						break;
					case LEFT:
						dc.verplaatsMan("links");
						break;
					case RIGHT:
						dc.verplaatsMan("rechts");
						break;
					default:
						break;
					}
				}
				catch(IllegalArgumentException e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText(e.getMessage());
					alert.showAndWait();
				}
				buildGUI();
				if (dc.eindeSpelbordBereikt())
					eindeSpelbordAfhandeling();
			}
		});
		
		
		btnOmlaag.setText(Taal.getText("omlaag"));
		btnOmhoog.setText(Taal.getText("omhoog"));
		btnLinks.setText(Taal.getText("links"));
		btnRechts.setText(Taal.getText("rechts"));		
		lblAantalVerplaatsingenBoodschap.setText(Taal.getText("verplaatsingen"));
		lblAantalVerplaatsingen.setText("0");
		btnAfsluiten.setText(Taal.getText("closeGui"));
		btnReset.setText(Taal.getText("resetGUI"));
		
		buildGUI();
	}
	
	public void buildGUI()
	{
		
		char[][] veldenStrings = dc.geefVelden();
		
		Image muurImage = new Image(getClass().getResourceAsStream("/images/cobble.jpg"));
		Image leegVeldImage = new Image(getClass().getResourceAsStream("/images/grass.jpg"));
		Image doelImage = new Image(getClass().getResourceAsStream("/images/grassDoel.jpg"));
		Image manImage = new Image(getClass().getResourceAsStream("/images/steve.png"));
		Image kistOkImage = new Image(getClass().getResourceAsStream("/images/chestOk.jpg"));
		Image kistImage = new Image(getClass().getResourceAsStream("/images/chestNietOk.jpg"));
		
		lblAantalVerplaatsingen.setText(String.format("%d",dc.geefAantalVerplaatsingen()));
		
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				switch(veldenStrings[i][j])
				{
				case 'X':
					ImageView muur = new ImageView(muurImage);
					muur.setFitHeight(getMaxHeight());
					muur.setFitWidth(getMaxWidth());
					gridSpelbord.add(muur, j, i);
					break;
				case 'M':
					ImageView man = new ImageView(manImage);
					man.setFitHeight(getMaxHeight());
					man.setFitWidth(getMaxWidth());
					gridSpelbord.add(man, j, i);
					break;
				case '?':
					ImageView doel = new ImageView(doelImage);
					doel.setFitHeight(getMaxHeight());
					doel.setFitWidth(getMaxWidth());
					gridSpelbord.add(doel, j, i);
					break;
				case '.':
					ImageView leegVeld = new ImageView(leegVeldImage);
					leegVeld.setFitHeight(getMaxHeight());
					leegVeld.setFitWidth(getMaxWidth());
					gridSpelbord.add(leegVeld, j, i);
					break;
				case 'O':
					ImageView kistOk = new ImageView(kistOkImage);
					kistOk.setFitHeight(getMaxHeight());
					kistOk.setFitWidth(getMaxWidth());
					gridSpelbord.add(kistOk, j, i);
					break;
				case 'K':
					ImageView kist = new ImageView(kistImage);
					kist.setFitHeight(getMaxHeight());
					kist.setFitWidth(getMaxWidth());
					gridSpelbord.add(kist, j, i);
					break;
				}
			}
		}
	}

	// Event Listener on Button[#btnOmlaag].onAction
	@FXML
	public void btnOmlaagAfhandeling(ActionEvent event) {
		// TODO Autogenerated
		try {
			dc.verplaatsMan("omlaag");
			buildGUI();
			if (dc.eindeSpelbordBereikt())
				eindeSpelbordAfhandeling();
		}
		catch(IllegalArgumentException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
		
	}
	// Event Listener on Button[#btnLinks].onAction
	@FXML
	public void btnLinksAfhandeling(ActionEvent event) {
		try {
			dc.verplaatsMan("links");
			buildGUI();
			if (dc.eindeSpelbordBereikt())
				eindeSpelbordAfhandeling();
		}
		catch(IllegalArgumentException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
	// Event Listener on Button[#btnRechts].onAction
	@FXML
	public void btnRechtsAfhandeling(ActionEvent event) {
		try {
			dc.verplaatsMan("rechts");
			buildGUI();
			if (dc.eindeSpelbordBereikt())
				eindeSpelbordAfhandeling();
		}
		catch(IllegalArgumentException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
	// Event Listener on Button[#btnOmhoog].onAction
	@FXML
	public void btnOmhoogAfhandeling(ActionEvent event) {
		try {
			dc.verplaatsMan("omhoog");
			buildGUI();
			if (dc.eindeSpelbordBereikt())
				eindeSpelbordAfhandeling();
		}
		catch(IllegalArgumentException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
	@FXML
	public void btnResetAfhandeling(ActionEvent event) {
//		dc.selecteerSpelbord(dc.geefNaamSpel());
		dc.resetSpelbord(dc.geefNaamSpel(), dc.geefVolgnummer());
		buildGUI();
	}
	// Event Listener on Button[#btnAfsluiten].onAction
	@FXML
	public void btnAfsluitenAfhandeling(ActionEvent event) {
		// TODO Autogenerated
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(Taal.getText("closeGui"));
		alert.setContentText(Taal.getText("alertAfsluitenGui"));
		
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK)
		{
			Hoofdpaneel1Controller hp1 = new Hoofdpaneel1Controller(dc, hs);
			Stage stage = (Stage) (getScene().getWindow());
			stage.setScene(hs.getScene());
			hs.update(hp1);
		}
			
		if (result.get() == ButtonType.CANCEL)
			alert.close();
	}
	
	private void eindeSpelbordAfhandeling()
	{
		Alert alert;
		if (!dc.isSpelVoltooid())
		{
			alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle(Taal.getText("volgendSpelbordTitel"));
			String string = String.format("%n%s %s %d %s",dc.geefGebruikersnaam(), Taal.getText("spelbordVoltooid2"), dc.geefAantalVerplaatsingen(), Taal.getText("verplaatsingen"));
			alert.setContentText(String.format("%s%n%s", string, Taal.getText("volgendSpelbord")));
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK)
			{
				dc.selecteerSpelbord(dc.geefNaamSpel());
				buildGUI();
			}
			if (result.get() == ButtonType.CANCEL)
			{
				Hoofdpaneel1Controller hp1 = new Hoofdpaneel1Controller(dc, hs);
				Stage stage = (Stage) (getScene().getWindow());
				stage.setScene(hs.getScene());
				hs.update(hp1);
			}
		}
		else {
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(Taal.getText("eindeSpelTitel"));
			alert.setContentText(String.format("%s %s", dc.geefGebruikersnaam(), Taal.getText("huidigSpelVoltooid")));
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK)
			{
				Hoofdpaneel1Controller hp1 = new Hoofdpaneel1Controller(dc, hs);
				Stage stage = (Stage) (getScene().getWindow());
				stage.setScene(hs.getScene());
				hs.update(hp1);
			}
		}
		
		
			
		
	}
}