package ayvazyanbelinic;

import java.util.HashMap;


/**
 * 
 * @author User
 *
 */
public class Monteur implements Stopable {

	
	//Attribut(e)
	
	/**
	 * 
	 */
	private HashMap<Long, String> id;

	
	
	//Konstruktor(en)
	
	/**
	 * 
	 * @param id
	 * @param lagerM
	 */
	public Monteur(HashMap<Long, String> id, LagerMitarbeiter lagerM) {

	}


	
	//Methode(n)
	
	/**
	 * 
	 * @return
	 */
	protected Threadee zusammenbaun() {
		return null;
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
