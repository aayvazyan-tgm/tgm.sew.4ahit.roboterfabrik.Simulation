/**
 * 
 */
package tgm.sew.hit.roboterfabrik;


/**
 * Wird geworfen, um darauf hinzuweisen, das eine ungueltige Anzahl von Lieferanten eingegeben wurde
 * @author Vennesa Belinic
 * @version 2013-09-26
 *
 */
public class IllegalNubmberOfLieferantenException extends IllegalArgumentException {

	//Konstruktor(en)
	
	/**
	 * Default-Konstruktor, ruft den Konstruktor der super Klasse mit diesem String auf 'Ungueltige Anzahl von Lieferanten!' aus
	 */
	public IllegalNubmberOfLieferantenException() {
		super("Ungueltige Anzahl von Lieferanten!");
	}
	
	/**
	 * Intialisiert den Konstruktor mit einem uebergebenen Text
	 * Um den Text zu intialisieren wird der Konstruktor der Superklasse verwendet
	 * @param s Der Text der Intialisiert wird
	 */
	public IllegalNubmberOfLieferantenException(String s) {
		super(s);
	}
}