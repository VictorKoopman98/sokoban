package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domein.DomeinController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

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
	public void btnWijzigAfhandeling(ActionEvent event) {
		// TODO Autogenerated
		String gekozenSpel = cmbSpellen.getSelectionModel().getSelectedItem();
		dc.selecteerSpel(gekozenSpel);
		dc.selecteerSpelbordMetVolgnummer(cmbSpelborden.getSelectionModel().getSelectedIndex() + 1, gekozenSpel);
		
	}
	@FXML
	public void btnTerugAfhandeling(ActionEvent event) {
		hs.update(new Hoofdpaneel1Controller(dc, hs));
	}
}
