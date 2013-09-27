/**
 * 
 */
package ayvazyanbelinic;

import org.apache.commons.cli2.*;
import org.apache.commons.cli2.builder.*;
import org.apache.commons.cli2.commandline.Parser;



/**
 * Verwaltet die Optionen und deren Argumente.
 * Es sind 6 Optionen möglich(--lager, --logs, --lieferanten, --monteure, --laufzeit, --lagermitarbeiter).
 * Alle Optionen bis auf --lagermitarbeiter sind verpflichtend.
 * Es gibt auchh von alle Optionen Kurzformen(siehe Field Summary).
 * Bei allen Optionen sind Argumente verpflichtend.
 * Bei den Argumenten von --lager und --logs handelt es sich um Strings, also Text,
 * bei allen anderen Optionen sind die Argumente Zahlen(Gueltigkeitsbereich siehe Field Summary).
 * Die Reihenfolge der Optionen spielt keine Rolle.
 * @author Vennesa Belinic
 * @version 2013-09-26
 */
public class MyCommandLine {

	
	//Attribut(e)
	
	/**
	 * Das Verzeichnis vom Lager.
	 * Langform: --lager | Kurzform: -l
	 */
	private String lagerVerzeichnis;
	
	/**
	 * Das Verzeichnis des Log-Files.
	 * Langform: --logs | Kurzform: -o
	 */
	private String logVerzeichnis;
	
	/**
	 * Die Anzahl der Lieferanten Threads.
	 * Langform: --lieferanten | Kurzform: -i
	 * Gueltigkeitsbereich: min 1 , max 100000
	 */
	private int lieferantenAnzahl;
	
	/**
	 * Die Anzahl der Monteure Threads.
	 * Langform: --monteure | Kurzform: -m
	 * Gueltigkeitsbereich: min 1 , max 100000
	 */
	private int monteurAnzahl;
	
	/**
	 * Die Anzahl der Lagermitarbeiter Threads.
	 * Langform: --lagermitarbeiter | Kurzform: -a
	 * Gueltigkeitsbereich: min 1 , max 100000
	 */
	private int lagerMitarbeiterAnzahl;
	
	/**
	 * Die Laufzeit in Milisekunden.
	 * Langform: --laufzeit | Kurzform: -t
	 * Gueltigkeitsbereich: min 1000 , max 100000000
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
	public MyCommandLine(String[] args) throws OptionException{

		DefaultOptionBuilder obuilder = new DefaultOptionBuilder();
		ArgumentBuilder abuilder = new ArgumentBuilder();
		GroupBuilder gbuilder = new GroupBuilder();
		
		/*
		 * Hier werden die Optionen gebildet, immer mit einem longName(wenn --name) und einem shortName(wenn -n),
		 * einer passenden Beschreibung der Option und einer passenden Beschreibung zum Argument.
		 */
		
		Option oLagerVerzeichnis = obuilder.withLongName("lager").withShortName("l").withRequired(true).withDescription("Verzeichnis der Lagers")
				.withArgument(abuilder.withName("verzeichnis").withMinimum(1).withMaximum(1).create()).create();
		
		Option oLogVerzeichnis = obuilder.withLongName("logs").withShortName("o").withRequired(true).withDescription("Verzeichnis des Log-Files")
				.withArgument(abuilder.withName("verzeichnis").withMinimum(1).withMaximum(1).create()).create();
		
		Option oLieferantenAnzahl = obuilder.withLongName("lieferanten").withShortName("i").withRequired(true).withDescription("Anzahl der Lieferanten Threads")
				.withArgument(abuilder.withName("anzahl").withMinimum(1).withMaximum(1).create()).create();
		
		Option oMonteurAnzahl = obuilder.withLongName("monteure").withShortName("m").withRequired(true).withDescription("Anzahl der Monteur Threads")
				.withArgument(abuilder.withName("anzahl").withMinimum(1).withMaximum(1).create()).create();
		
		Option oLagerMitarbeiterAnzahl = obuilder.withLongName("lagermitarbeiter").withShortName("a").withRequired(false).withDescription("Anzahl der Lagermitarbeiter Threads")
				.withArgument(abuilder.withName("anzahl").withMinimum(1).withMaximum(1).create()).create();
		
		Option oLaufzeit = obuilder.withLongName("laufzeit").withShortName("t").withRequired(true).withDescription("Laufzeit in Millisekunden")
				.withArgument(abuilder.withName("sekunden").withMinimum(1).withMaximum(1).create()).create();
		
		Group options = gbuilder.withName("options").withOption(oLagerVerzeichnis).withOption(oLogVerzeichnis)
				.withOption(oLieferantenAnzahl).withOption(oMonteurAnzahl).withOption(oLagerMitarbeiterAnzahl).withOption(oLaufzeit).create();
		
		Parser parser = new Parser();
		parser.setGroup(options);
		
		
		/*
		 * Hier werden die Optionen und Argumente aus der args-Variable ausgelesen, und mit entsprechenden
		 * Meldungen und Exceptions verwaltet.
		 */
		
		CommandLine cl = parser.parse(args);
		
		if(cl.hasOption(oLagerVerzeichnis))
			this.lagerVerzeichnis = (String) cl.getValue(oLagerVerzeichnis);
		
		if(cl.hasOption(oLogVerzeichnis))
			this.logVerzeichnis = (String) cl.getValue(oLogVerzeichnis);
			
		if(cl.hasOption(oLieferantenAnzahl)) {
			try {
				this.lieferantenAnzahl = Integer.parseInt((String)cl.getValue(oLieferantenAnzahl));
				if(this.lieferantenAnzahl <= 0 || this.lieferantenAnzahl > 100000)
					throw new IllegalNubmberOfLieferantenException();
			} catch(NumberFormatException e) {
				System.out.println(cl.getValue(oLieferantenAnzahl).toString() + " ist keine Zahl!");
			}
		}
		
		if(cl.hasOption(oMonteurAnzahl)) {
			try {
				this.monteurAnzahl = Integer.parseInt((String)cl.getValue(oMonteurAnzahl));
				if(this.monteurAnzahl <= 0 || this.monteurAnzahl > 100000)
					throw new IllegalNubmberOfMonteureException();
			} catch(NumberFormatException e) {
				System.out.println(cl.getValue(oMonteurAnzahl).toString() + " ist keine Zahl!");
			}
		}
		
		if(cl.hasOption(oLagerMitarbeiterAnzahl)) {
			try {
				this.lagerMitarbeiterAnzahl = Integer.parseInt((String)cl.getValue(oLagerMitarbeiterAnzahl));
				if(this.lagerMitarbeiterAnzahl <= 0 || this.lagerMitarbeiterAnzahl > 100000)
					throw new IllegalNubmberOfLMException();
			} catch(NumberFormatException e) {
				System.out.println(cl.getValue(oLagerMitarbeiterAnzahl).toString() + " ist keine Zahl!");
			}
		} else
			this.lagerMitarbeiterAnzahl=1;
		
		if(cl.hasOption(oLaufzeit)) {
			try {
				this.laufzeit = Integer.parseInt((String)cl.getValue(oLaufzeit));
				if(this.laufzeit < 1000 || this.laufzeit > 100000000)
					throw new IllegalLaufzeitException();
			} catch(NumberFormatException e) {
				System.out.println(cl.getValue(oLaufzeit).toString() + " ist keine Zahl!");
			}
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
		return lagerMitarbeiterAnzahl;
	}

	/**
	 * Gibt die Lafzeit in Millisekunden als int zurück
	 * @return Lafzeit in Millisekunden als int
	 */
	public int getLaufzeit() {
		return laufzeit;
	}

		
}

