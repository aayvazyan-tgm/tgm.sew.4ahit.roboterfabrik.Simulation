package ayvazyanbelinic;

import org.apache.log4j.*;

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
	private int id;

	/**
	 * 
	 */
	private Logger logger;

	
	
	//Methode(n)
	
	/**
	 * 
	 * @param bestandteilname
	 * @param logger
	 * @param lager
	 */
	public void liefern(String bestandteilname, Logger logger, String lager) {

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
