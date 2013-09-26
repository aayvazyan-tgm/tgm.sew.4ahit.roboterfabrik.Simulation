/**
 * 
 */
package ayvazyanbelinic;


/**
 * Wird geworfen, um darauf hinzuweisen, das eine ungültige Laufzeit eingegeben wurde
 * @author Vennesa Belinic
 * @version 2013-09-26
 *
 */
public class IllegalLaufzeitException extends IllegalArgumentException {

	//Konstruktor(en)
	
	/**
	 * Default-Konstruktor, gibt den Text 'Ungültige Laufzeit!' aus
	 */
	public IllegalLaufzeitException() {
		System.out.print("Ungültige Laufzeit!");
	}
	
	/**
	 * Intialisiert den Konstruktor mit einem übergebenen Text
	 * Um den Text zu intialisieren wird der Konstruktor der Superklasse verwendet
	 * @param s Der Text der Intialisiert wird
	 */
	public IllegalLaufzeitException(String s) {
		super(s);
	}
}