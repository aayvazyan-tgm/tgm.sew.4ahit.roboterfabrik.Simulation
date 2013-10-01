package ayvazyanbelinic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.cli2.OptionException;
import org.apache.log4j.*;

/**
 * Startet die Fabrik
 * @author  Ari Ayvazyan ,Vennesa Belinic
 * @version 2013-09-29
 */
public class StartFabrik {

	
	
	/**
	 * main-Methode (Startet alles)
	 * @param args die Argumente die vom CLI uebergeben werden
	 */
	public static void main(String[] args) {
		try {
			MyCommandLine m=new MyCommandLine(args);//Verarbeitet die argumente
			
			FileAppender ap;
			try {
				ap = new FileAppender(new SimpleLayout(), m.getLogVerzeichnis()+File.separator+"log.txt", false); //erstellt einene neuen appender fuer log4J
				BasicConfigurator.configure(ap);  //der appender wird dem logger zugewiesen
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			Logger lg=Logger.getLogger("Arbeitsverlauf"); //Im Arbeitsverlauf finden sich saemtliche aktivitaeten innerhalb der Fabrik
			
			lg.log(Level.INFO, "Der Betrieb wird aufgenommen");
			new Fabrik(m.getLagerVerzeichnis(), m.getLieferantenAnzahl(), m.getMonteurAnzahl(), m.getLagerMitarbeiterAnzahl(), m.getLaufzeit());
			lg.log(Level.INFO, "Der Betrieb wurde aufgenommen");
			//ap.close();
			//LogManager.shutdown();
		} catch(OptionException e) {
			System.out.println("Es ist ein Fehler beim Verarbeiten aufgetreten!\n" +
					"Entweder sind nicht alle verpflichtenden Optionen und deren Argument angegeben,\n" +
					"oder es ist ein allgmeiner Fehler aufgetreten.");
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

}
