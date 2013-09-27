/**
 * 
 */
package ayvazyanbelinic;


/**
 * Wird geworfen, um darauf hinzuweisen, das eine ungültige Anzahl von Monteuren eingegeben wurde
 * @author Vennesa Belinic
 * @version 2013-09-26
 *
 */
public class IllegalNubmberOfMonteureException extends IllegalArgumentException {

	//Konstruktor(en)
	
	/**
	 * Default-Konstruktor, ruft den Konstruktor der super Klasse mit diesem String auf 'Ungültige Anzahl von Monteuren!' aus
	 */
	public IllegalNubmberOfMonteureException() {
		super("Ungültige Anzahl von Monteuren!");
	}
	
	/**
	 * Intialisiert den Konstruktor mit einem übergebenen Text
	 * Um den Text zu intialisieren wird der Konstruktor der Superklasse verwendet
	 * @param s Der Text der Intialisiert wird
	 */
	public IllegalNubmberOfMonteureException(String s) {
		super(s);
	}
}