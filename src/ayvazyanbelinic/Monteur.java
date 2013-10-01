package ayvazyanbelinic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/**
 * Der Monteur baut die Threadees zusammen.
 * @author Vennesa Belinic
 * @version 2013-09-30
 */
public class Monteur implements Stoppable {
	
	//Attribut(e)
	
	/**
	 * Die ID des Monteurs
	 */
	private LinkedList<Long> id;
	
	/**
	 * Wird in stop auf true gesetzt um den Monteur zu stoppen.
	 */
	private boolean stop;
	
	/**
	 * Der Lagermitarbeiter vom dem die Bestandteil kommen, und der die fertigen Roboter entgegen nimmt.
	 */
	private LagerMitarbeiter lagermitarbeiter;

	/**
	 * Das Sekretariat das die IDs vergibt, wird benötigt um dem erstellten Threadee seine ID zu geben.
	 */
	private Sekretariat sekretariat;
	
	
	
	
	//Konstruktor(en)
	
	/**
	 * Erzeugt einen neuen Monteur
	 * @param id Die ID die ihm vom mSekretariat übergeben wird
	 * @param lagerM Der Lagermitarbeiter der die Bestandteile liefert, die fertigen Roboter entgegen nimmt
	 */
	public Monteur(LinkedList<Long> id, LagerMitarbeiter lagerM, Sekretariat sekretariat) {
		this.id = id;
		this.stop = false;
		this.lagermitarbeiter = lagerM;
		this.sekretariat = sekretariat;
	}


	
	
	//Methode(n)
	
	/**
	 * Baut die Threadees zusammen, indem er die Seriennummer der Bestandteile sortiert
	 * @return einen fertig zusammen gebauten Roboter (Threadee), falls eines der übergebenen Teile null ist weil
	 * der Lagermitarbeiter sie nicht "auf Lager" hat, wird null zurück gegeben.
	 */
	protected Threadee zusammenbauen(Auge auge1, Auge auge2, Rumpf rumpf, Kettenantrieb antrieb, Arm arm1, Arm arm2) {
		Logger logger=Logger.getLogger("Arbeitsverlauf");
		if(auge1 != null && auge2 != null && rumpf != null && antrieb != null && arm1 != null && arm2 != null) {		//wenn keines der Teile null ist
			auge1.sortieren();																							//wird der Roboter zusammengebaut
			auge2.sortieren();																							//(sortieren der Seriennummer)
			rumpf.sortieren();
			antrieb.sortieren();
			arm1.sortieren();
			arm2.sortieren();
			
			Auge[] augen = {auge1, auge2};
			Arm[] arme = {arm1, arm2};
			
			Threadee temp = new Threadee(sekretariat.getThreadeeID(), augen, rumpf, antrieb, arme);
			logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat neuen Threadee:" + Sekretariat.idToString(temp.getID()) + " zusammengebaut");
			return temp;
		} else {
			logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " ist gescheitert am zusammenbauen");
			return null;
		}
	}
	
	/**
	 * Setzt die stop-Variable auf true, so wird das was der Monteur gerade macht nicht unterbrochen
	 * aber er beginnt nicht einen neuen Roboter zusammen zu bauen
	 */
	public void stop() {
		this.stop = true;
	}

	/**
	 * 
	 */
	@Override
	public void run() {
		Logger logger=Logger.getLogger("Arbeitsverlauf");
		long arbeitsgeschwindigkeit=100l; 			//in Millisekunden
		
		while(!stop) {
			try {
				Thread.sleep(arbeitsgeschwindigkeit);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			boolean liefern, zurueckliefern;
			
			Auge auge1 = null, auge2 = null;		//Die Bestandteile werden mit null intialisiert, damit wenn sie ein paar Zeilen darunter
			Rumpf rumpf = null;						//an die zusammenbauen-Methode übergeben werden, falls sie nicht gesetzt werden können
			Kettenantrieb antrieb = null;			//mit übergeben werden um, das fehlschlagen des zusammenbauens mitloggen zu können.
			Arm arm1 = null, arm2 = null;
			
			Bestandteil temp1 = lagermitarbeiter.getBestandteil("Auge");	//Es wrd ein Auge Bestandteil angefordert
			if(temp1 != null && temp1 instanceof  Auge) {				//Hier wird ueberprueftt ob das angeforderte Teil eine Instanz 
				auge1 = (Auge) temp1;										//vom String st der uebergeben wurde.
				logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das angeforderte Teil(" + auge1.toString() +") bekommen");
			} else
				logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das angeforderte Teil(Auge) nicht bekommen");
													
			Bestandteil temp2 = lagermitarbeiter.getBestandteil("Auge");
			if(temp2 != null && temp2 instanceof  Auge) {
				auge2 = (Auge) temp2;
				logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das angeforderte Teil(" + auge2.toString() + ") bekommen");
			} else
				logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das angeforderte Teil(Auge) nicht bekommen");

			Bestandteil temp3 = lagermitarbeiter.getBestandteil("Rumpf");
			if(temp3 != null && temp3 instanceof  Rumpf) {
				rumpf = (Rumpf) temp3;
				logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das angeforderte Teil(" + rumpf.toString() + ") bekommen");
			} else
				logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das angeforderte Teil(Rumpf) nicht bekommen");
			
			Bestandteil temp4 = lagermitarbeiter.getBestandteil("Kettenantrieb");
			if(temp4 != null && temp4 instanceof  Kettenantrieb) {
				antrieb = (Kettenantrieb) temp4;
				logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das angeforderte Teil(" + antrieb.toString() + ") bekommen");
			} else
				logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das angeforderte Teil(Kettenantrieb) nicht bekommen");
			
			Bestandteil temp5 = lagermitarbeiter.getBestandteil("Arm");
			if(temp5 != null && temp5 instanceof  Arm) {
				arm1 = (Arm) temp5;
				logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das angeforderte Teil(" + arm1.toString() + ") bekommen");
			} else
				logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das angeforderte Teil(Arm) nicht bekommen");
				
			Bestandteil temp6 = lagermitarbeiter.getBestandteil("Arm");
			if(temp6 != null && temp6 instanceof  Arm) {
				arm2 = (Arm) temp6;
				logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das angeforderte Teil(" + arm2.toString() + ") bekommen");
			} else
				logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das angeforderte Teil(Arm) nicht bekommen");
			
			
			Threadee roboter = zusammenbauen(auge1,auge2,rumpf,antrieb,arm1,arm2);
			if(roboter != null) {
				do {
					/* Der Monteur versucht solange den fertigen Roboter zu liefern bis es nicht funktioniert hat. */
					liefern = lagermitarbeiter.einlagern(roboter);
				} while(!liefern);
				logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat neuen Threadee:" + Sekretariat.idToString(roboter.getID()) + " geliefert");
			} else {
				
				/* Der Monteur versucht die Teile solange zurueckzugeben bis das einlagern nicht funktioniert hat. */
				if(temp1 != null) {
					do { zurueckliefern = lagermitarbeiter.einlagern(temp1); } while(!zurueckliefern);	
					logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das Teil(" + temp1.toString() +") zurueckgeliefert");
				}
				if(temp2 != null) {
					do { zurueckliefern = lagermitarbeiter.einlagern(temp2); } while(!zurueckliefern);
					logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das Teil(" + temp2.toString() +") zurueckgeliefert");
				}
				if(temp3 != null) {
					do { zurueckliefern = lagermitarbeiter.einlagern(temp3); } while(!zurueckliefern);
					logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das Teil(" + temp3.toString() +") zurueckgeliefert");
				}
				if(temp4 != null) {
					do { zurueckliefern = lagermitarbeiter.einlagern(temp4); } while(!zurueckliefern);
					logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das Teil(" + temp4.toString() +") zurueckgeliefert");
				}
				if(temp5 != null) {
					do { zurueckliefern = lagermitarbeiter.einlagern(temp5); } while(!zurueckliefern);
					logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das Teil(" + temp5.toString() +") zurueckgeliefert");
				}
				if(temp6 != null) {
					do { zurueckliefern = lagermitarbeiter.einlagern(temp6); } while(!zurueckliefern);
					logger.log(Level.INFO, "Monteur:" + Sekretariat.idToString(id) + " hat das Teil(" + temp6.toString() +") zurueckgeliefert");
				}
			}
			
		}
		
	}
		
}

