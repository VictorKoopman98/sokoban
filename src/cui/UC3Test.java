package cui;

import java.util.InputMismatchException;
import java.util.Scanner;

import domein.DomeinController;
import gui.Taal;

public class UC3Test
{
	public static void geefSpelNamen(DomeinController domeincontroller, Taal taalObj) {
        Scanner input = new Scanner(System.in);
        String[] spelnamen = domeincontroller.geefSpelNamen();
        int keuze = 0;
        boolean validatie = false;
        String stoppen = "";
        System.out.println("---" + taalObj.getText("Hoe Spelen")+"---");
        System.out.println(taalObj.getText("Uitleg "));
        do {
            try {
                System.out.print(taalObj.getText("Vraag stoppen") + " ");
                stoppen = input.next();
                if (!stoppen.equals("Yes") && !stoppen.equals("No")) {
                    throw new IllegalArgumentException();
                }
                if (stoppen.equals("Y")) {
                    UC1Test.menu(domeincontroller, taalObj);
                }
                validatie = true;
            } catch (IllegalArgumentException ie) {
                System.out.println(taalObj.getText("Buiten Bereik"));
            }
        } while (!validatie);
        validatie = false;
        System.out.printf("-----%s-----%n", taalObj.getText("spelLijst"));
        for (String spelnamen1 : spelnamen) {
            System.out.printf("%s%n", spelnamen1);
        }
        do {
            System.out.printf("%s : ", taalObj.getText("Maak keuze"));
            try {
                keuze = input.nextInt();
                if (keuze > domeincontroller.geefAantalSpellen() || keuze < 1) {
                    throw new IllegalArgumentException(taalObj.getText("Buiten bereik"));
                }
                validatie = true;
            } catch (InputMismatchException ie) {
                System.out.println(taalObj.getText("Geen getal"));
                input.next();
            } catch (IllegalArgumentException ie) {
                System.out.println(ie.getMessage());
            }
        } while (validatie == false);

        domeincontroller.kiesSpel(keuze);
        domeincontroller.resetAlleSpelborden();
        do {
            try {
                System.out.print(taalObj.getText("Vraag stoppen") + " ");
                stoppen = input.next();
                if (!stoppen.equals("Y") && !stoppen.equals("N")) {
                    throw new IllegalArgumentException();
                }
                if (stoppen.equals("Y")) {
                    UC1Test.menu(domeincontroller, taalObj);
                }
                validatie = true;
            } catch (IllegalArgumentException ie) {
                System.out.println(taalObj.getText("Buiten bereik"));
            }
        } while (!validatie);

        System.out.println(taalObj.getText("Gekozen voor") + " " + domeincontroller.toonSpelNaam());
    }

    public static void speelSpel(DomeinController domeincontroller, Taal taalObj) {
        Scanner input = new Scanner(System.in);
        boolean validatie = false;
        String richting;
        String stoppen = "";
        for (int i = 1; i < domeincontroller.geefAantalSpelborden() + 1; i++) {

        	domeincontroller.kiesSpelbord(i);

            do {

                System.out.println(toonSpelbord(domeincontroller));
                System.out.print(taalObj.getText("richting") + ": ");
                try {
                    richting = input.next();
                    if (!richting.equals("links") && !richting.equals("rechts") && !richting.equals("boven") && !richting.equals("onder") && !richting.equals("reset") && !richting.equals("stop")) {
                        throw new InputMismatchException();
                    }
                    
                    if (richting.equals("reset")) {
                    	domeincontroller.resetSpelbord();
                    }
                    else if(richting.equals("stop"))
                        UC1Test.menu(domeincontroller, taalObj);
                    else {
                    	domeincontroller.verplaatsMan(richting);
                        toonAantalVerplaatsingen(domeincontroller, taalObj);
                    }
                    if (domeincontroller.isSpelbordVoltooid()) {
                        System.out.println(toonSpelbord(domeincontroller));
                        do {
                            try {
                                System.out.print(taalObj.getText("Vraag stoppen") + " ");
                                stoppen = input.next();
                                if (!stoppen.equals("Y") && !stoppen.equals("N")) {
                                    throw new IllegalArgumentException();
                                }
                                if (stoppen.equals("Y")) {
                                    UC1Test.menu(domeincontroller, taalObj);
                                }
                                validatie = true;
                            } catch (IllegalArgumentException ie) {
                                System.out.println(taalObj.getText("Buiten bereik"));
                            }
                        } while (!validatie);
                        
                        System.out.printf("Aantal voltooide spelborden : %d%n", domeincontroller.geefAantalVoltooideSpelborden());
                        System.out.printf("Aantal spelborden : %d%n", domeincontroller.geefAantalSpelborden());
                    }
                } catch (InputMismatchException ie) {
                    System.out.println(taalObj.getText("verkeerderichting"));
                }
            } while (!(domeincontroller.isSpelbordVoltooid() && validatie == true));
        }
        System.out.printf("%n%s %s%n",domeincontroller.toonSpelNaam(),taalObj.getText("voltooid"));
        domeincontroller.resetAlleSpelborden();
    }

    public static void toonAantalVerplaatsingen(DomeinController dc, Taal taalObj) {
        System.out.printf("%s: %d%n", taalObj.getText("aantalverplaatsingen"), dc.geefAantalVerplaatsingen());
    }

    private static String toonSpelbord(DomeinController domeincontroller) {
        String[][] spelbord = domeincontroller.toonSpelbord();
        String output = "";
        for (int i = 0; i < spelbord.length; i++) {
            for (int j = 0; j < spelbord[i].length; j++) {
                output += String.format("%s  ", spelbord[i][j]);
                if (j == 9) {
                    output += String.format("%n");
                }
            }

        }
        return output;
    }
	
}
