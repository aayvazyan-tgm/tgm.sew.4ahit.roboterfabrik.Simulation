package tgm.sew.hit.roboterfabrik;

import java.util.LinkedList;


/**
 * Stellt eine fertig zusammengebauten Roboter dar.
 * Die Threadees werden erst vom Monteur erzeugt wenn er die Bestandteile
 * zusammen gebaut hat. Die ID bekommt der Threadee von der Sekretariat Klasse.
 * @author Vennesa Belinic
 * @version 2013-10-01
 */
public class Threadee {

	
	
	
	/**
	 * Die Augen des Roboters als Auge-Array, da es 2 sind.
	 */
	private Auge[] augen;
	
	/**
	 * Der Rumpf des Roboters.
	 */
	private Rumpf rumpf;
	
	/**
	 * Der Kettenantrieb des Roboters.
	 */
	private Kettenantrieb kettenantrieb;
	
	/**
	 * Die Arme des Roboters als Arm-Array da es 2 sind.
	 */
	private Arm[] arme;
	
	/**
	 * Die Antenne des Roboters.
	 */
	private Antenne antenne;
	
	/**
	 * Die Arme des Roboters als Arm-Array da es 2 sind.
	 */
	private Greifer[] greifer;

	/**
	 * Die ID des Threadees.
	 * Wird ihm vom der Klasse Sekretariat zugewiesen.
	 */
	private LinkedList<Long> id;
	
	/**
	 * Die ID des Monteurs, der den Threadee zusammenbaut
	 */
	private LinkedList<Long> mID;

	
	
	
	/**
	 * Konstruktor mit Parametern
	 * @param id Die ID des Threadees
	 * @param bestandteile Die Bestandteile, als Bestanteil-Array
	 */
	public Threadee(LinkedList<Long> monteurID,LinkedList<Long> id, Auge[] augen, Rumpf rumpf, Kettenantrieb antrieb, Arm[] arme, Antenne antenne, Greifer[] greifer) {
		this.id = id;							//Hier ist keine ueberpruefung noetig da die ID vom Sekretariat vergeben wird,
		this.augen = augen;						//und die Bestandteile vom Monteur, der die Daten vom Lagermitarbeiter bekommt.
		this.rumpf = rumpf;
		this.kettenantrieb = antrieb;
		this.arme = arme;
		this.mID=monteurID;
		this.antenne = antenne;
		this.greifer = greifer;
	}
	
	/**
	 * Gibt die ID zurueck
	 * @return Die ID des Threadees
	 */
	public LinkedList<Long> getID() {
		return id;
	}
	
	/**
	 * Gibt die ID zurueck
	 */
	public LinkedList<Long> getMID() {
		return mID;
	}
	
	/**
	 * Setzt die ID des Monteurs
	 * @param id Die ID die für die Monteur-ID gesetzt wird
	 */
	public void setMID(LinkedList<Long> id) {
		this.mID = id;
	}
	
	/**
	 * Gibt das Threadee mit dem Monteur und den Bestandteilen als String zurueck
	 * @return Gibt alle Informationen zum Threadee in dieser Form zurueck:
	 * Threadee:ID;Monteur:ID;Auge,1,2,...;Rump,1,78,9,..
	 */
	@Override
	public String toString() {
		return ("Threadee:" + Sekretariat.idToString(id) + ";" + "Monteur:" + Sekretariat.idToString(mID) + ";"
				+ augen[0].toString() + ";" + augen[1].toString() + ";" + rumpf.toString() + ";" + kettenantrieb.toString()
				+ ";" + arme[0].toString() + ";" + arme[1].toString() + ";" + antenne.toString() + ";"
				+ greifer[0].toString() + ";" + greifer[1].toString());
		
	}

}
