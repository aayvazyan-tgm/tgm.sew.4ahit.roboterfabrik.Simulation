/**
 * 
 */
package ayvazyanbelinic;


/**
 * Wird geworfen, um darauf hinzuweisen, das eine ungueltige Anzahl von Lagermitarbeitern eingegeben wurde
 * @author Vennesa Belinic
 * @version 2013-09-27
 *
 */
public class IllegalNubmberOfLMException extends IllegalArgumentException {

	//Konstruktor(en)
	
	/**
	 * Default-Konstruktor, ruft den Konstruktor der super Klasse mit diesem String auf 'Ungueltige Anzahl von Lagermitarbeitern!' aus
	 */
	public IllegalNubmberOfLMException() {
		super("Ungueltige Anzahl von Lagermitarbeitern!");
	}
	
	/**
	 * Intialisiert den Konstruktor mit einem uebergebenen Text
	 * Um den Text zu intialisieren wird der Konstruktor der Superklasse verwendet
	 * @param s Der Text der Intialisiert wird
	 */
	public IllegalNubmberOfLMException(String s) {
		super(s);
	}
}