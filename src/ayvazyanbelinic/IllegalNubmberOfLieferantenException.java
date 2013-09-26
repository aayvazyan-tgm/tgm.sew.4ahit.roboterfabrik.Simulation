/**
 * 
 */
package ayvazyanbelinic;


/**
 * Wird geworfen, um darauf hinzuweisen, das eine ungültige Anzahl von Lieferanten eingegeben wurde
 * @author Vennesa Belinic
 * @version 2013-09-26
 *
 */
public class IllegalNubmberOfLieferantenException extends IllegalArgumentException {

	//Konstruktor(en)
	
	/**
	 * Default-Konstruktor, gibt den Text 'Ungültige Anzahl von Lieferanten!' aus
	 */
	public IllegalNubmberOfLieferantenException() {
		System.out.print("Ungültige Anzahl von Lieferanten!");
	}
	
	/**
	 * Intialisiert den Konstruktor mit einem übergebenen Text
	 * Um den Text zu intialisieren wird der Konstruktor der Superklasse verwendet
	 * @param s Der Text der Intialisiert wird
	 */
	public IllegalNubmberOfLieferantenException(String s) {
		super(s);
	}
}