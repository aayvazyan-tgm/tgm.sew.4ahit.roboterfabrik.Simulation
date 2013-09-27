package ayvazyanbelinic;

import java.util.HashMap;


/**
 * 
 * @author User
 *
 */
public class Lieferant implements Stopable {

	
	//Attribut(e)
	
	/**
	 * 
	 */
	private long seed;

	/**
	 * 
	 */
	private HashMap<Long,String> id;
	
	
	
	//Konstruktor(en)
	
	/**
	 * 
	 * @param id
	 * @param lagerverzeichnis
	 * @param lagerM
	 */
	public Lieferant(HashMap<Long,String> id, String lagerverzeichnis, LagerMitarbeiter lagerM) {
		
	}
	
	
	
	
	//Methode(n)
	
	/**
	 * 
	 * @param bestandteilname
	 */
	protected void liefern(String bestandteilname) {

	}

	/**
	 * @see Stopable#stop()
	 */
	public void stop() {

	}

	/**
	 * 
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
