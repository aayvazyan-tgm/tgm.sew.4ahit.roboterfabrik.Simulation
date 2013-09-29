package ayvazyanbelinic;

import java.util.HashMap;
import java.util.HashSet;


/**
 * The Class LagerMitarbeiter.
 *
 * @author Ari Ayvazyan
 */
public class LagerMitarbeiter implements Stoppable {

	
	
	/** Die id. */
	private HashSet<Long> id;
	
	/** Das lager Verzeichnis. */
	private String lagerVerzeichnis;
	
	
	
	/**
	 * Erstellt einen neuen LagerMitarbeiter
	 *
	 * @param id the id
	 * @param lagerVerzeichnis the lager verzeichnis
	 */
	public LagerMitarbeiter(HashSet<Long> id, String lagerVerzeichnis) {
		
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
