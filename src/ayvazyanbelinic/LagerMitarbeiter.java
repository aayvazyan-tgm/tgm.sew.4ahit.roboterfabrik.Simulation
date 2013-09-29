package ayvazyanbelinic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


/**
 * The Class LagerMitarbeiter.
 *
 * @author Ari Ayvazyan
 */
public class LagerMitarbeiter implements Stoppable {

	
	
	/** Die id. */
	private LinkedList<Long> id;
	
	/** Das lager Verzeichnis. */
	private String lagerVerzeichnis;
	
	
	
	/**
	 * Erstellt einen neuen LagerMitarbeiter
	 *
	 * @param id the id
	 * @param lagerVerzeichnis the lager verzeichnis
	 */
	public LagerMitarbeiter(LinkedList<Long> id, String lagerVerzeichnis) {
		
	}
	
	
	
	
	//Methode(n)
	
	/**
	 * Gets the bestandteil.
	 *
	 * @return the bestandteil
	 */
	public Bestandteil getBestandteil() {
		return null;
	}
	
	/**
	 * Run.
	 *
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	/**
	 * Stop.
	 *
	 * @see ayvazyanbelinic.Stoppable#stop()
	 */
	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
