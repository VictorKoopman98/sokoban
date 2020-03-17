package cui;

import java.util.InputMismatchException;
import java.util.Scanner;

import domein.DomeinController;
import gui.Taal;

public class UC1Test
{
	private final  DomeinController dc;
	
	public UC1Test (DomeinController dc) 
	{
		this.dc =dc;
	}
	
	public void meldAan()
	{
		Scanner input = new Scanner(System.in);
		String gebruikersnaam = "";
		String wachtwoord = "";
//		String stoppen = "";
//		SokobanApplicatie sb;
		boolean blijvenHerhalenFlag;
       
//		blijft herhalen zolang flag = true maar indien wachtwoord en gebruikersnaam juist zijn => flag wordt false,
//		anders skipt het die stap en gaat direct naar exceptions.
		
		blijvenHerhalenFlag = true;
		
            do
            {
                try
                {
                    System.out.print("\nGebruikersnaam: ");
                    gebruikersnaam = input.next();

                    System.out.print("\nWachtwoord: ");
                    wachtwoord = input.next();
                    
                   dc.meldAan(gebruikersnaam, wachtwoord);

                    blijvenHerhalenFlag = false;
                } 
                
                catch (IllegalArgumentException e)
                {
                    System.err.println(e);
                    
                    //e.printStackTrace();
                } 
                
            } while (blijvenHerhalenFlag);	
	}
	 public static void menu(DomeinController dc, Taal taalObj) {
	        boolean validatie2 = false;
	        int keuze = 0;
	        Scanner input = new Scanner(System.in);
	        String terug = "";
	        do {
	            System.out.printf("Menu : %n1.%s%n",
	                    taalObj.getText("speelSpel"));

	            if (dc.isAdmin()) {
	                System.out.printf("2.%s%n3.%s%n", taalObj.getText("configureerSpel"), taalObj.getText("wijzigSpel"));
	            }

	            System.out.printf("%s : ", taalObj.getText("maakKeuze"));
	            try {
	                keuze = input.nextInt();
	                if (dc.isAdmin() == false & (keuze != 1 || keuze < 1)) {
	                    throw new IllegalArgumentException(taalObj.getText("buitenBereik"));
	                } else {
	                    if (dc.isAdmin() & (keuze > 3 || keuze < 1)) {
	                        throw new IllegalArgumentException(taalObj.getText("buitenBereik"));
	                    }
	                }
	                validatie2 = true;

	            } catch (InputMismatchException ie) {
	                System.out.println(taalObj.getText("geenGetal"));
	                input.nextLine();
	            } catch (IllegalArgumentException ie) {
	                System.out.println(ie.getMessage());
	            }

	        } while (validatie2 == false);
	        
	        
	        validatie2 = false;
	        if (keuze == 1) {
	            do {
	                UC3Test.geefSpelNamen(dc, taalObj);
	                UC3Test.speelSpel(dc, taalObj);

	                do {
	                    try {
	                        System.out.print(taalObj.getText("Terug naar het Hoofdscherm") + " (Y/N)?");
	                        terug = input.next();
	                        if (!terug.equals("Y") && !terug.equals("N")) {
	                            throw new IllegalArgumentException();
	                        }

	                        validatie2 = true;
	                    } catch (IllegalArgumentException ie) {
	                        System.out.println(taalObj.getText("buitenBereik"));
	                    }
	                } while (!validatie2);

	            } while (!terug.equals("Y"));
	            menu(dc, taalObj);
	        }
	        
	        
	        

	    }
}
