package ayvazyanbelinic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/**
 * 
 * @author Ari Ayvazyan
 * @version 30.09.2013
 *
 */
public class Lieferant implements Stoppable {

	
	
	/**
	 * der Seed fuer die Zufallszahlen der lieferungen
	 */
	private long seed;

	/**
	 * Die ID des Mitarbeiters
	 */
	private LinkedList<Long> id;
	
	/**
	 * Mit stop() zu setzen, dient um die weitere ausfuehrung zu stoppen.
	 */
	private boolean stop=false;
	
	/**
	 *  Der Lagermitarbeiter
	 */
	private LagerMitarbeiter lagerM;
	
	/**
	 * das Lagerverzeichnis
	 */
	private String lagerVerz;

	/**
	 * das sekretariat fuer die ID vergabe
	 */
	private Sekretariat sekretariat;
	
	/**
	 * Erstellt einen neuen Lieferanten der neue Teile in den angegebenen pfad liefert.
	 * 
	 * @param id - die ID des Lieferanten
	 * @param lagerverzeichnis - Das zu benutzende Verzeichnis
	 * @param lagerM - Der zu benutzende LagerMitarbeiter
	 * @param sekretariat - fuer die Bauteil ID vergabe
	 */
	public Lieferant(LinkedList<Long> id, String lagerVerzeichnis, LagerMitarbeiter lagerM,Sekretariat sekretariat) {
		this.id=id;
		this.seed=1337l;
		this.lagerM=lagerM;
		this.lagerVerz=lagerVerzeichnis;
		this.sekretariat=sekretariat;
	}
	
	
	
	
	
	/**
	 * 
	 * @param bestandteilname - Kann Arm, Rumpf, Auge oder Kettenantrieb sein.
	 */
	protected void liefern(String bestandteilname) {
		Logger logger=Logger.getLogger("Arbeitsverlauf");
		
		if(bestandteilname.equalsIgnoreCase("Arm")){
			Arm bestandteil=new Arm(this.sekretariat.getBauTeilID()); //erstelle einen neuen Arm mit der vom Sektretariat vergebenen ID
			logger.log(Level.INFO, "Neues Teil an einen Lagermitarbeiter geliefert:"+bestandteil.toString());
			//lagerM.  //Liefere das erstellte teil aus.

		}
		if(bestandteilname.equalsIgnoreCase("Rumpf")){
			
		}
		if(bestandteilname.equalsIgnoreCase("Auge")){
			
		}
		if(bestandteilname.equalsIgnoreCase("Kettenantrieb")){
			
		}
	}

	/**
	 * @see Stoppable#stop()
	 */
	public void stop(){ 
		this.stop=true;
	}

	/**
	 * @see Runnable#run()
	 */
	@Override
	public void run() {
		Random r=new Random(seed);
		long arbeitsgeschwindigkeit=100l; //in Millisekunden
		
		while(!stop){//Liefere solange bis stop() aufgerufen wird
			try {
				Thread.sleep(arbeitsgeschwindigkeit);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int bestandTeilZfZahl=r.nextInt(4); //Liefert einen pseudo zufaelligen wert um ein zufaelliges Bestandteil zu erstellen.
			switch(bestandTeilZfZahl){
			case 0:
				liefern("Auge");
				liefern("Auge");
				break;
			
			case 1:
				liefern("Rumpf");
				break;
			
			case 2:
				liefern("Kettenantrieb");
				break;
			
			case 3:
				liefern("Arm");
				liefern("Arm");
				break;
				
			default: //sollte nie auftreten
				System.err.println("Die Zufallszahl liegt ausserhalb der erwarteten Werte. Klassenname: "+getClass().getName());
			}
		}
	}

}
