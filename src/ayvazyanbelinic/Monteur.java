package ayvazyanbelinic;

import org.apache.log4j.*;

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
	private int id;

	/**
	 * 
	 */
	private Logger logger;

	/**
	 * 
	 */
	private String lagerverzeichnis;

	
	
	//Konstruktor(en)
	
	/**
	 * 
	 * @param logger
	 * @param lagerverzeichnis
	 */
	public Monteur(Logger logger, String lagerverzeichnis) {

	}


	
	//Methode(n)
	
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
