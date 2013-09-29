/**
 * 
 */
package ayvazyanbelinic;

import java.util.HashMap;


/**
 * @author User
 *
 */
public class LagerMitarbeiter implements Stoppable {

	
	//Attribut(e)
	
	/**
	 * 
	 */
	private HashMap<Long,String> id;
	
	/**
	 * 
	 */
	private String lagerVerzeichnis;
	
	
	
	
	//Konstruktor(en)
	
	/**
	 * 
	 * @param id
	 * @param lagerVerzeichnis
	 */
	public LagerMitarbeiter(HashMap<Long,String> id, String lagerVerzeichnis) {
		
	}
	
	
	
	
	//Methode(n)
	
	/**
	 * 
	 * @return
	 */
	public Bestandteil getBestandteil() {
		return null;
	}
	
	/** 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	/** 
	 * @see ayvazyanbelinic.Stoppable#stop()
	 */
	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
