package domein;


import java.util.List;

import domein.Spelbord;
import gui.Taal;
import persistentie.SpelbordMapper;

public class SpelbordRepository 
{
	private SpelbordMapper spelbordMapper;
	private Spelbord spelbord;	
	
	
	/**
	 * Constructor om een SpelbordRepository aan te maken
	 * 
	 */
	public SpelbordRepository() 
	{
		spelbordMapper = new SpelbordMapper();
	}
	
	/**
	 * Methode om het spelbord terug te geven
	 * 
	 * @param spelnaam naam van het spelbord dat gekozen wordt
	 * @return geeft het spelbord terug
	 */
	public Spelbord geefSpelbord(String spelnaam) 
	{
		Spelbord spelbord = spelbordMapper.geefSpelbord(spelnaam);
		if (spelbord != null) 
		{ 
			return spelbord;
		}
		return null;
	}
	
	/**
     * Methode om het volgnummer van het spelbord terug te geven
     * 
     * @return geeft volgnummer terug
     */
	public int geefVolgnummer() {
		return spelbord.getVolgnummer();
	}
	
	/**
     * Methode om een spelbord toe te voegen aan een spel.
     *
     */
	public void voegSpelbordToe(char[][] velden, int volgnummer, String spelnaam) 
	{
		spelbordMapper.voegSpelbordToe(volgnummer, velden, spelnaam);
	}
	
	/**
	 * Methode om lijst van spelborden terug te geven met een bepaalde naam
	 * 
	 * @param spelnaam namen van de spelborden dat gekozen wordt
	 * @return geeft lijst van spelborden terug
	 */
	public  List<Spelbord> geefSpelbordenLijst(String spelnaam)
	{
		return spelbordMapper.geefSpelborden(spelnaam); 
	}
	
	/**
	 * Methode om spelborden met volgnummer met een bepaald volgnummer en spelnaam terug te geven
	 * @param volgnummer volgnummer van het spelbord dat gekozen wordt
	 * @param spelnaam naam van het spelbord dat gekozen wordt
	 * @return geeft spelborden met een bepaald volgnummer terug
	 */
	public Spelbord geefSpelbordMetVolgnummer(int volgnummer, String spelnaam)
	{
		return spelbordMapper.geefSpelbordMetVolgnummer(volgnummer, spelnaam);
	}
	

	/**
	 *  Methode om het spelborden up to date nadat een wijziging is toegebracht
	 *  
	 */
	public void updateSpelbord(int volgnummer, char[][] velden, String spelnaam)
	{
		spelbordMapper.updateSpelbord(volgnummer, velden, spelnaam);
	}
	
	 /**
     * Methode om het spelbord te verwijderen met bepaalde naam en volgnummer
     * 
     * @param volgnummer volgnummer van het spel dat verwijdert moet worden
     * @param naamSpel gekozen naam van het spel dat verwijdert moet worden
     */
	public void verwijderSpelbord(int volgnummer, String spelNaam)
	{
		spelbordMapper.verwijderSpelbord(volgnummer, spelNaam);
	}
}