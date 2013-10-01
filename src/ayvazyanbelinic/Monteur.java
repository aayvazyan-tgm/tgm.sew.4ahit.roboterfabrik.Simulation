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
			
			boolean alleVorhanden = true;
			
			Auge auge1 = null, auge2 = null;
			Rumpf rumpf = null;
			Kettenantrieb antrieb = null;
			Arm arm1 = null, arm2 = null;
			
			Bestandteil temp = lagermitarbeiter.getBestandteil("Auge");
			
			if(!(temp != null && temp instanceof  Auge))
				auge1 = (Auge) temp;
			else
				alleVorhanden = false;
			
			temp = lagermitarbeiter.getBestandteil("Auge");
			if(!(temp != null && temp instanceof  Auge))
				auge2 = (Auge) temp;
			else
				alleVorhanden = false;

			temp = lagermitarbeiter.getBestandteil("Rumpf");
			if(!(temp != null && temp instanceof  Rumpf))
				rumpf = (Rumpf) temp;
			else
				alleVorhanden = false;
			
			temp = lagermitarbeiter.getBestandteil("Kettenantrieb");
			if(!(temp != null && temp instanceof  Kettenantrieb))
				antrieb = (Kettenantrieb) temp;
			else
				alleVorhanden = false;
			
			temp = lagermitarbeiter.getBestandteil("Arm");
			if(!(temp != null && temp instanceof  Arm))
				arm1 = (Arm) temp;
			else
				alleVorhanden = false;
			
			temp = lagermitarbeiter.getBestandteil("Arm");
			if(!(temp != null && temp instanceof  Arm))
				arm1 = (Arm) temp;
			else
				alleVorhanden = false;
			
			if(alleVorhanden) {
				Threadee roboter = zusammenbauen(auge1,auge2,rumpf,antrieb,arm1,arm2);
				if(roboter != null)
					lagermitarbeiter.liefern(roboter, this);
				
				//Noch nicht fertig
			}
			
			
		}
		
	}
		
}

