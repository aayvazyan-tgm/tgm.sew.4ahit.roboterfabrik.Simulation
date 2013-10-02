/**
 * 
 */
package tgm.sew.hit.roboterfabrik;


/**
 * Wird geworfen, um darauf hinzuweisen, das eine ungueltige Laufzeit eingegeben wurde
 * @author Vennesa Belinic
 * @version 2013-09-26
 *
 */
public class IllegalLaufzeitException extends IllegalArgumentException {

	//Konstruktor(en)
	
	/**
	 * Default-Konstruktor, ruft den Konstruktor der super Klasse mit diesem String auf 'Ungueltige Laufzeit!' aus
	 */
	public IllegalLaufzeitException() {
		super("Ungueltige Laufzeit!");
	}
	
	/**
	 * Intialisiert den Konstruktor mit einem uebergebenen Text
	 * Um den Text zu intialisieren wird der Konstruktor der Superklasse verwendet
	 * @param s Der Text der Intialisiert wird
	 */
	public IllegalLaufzeitException(String s) {
		super(s);
	}
}