package gui;

import domein.DomeinController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class HoofdSchermController extends BorderPane
{
	private DomeinController dc;
	private TaalSchermController ts;
	
	public HoofdSchermController(DomeinController dc)
	{
		this.dc = dc;
		ts = new TaalSchermController(dc, this);
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("HoofdScherm.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();
		} catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
		this.setCenter(ts);
	}
	
	public void update(Pane scherm)
	{
		this.setCenter(scherm);
	}
}
