package ayvazyanbelinic;


/**
 * Startet die Fabrik
 * @author Vennesa Belinic
 * @version 2013-09-26
 */
public class StartFabrik {

	//Attribut(e)
	
	/**
	 * 
	 */
	private static MyLogger logger;
	
	
	
	//Methode(n)
	
	/**
	 * main-Methode (Startet alles)
	 * @param args die Argumente die vom CLI übergeben werden
	 */
	public static void main(String[] args) {
		try {	
			new MyCommandLine(args);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
