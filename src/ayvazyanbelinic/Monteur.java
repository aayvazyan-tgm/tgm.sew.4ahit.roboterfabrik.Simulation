package ayvazyanbelinic;

//import von log4j fehlt

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
	private Sekretariat sekretariat;

	/**
	 * 
	 */
	private String lager;

	
	
	//Konstruktor(en)
	
	/**
	 * 
	 * @param sekretariat
	 * @param logger
	 * @param lager
	 */
	public Monteur(Sekretariat sekretariat, Logger logger, String lager) {

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
