package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domein.DomeinController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SpelwijzigenController extends GridPane
{
	@FXML
	private Label lblSpellen;
	@FXML
	private Label lblSpelborden;
	@FXML
	private ComboBox<String> cmbSpellen;
	@FXML
	private ComboBox<String> cmbSpelborden;
	@FXML
	private Button btnWijzig;
	private DomeinController dc;
	private HoofdSchermController hs;
	@FXML
	private Button btnTerug;
	
	public SpelwijzigenController(DomeinController dc, HoofdSchermController hs)
	{
		this.dc = dc;
		this.hs = hs;
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Spelwijzigen.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();
		} catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
		
		lblSpellen.setText(Taal.getText("promptCboSpelletjes"));
		lblSpelborden.setText(Taal.getText("promptCboSpelbordenGui"));
		cmbSpellen.setPromptText(Taal.getText("promptCboSpelletjes"));
		cmbSpelborden.setPromptText(Taal.getText("promptCboSpelbordenGui"));
		btnWijzig.setText(Taal.getText("wijzigSpelGui"));
		btnTerug.setText(Taal.getText("terugGui"));
		
		
		String[] namen = dc.geefLijstSpellen();
		List<String> namenList = Arrays.asList(namen);
		cmbSpellen.setItems(FXCollections.observableList(namenList));
	}

	// Event Listener on ComboBox[#cmbSpellen].onAction
	@FXML
	public void cmbSpellenAfhandeling(ActionEvent event) 
	{
		String gekozenSpel = cmbSpellen.getSelectionModel().getSelectedItem();
		
		
		int[] volgnummers = dc.geefVolgnummerSpelborden(gekozenSpel);
		List<String> volgnummersLijst = new ArrayList<String>();
		for (int i = 0; i < volgnummers.length; i++)
		{
			volgnummersLijst.add(Integer.toString(volgnummers[i]));
		}
		
		cmbSpelborden.setItems(FXCollections.observableList(volgnummersLijst));
	}
	// Event Listener on Button[#btnWijzig].onAction
	@FXML
	public void btnWijzigAfhandeling(ActionEvent event) 
	{
		try {
			String gekozenSpel = cmbSpellen.getSelectionModel().getSelectedItem();
			dc.selecteerSpel(gekozenSpel);
			
			Scene scene = new Scene(new maakNieuwSpelbordSchermController(dc, hs,1, 2, cmbSpelborden.getSelectionModel().getSelectedIndex() + 1), 1200, 700);
			Stage stage = (Stage) this.getScene().getWindow();
			stage.setScene(scene);
			stage.show();		
		}
		catch(NullPointerException e)
		{
			Alert alert = new Alert(AlertType.ERROR);
			System.out.println(e.getCause());
			alert.setContentText(Taal.getText("spelSelecterenGui"));
			alert.showAndWait();
		}
	}
	@FXML
	public void btnTerugAfhandeling(ActionEvent event) 
	{
		hs.update(new Hoofdpaneel1Controller(dc, hs));
	}
}
