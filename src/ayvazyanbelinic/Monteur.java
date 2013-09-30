package ayvazyanbelinic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;


/**
 * 
 * @author Vennesa Belinic
 * @version 2013-09-30
 */
public class Monteur implements Stoppable {

	//mitloggen fehlt, noch nicht fertig
	
	//Attribut(e)
	
	/**
	 * 
	 */
	private LinkedList<Long> id;
	
	/**
	 * 
	 */
	private boolean stop;
	
	/**
	 * 
	 */
	private LagerMitarbeiter lagermitarbeiter;

	/**
	 * 
	 */
	private Sekretariat sekretariat;
	
	
	//Konstruktor(en)
	
	/**
	 * 
	 * @param id
	 * @param lagerM
	 */
	public Monteur(LinkedList<Long> id, LagerMitarbeiter lagerM, Sekretariat sekretariat) {
		this.id = id;
		this.stop = false;
		this.lagermitarbeiter = lagerM;
		this.sekretariat = sekretariat;
	}


	
	//Methode(n)
	
	/**
	 * 
	 * @return
	 */
	protected Threadee zusammenbauen(Auge auge1, Auge auge2, Rumpf rumpf, Kettenantrieb antrieb, Arm arm1, Arm arm2) {
		if(auge1 != null && auge2 != null && rumpf != null && antrieb != null && arm1 != null && arm2 != null) {
			auge1.sortieren();
			auge2.sortieren();
			rumpf.sortieren();
			antrieb.sortieren();
			arm1.sortieren();
			arm2.sortieren();
			
			Auge[] augen = {auge1, auge2};
			Arm[] arme = {arm1, arm2};
			
			return new Threadee(sekretariat.getThreadeeID(), augen, rumpf, antrieb, arme);
		} else
			return null;
	}
	
	/**
	 * @see Stoppable#stop()
	 */
	public void stop() {
		this.stop = true;
	}

	/**
	 * 
	 */
	@Override
	public void run() {
		long arbeitsgeschwindigkeit=100l; //in Millisekunden
		
		while(!stop) {
			try {
				Thread.sleep(arbeitsgeschwindigkeit);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			Auge auge1, auge2;
			Rumpf rumpf;
			Kettenantrieb antrieb;
			Arm arm1, arm2;
			Bestandteil temp;
			
			do {
				temp = lagermitarbeiter.getBestandteil("Auge");
				auge1 = (Auge) temp;
			} while(!(temp != null && temp instanceof  Auge));
			
			do {
				temp = lagermitarbeiter.getBestandteil("Auge");
				auge2 = (Auge) temp;
			} while(!(temp != null && temp instanceof  Auge));
			
			do {
				temp = lagermitarbeiter.getBestandteil("Rumpf");
				rumpf = (Rumpf) temp;
			} while(!(temp != null && temp instanceof  Rumpf));
			
			do {
				temp = lagermitarbeiter.getBestandteil("Kettenantrieb");
				antrieb = (Kettenantrieb) temp;
			} while(!(temp != null && temp instanceof  Kettenantrieb));
			
			do {
				temp = lagermitarbeiter.getBestandteil("Arm");
				arm1 = (Arm) temp;
			} while(!(temp != null && temp instanceof  Arm));
			
			do {
				temp = lagermitarbeiter.getBestandteil("Arm");
				arm2 = (Arm) temp;
			} while(!(temp != null && temp instanceof  Arm));
			
			Threadee roboter = zusammenbauen(auge1,auge2,rumpf,antrieb,arm1,arm2);
			if(roboter != null)
				lagermitarbeiter.liefern(roboter, this);
			
		}
		
	}
		
}

