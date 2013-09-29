package ayvazyanbelinic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


/**
 * 
 * @author User
 *
 */
public class Lieferant implements Stoppable {

	
	//Attribut(e)
	
	/**
	 * 
	 */
	private long seed;

	/**
	 * 
	 */
	private HashSet<Long> id;
	
	
	
	//Konstruktor(en)
	
	/**
	 * 
	 * @param id
	 * @param lagerverzeichnis
	 * @param lagerM
	 */
	public Lieferant(HashSet<Long> id, String lagerverzeichnis, LinkedList<LagerMitarbeiter> lagerM) {
		
	}
	
	
	
	
	//Methode(n)
	
	/**
	 * 
	 * @param bestandteilname
	 */
	protected void liefern(String bestandteilname) {

	}

	/**
	 * @see Stoppable#stop()
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
