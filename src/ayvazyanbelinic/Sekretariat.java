package ayvazyanbelinic;

import java.util.concurrent.ThreadPoolExecutor;
//import von log4j fehlt

/**
 * 
 * @author User
 *
 */
public class Sekretariat {

	
	//Attribut(e)
	
	/**
	 * 
	 */
	private ThreadPoolExecutor pool;

	/**
	 * 
	 */
	private int mid;

	/**
	 * 
	 */
	private int tid;

	/**
	 * 
	 */
	private Logger logger;

	/**
	 * 
	 */
	private String lager;

	
	
	//Konstruktor(en)
	
	/**
	 * 
	 * @param lager
	 * @param log
	 * @param lieferanten
	 * @param monteure
	 * @param laufzeit
	 */
	public Sekretariat(String lager, String log, int lieferanten, int monteure, int laufzeit) {

	}

	
	
	//Methode(n)
	
	/**
	 * 
	 * @return
	 */
	public int nextMID() {
		return 0;
	}

	/**
	 * 
	 * @return
	 */
	public int nextTID() {
		return 0;
	}

}
