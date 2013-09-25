package ayvazyanbelinic;


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
	 * Die Bestandteile aus denen der Roboter besteht.
	 * (2 Augen, 1 Rumpf, 1 Kettenantrieb, 2 Arme)
	 */
	private Bestandteil[] bestandteile;

	/**
	 * Die ID des Threadees.
	 * Wird ihm vom der Klasse Sekretariat zugewiesen.
	 */
	private int id;

	
	
	//Konstruktor(en)
	
	/**
	 * Konstruktor mit Parametern
	 * @param id Die ID des Threadees
	 * @param bestandteile Die Bestandteile, als Bestanteil-Array
	 */
	public Threadee(int id, Bestandteil[] bestandteile) {
		this.id = id;							//Hier ist keine Überprüfung nötig da die ID vom Sekretariat vergeben wird,
		this.bestandteile = bestandteile;		//und die Bestandteile vom Monteur, der die Daten aus dem File ausliest.
	}

}
