/**
 * 
 */
package ayvazyanbelinic;

import org.apache.commons.cli2.*;
import org.apache.commons.cli2.builder.*;
import org.apache.commons.cli2.commandline.Parser;



/**
 * Verwaltet die Optionen und deren Argumente.
 * @author Vennesa Belinic
 * @version 2013-09-26
 */
public class MyCommandLine {

	
	//Attribut(e)
	
	/**
	 * Das Verzeichnis vom Lager
	 */
	private String lagerVerzeichnis;
	
	/**
	 * Das Verzeichnis des Log-Files
	 */
	private String logVerzeichnis;
	
	/**
	 * Die Anzahl der Lieferanten Threads.
	 * min 1 , max 10000
	 */
	private int lieferantenAnzahl;
	
	/**
	 * Die Anzahl der Monteure Threads.
	 * min 1 , max 10000
	 */
	private int monteurAnzahl;
	
	/**
	 * Die Anzahl der Lagermitarbeiter Threads.
	 * min 1 , max 10000
	 */
	private int lagerMitarbeiterAnzahl;
	
	/**
	 * Die Laufzeit in Milisekunden.
	 * min 1000 , max 10000000
	 */
	private int laufzeit;
	
	
	
	
	//Konstruktor(en)
	
	/**
	 * Der Konstruktor initialisiert alle Attribut
	 * @param args Dort befinden sich die Optionen und Argumente die vom CLI übergeben werden
	 * @throws IllegalNubmberOfLieferantenException Wird geworfen wenn, eine üngültige Anzahl von Lieferanten eingegeben wurde
	 * @throws IllegalNubmberOfMonteureException Wird geworfen wenn, eine üngültige Anzahl von Monteuren eingegeben wurde
	 * @throws IllegalLaufzeitException Wird geworfen wenn, eine üngültige Laufzeit eingegeben wurde
	 * @throws IllegalNumberOfLMException Wird geworfen wenn, eine üngültige Anzahl von Lagermitarbeiter eingegeben wurde
	 */
	public MyCommandLine(String[] args) {

		DefaultOptionBuilder obuilder = new DefaultOptionBuilder();
		ArgumentBuilder abuilder = new ArgumentBuilder();
		GroupBuilder gbuilder = new GroupBuilder();
		
		/*
		 * Hier werden die Optionen gebildet, immer mit einem longName(wenn --name) und einem shortName(wenn -n),
		 * einer passenden Beschreibung der Option und einer passenden Beschreibung zum Argument.
		 */
		
		Option oLagerVerzeichnis = obuilder.withLongName("lager").withShortName("l").withDescription("Verzeichnis der Lagers")
				.withArgument(abuilder.withName("verzeichnis").withMinimum(1).withMaximum(1).create()).create();
		
		Option oLogVerzeichnis = obuilder.withLongName("logs").withShortName("o").withDescription("Verzeichnis des Log-Files")
				.withArgument(abuilder.withName("verzeichnis").withMinimum(1).withMaximum(1).create()).create();
		
		Option oLieferantenAnzahl = obuilder.withLongName("lieferanten").withShortName("i").withDescription("Anzahl der Lieferanten Threads")
				.withArgument(abuilder.withName("anzahl").withMinimum(1).withMaximum(1).create()).create();
		
		Option oMonteurAnzahl = obuilder.withLongName("monteure").withShortName("m").withDescription("Anzahl der Monteur Threads")
				.withArgument(abuilder.withName("anzahl").withMinimum(1).withMaximum(1).create()).create();
		
		Option oLagerMitarbeiterAnzahl = obuilder.withLongName("lagermitarbeiter").withShortName("a").withDescription("Anzahl der Lagermitarbeiter Threads")
				.withArgument(abuilder.withName("anzahl").withMinimum(1).withMaximum(1).create()).create();
		
		Option oLaufzeit = obuilder.withLongName("laufzeit").withShortName("t").withDescription("Laufzeit in Millisekunden")
				.withArgument(abuilder.withName("sekunden").withMinimum(1).withMaximum(1).create()).create();
		
		Group options = gbuilder.withName("options").withOption(oLagerVerzeichnis).withOption(oLogVerzeichnis)
				.withOption(oLieferantenAnzahl).withOption(oMonteurAnzahl).withOption(oLaufzeit).create();
		
		Parser parser = new Parser();
		parser.setGroup(options);
		
		
		/*
		 * Hier werden die Optionen und Argumente aus der args-Variable ausgelesen, und mit entsprechenden
		 * Meldungen und Exceptions verwaltet.
		 */
		
		try {
			CommandLine cl = parser.parse(args);
			
			if(cl.hasOption(oLagerVerzeichnis))
				this.lagerVerzeichnis = (String) cl.getValue(oLagerVerzeichnis);
			
			if(cl.hasOption(oLogVerzeichnis))
				this.logVerzeichnis = (String) cl.getValue(oLogVerzeichnis);
				
			if(cl.hasOption(oLieferantenAnzahl)) {
				try {
					this.lieferantenAnzahl = (int) cl.getValue(oLieferantenAnzahl);
					if(this.lieferantenAnzahl <= 0 || this.lieferantenAnzahl > 10000)
						throw new IllegalNubmberOfLieferantenException();
				} catch(ClassCastException e) {
					System.out.println(cl.getValue(oLieferantenAnzahl).toString() + " ist keine Zahl!");
				}
			}
			
			if(cl.hasOption(oMonteurAnzahl)) {
				try {
					this.monteurAnzahl = (int) cl.getValue(oMonteurAnzahl);
					if(this.monteurAnzahl <= 0 || this.monteurAnzahl > 10000)
						throw new IllegalNubmberOfMonteureException();
				} catch(ClassCastException e) {
					System.out.println(cl.getValue(oMonteurAnzahl).toString() + " ist keine Zahl!");
				}
			}
			
			if(cl.hasOption(oLagerMitarbeiterAnzahl)) {
				try {
					this.lagerMitarbeiterAnzahl = (int) cl.getValue(oLagerMitarbeiterAnzahl);
					if(this.lagerMitarbeiterAnzahl <= 0 || this.lagerMitarbeiterAnzahl > 10000)
						throw new IllegalNubmberOfLMException();
				} catch(ClassCastException e) {
					System.out.println(cl.getValue(oLagerMitarbeiterAnzahl).toString() + " ist keine Zahl!");
				}
			} else
				this.lagerMitarbeiterAnzahl=1;
			
			if(cl.hasOption(oLaufzeit)) {
				try {
					this.laufzeit = (int) cl.getValue(oLaufzeit);
					if(this.monteurAnzahl < 1000 || this.monteurAnzahl > 10000000)
						throw new IllegalLaufzeitException();
				} catch(ClassCastException e) {
					System.out.println(cl.getValue(oLaufzeit).toString() + " ist keine Zahl!");
				}
			}
		} catch(OptionException e) {
			System.out.println("Es ist ein Fehler beim Verarbeiten der Argumente Aufgetreten!");
		}
			
	}

	
	
	
	//Methode(n)
	
	/**
	 * Gibt das Verzeichnis des Lagers als String zurück
	 * @return Verzeichnis des Lagers als String
	 */
	public String getLagerVerzeichnis() {
		return lagerVerzeichnis;
	}

	/**
	 * Gibt das Verzeichnis des Log-Files als String zurück
	 * @return  Verzeichnis des Log-Files als String
	 */
	public String getLogVerzeichnis() {
		return logVerzeichnis;
	}

	/**
	 * Gibt die Anzahl der Lieferanten als int zurück
	 * @return Anzahl der Lieferanten als int
	 */
	public int getLieferantenAnzahl() {
		return lieferantenAnzahl;
	}

	/**
	 * Gibt die Anzahl der Monteure als int zurück
	 * @return Anzahl der Monteure als int
	 */
	public int getMonteurAnzahl() {
		return monteurAnzahl;
	}
	
	/**
	 * Gibt die Anzahl der LagerMitarbeiter als int zurück
	 * @return Anzahl der LagerMitarbeiter als int
	 */
	public int getLagerMitarbeiterAnzahl() {
		return monteurAnzahl;
	}

	/**
	 * Gibt die Lafzeit in Millisekunden als int zurück
	 * @return Lafzeit in Millisekunden als int
	 */
	public int getLaufzeit() {
		return laufzeit;
	}

		
}

