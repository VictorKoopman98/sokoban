package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.InputMismatchException;
import java.util.Optional;

import domein.DomeinController;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class maakNieuwSpelbordSchermController extends GridPane
{
	@FXML
	private ImageView ivMuur;
	@FXML
	private ImageView ivMan;
	@FXML
	private ImageView ivDoel;
	@FXML
	private ImageView ivKist;
	@FXML
	private ImageView ivLeegVeld;
	@FXML
	private GridPane gridSpelbord;
	@FXML
	private Label lblRij;
	@FXML
	private Label lblKolom;
	@FXML
	private TextField txfRij;
	@FXML
	private TextField txfKolom;
	@FXML
	private Button btnToevoegen;
	@FXML
	private Button btnOpslaan;
	@FXML
	private Button btnAnnuleren;
	private DomeinController dc;
	private HoofdSchermController hs;
	private int volgnummer;
	private int actie;
	private int optie;
	private int volgnummerTeWijzigenSpelbord;
	
	public maakNieuwSpelbordSchermController(DomeinController dc, HoofdSchermController hs, int volgnummer, int optie, int volgnummerTeWijzigenSpelbord) 
	{
		this.dc = dc;
		this.hs = hs;
		this.volgnummer = volgnummer;
		this.optie = optie;
		this.volgnummerTeWijzigenSpelbord = volgnummerTeWijzigenSpelbord;
		if(optie == 1) {
			dc.maakNieuwSpelbord(volgnummer);
		}
		else if(optie == 2) {
			dc.selecteerSpelbordMetVolgnummer(volgnummerTeWijzigenSpelbord, dc.geefNaamSpel());
		}
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("maakNieuwSpelbordScherm.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();
		} catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
		buildGUI();
	}
	
	private void buildGUI()
	{
		char[][] veldenStrings = dc.geefVelden();
		
		Image muurImage = new Image(getClass().getResourceAsStream("/images/cobble.jpg"));
		Image leegVeldImage = new Image(getClass().getResourceAsStream("/images/grass.jpg"));
		Image doelImage = new Image(getClass().getResourceAsStream("/images/grassDoel.jpg"));
		Image manImage = new Image(getClass().getResourceAsStream("/images/steve.png"));
		Image kistOkImage = new Image(getClass().getResourceAsStream("/images/chestOk.jpg"));
		Image kistImage = new Image(getClass().getResourceAsStream("/images/chestNietOk.jpg"));
		
		ivMuur.setImage(muurImage);
		ivMan.setImage(manImage);
		ivDoel.setImage(doelImage);
		ivKist.setImage(kistImage);
		ivLeegVeld.setImage(leegVeldImage);
		
		lblRij.setText(Taal.getText("rij"));
		lblKolom.setText(Taal.getText("kolom"));
		btnToevoegen.setText(Taal.getText("toevoegen"));
		btnOpslaan.setText(Taal.getText("opslaan"));
		btnAnnuleren.setText(Taal.getText("annuleren"));
				
		lblRij.setVisible(false);
		lblKolom.setVisible(false);
		txfRij.setVisible(false);
		txfRij.setPrefWidth(40);
		txfKolom.setPrefWidth(40);
		txfKolom.setVisible(false);
		btnToevoegen.setVisible(false);
				
		for (int i = 1; i < 11; i++)
		{
			for (int j = 1; j < 11; j++)
			{
				switch(veldenStrings[i-1][j-1])
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

	// Event Listener on ImageView[#ivMuur].onMouseClicked
	@FXML
	public void ivMuurAfhandeling(MouseEvent event) {
		// TODO Autogenerated
		lblRij.setVisible(true);
		lblKolom.setVisible(true);
		txfRij.setVisible(true);
		txfKolom.setVisible(true);
		btnToevoegen.setVisible(true);
		actie = 2;
	}
	// Event Listener on ImageView[#ivMan].onMouseClicked
	@FXML
	public void ivManAfhandeling(MouseEvent event) {
		// TODO Autogenerated
		lblRij.setVisible(true);
		lblKolom.setVisible(true);
		txfRij.setVisible(true);
		txfKolom.setVisible(true);
		btnToevoegen.setVisible(true);
		actie = 3;
	}
	// Event Listener on ImageView[#ivDoel].onMouseClicked
	@FXML
	public void ivDoelAfhandeling(MouseEvent event) {
		// TODO Autogenerated
		lblRij.setVisible(true);
		lblKolom.setVisible(true);
		txfRij.setVisible(true);
		txfKolom.setVisible(true);
		btnToevoegen.setVisible(true);
		actie = 1;
	}
	// Event Listener on ImageView[#ivKist].onMouseClicked
	@FXML
	public void ivKistAfhandeling(MouseEvent event) {
		// TODO Autogenerated
		lblRij.setVisible(true);
		lblKolom.setVisible(true);
		txfRij.setVisible(true);
		txfKolom.setVisible(true);
		btnToevoegen.setVisible(true);
		actie = 4;
	}
	// Event Listener on ImageView[#ivLeegVeld].onMouseClicked
	@FXML
	public void ivLeegVeldAfhandeling(MouseEvent event) {
		// TODO Autogenerated
		lblRij.setVisible(true);
		lblKolom.setVisible(true);
		txfRij.setVisible(true);
		txfKolom.setVisible(true);
		btnToevoegen.setVisible(true);
		actie = 5;
	}
	// Event Listener on Button[#btnToevoegen].onAction
	@FXML
	public void btnToevoegenAfhandeling(ActionEvent event) 
	{
		try {
			dc.wijzigSpelbord(Integer.parseInt(txfRij.getText()) - 1, Integer.parseInt(txfKolom.getText()) - 1, actie);
			buildGUI();
		}
		catch(NumberFormatException e)
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(Taal.getText("getalIngeven"));
			alert.showAndWait();
		}
		catch(IllegalArgumentException e)
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
		catch(InputMismatchException e)
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(Taal.getText("getalIngeven"));
			alert.showAndWait();
		}
	}
	// Event Listener on Button[#btnOpslaan].onAction
	@FXML
	public void btnOpslaanAfhandeling(ActionEvent event) 
	{
		if(optie == 1) {
			try {
				dc.voegSpelbordToe(dc.geefVelden(), volgnummer, dc.geefNaamSpel());
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText(Taal.getText("volgendSpelbordToevoegen"));
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK)
				{
					Scene scene = new Scene(new maakNieuwSpelbordSchermController(dc, hs, ++volgnummer, 1, 2), 1200, 700);
					Stage stage = (Stage) this.getScene().getWindow();
					stage.setScene(scene);
					stage.show();
				}
				if (result.get() == ButtonType.CANCEL) {
					Hoofdpaneel1Controller hp1 = new Hoofdpaneel1Controller(dc, hs);
					Stage stage = (Stage) (getScene().getWindow());
					stage.setScene(hs.getScene());
					hs.update(hp1);
				}
			}
			catch(IllegalArgumentException e) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText(String.format("%s%n%s",e.getMessage(),Taal.getText("spelbordVerwijderenOfWijzigenGui")));
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.CANCEL)
				{
					if (dc.geefAantalSpelborden() == 0)
					{
						Alert alert2 = new Alert(AlertType.CONFIRMATION);
						alert2.setContentText(String.format("%s%n%s", Taal.getText("minstens1Spelbord"), Taal.getText("spelVerwijderenOfWijzigenGui")));
						Optional<ButtonType> result2 = alert2.showAndWait();
						if (result2.get() == ButtonType.CANCEL)
						{
							dc.verwijderSpel(dc.geefNaamSpel());
							Hoofdpaneel1Controller hp1 = new Hoofdpaneel1Controller(dc, hs);
							Stage stage = (Stage) (getScene().getWindow());
							stage.setScene(hs.getScene());
							hs.update(hp1);
						}
					}
				}
			}
		}else if(optie == 2) {
			try {
				dc.updateSpelbord(volgnummerTeWijzigenSpelbord, dc.geefVelden(),dc.geefNaamSpel());
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText(Taal.getText("spelbordBijgewerkt"));
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK)
				{
					Hoofdpaneel1Controller hp1 = new Hoofdpaneel1Controller(dc, hs);
					Stage stage = (Stage) (getScene().getWindow());
					stage.setScene(hs.getScene());
					hs.update(hp1);
				}
			}catch(IllegalArgumentException e) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText(String.format("%s%n%s",e.getMessage(),Taal.getText("ongedaanMakenOfVerderAanpassenGui")));
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.CANCEL)
				{
					Hoofdpaneel1Controller hp1 = new Hoofdpaneel1Controller(dc, hs);
					Stage stage = (Stage) (getScene().getWindow());
					stage.setScene(hs.getScene());
					hs.update(hp1);
				}
			}
		}
	}
	// Event Listener on Button[#btnAnnuleren].onAction
	@FXML
	public void btnAnnulerenAfhandeling(ActionEvent event) 
	{
		Hoofdpaneel1Controller hp1 = new Hoofdpaneel1Controller(dc, hs);
		Stage stage = (Stage) (getScene().getWindow());
		stage.setScene(hs.getScene());
		hs.update(hp1);
	}
}
