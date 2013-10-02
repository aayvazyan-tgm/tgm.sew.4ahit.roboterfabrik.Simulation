/**
 * 
 */
package tgm.sew.hit.roboterfabrik;


/**
 * Wird geworfen, um darauf hinzuweisen, das eine ungueltige Anzahl von Monteuren eingegeben wurde
 * @author Vennesa Belinic
 * @version 2013-09-26
 *
 */
public class IllegalNubmberOfMonteureException extends IllegalArgumentException {

	//Konstruktor(en)
	
	/**
	 * Default-Konstruktor, ruft den Konstruktor der super Klasse mit diesem String auf 'Ungueltige Anzahl von Monteuren!' aus
	 */
	public IllegalNubmberOfMonteureException() {
		super("Ungueltige Anzahl von Monteuren!");
	}
	
	/**
	 * Intialisiert den Konstruktor mit einem uebergebenen Text
	 * Um den Text zu intialisieren wird der Konstruktor der Superklasse verwendet
	 * @param s Der Text der Intialisiert wird
	 */
	public IllegalNubmberOfMonteureException(String s) {
		super(s);
	}
}