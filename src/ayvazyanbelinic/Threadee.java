package ayvazyanbelinic;

import java.util.HashMap;


/**
 * Stellt eine fertig zusammengebauten Roboter dar.
 * Die Threadees werden erst vom Monteur erzeugt wenn er die Bestandteile
 * zusammen gebaut hat. Die ID bekommt der Threadee von der Sekretariat Klasse.
 * @author Vennesa Belinic
 * @version 2013-09-25
 */
public class Threadee {

	
	//Attribut(e)
	
	
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
	 * Die ID des Threadees.
	 * Wird ihm vom der Klasse Sekretariat zugewiesen.
	 */
	private HashMap<Long,String> id;

	
	
	//Konstruktor(en)
	
	/**
	 * Konstruktor mit Parametern
	 * @param id Die ID des Threadees
	 * @param bestandteile Die Bestandteile, als Bestanteil-Array
	 */
	public Threadee(HashMap<Long,String> id, Auge[] augen, Rumpf rumpf, Kettenantrieb antrieb, Arm[] arme) {
		this.id = id;							//Hier ist keine Überprüfung nötig da die ID vom Sekretariat vergeben wird,
		this.augen = augen;						//und die Bestandteile vom Monteur, der die Daten vom Lagermitarbeiter bekommt.
		this.rumpf = rumpf;
		this.kettenantrieb = antrieb;
		this.arme = arme;
	}

}
