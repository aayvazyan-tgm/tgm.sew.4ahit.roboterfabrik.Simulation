package ayvazyanbelinic;

import org.apache.commons.cli2.OptionException;


/**
 * Startet die Fabrik
 * @author Vennesa Belinic
 * @version 2013-09-26
 */
public class StartFabrik {

	//Attribut(e)
	
	/**
	 * 
	 */
	private static MyLogger logger;
	
	
	
	//Methode(n)
	
	/**
	 * main-Methode (Startet alles)
	 * @param args die Argumente die vom CLI übergeben werden
	 */
	public static void main(String[] args) {
		try {	
			new MyCommandLine(args);
		} catch(OptionException e) {
			System.out.println("Es ist ein Fehler beim Verarbeiten aufgetreten!\n" +
					"Entweder haben Sie nicht alle verpflichtenden Optionen und deren Argument angegeben,\n" +
					"oder es ist ein allgmeiner Fehler aufgetreten.");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
