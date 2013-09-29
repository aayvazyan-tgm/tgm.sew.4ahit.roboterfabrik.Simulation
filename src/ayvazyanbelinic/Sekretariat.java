package ayvazyanbelinic;

import java.util.HashSet;
import java.util.LinkedList;


/**
 * Verteilt einzigartige IDs
 * 
 * 
 * @author Ari Ayvazyan
 * @version 29.09.2013
 */
public class Sekretariat {

	
	
	/**
	 * Die zuletzt vergebene ID
	 */
	private LinkedList<Long> lagerMID;
	
	/**
	 * Die zuletzt vergebene ID
	 */
	private LinkedList<Long> lieferantenID;
	
	/**
	 * Die zuletzt vergebene ID
	 */
	private LinkedList<Long> monteurID;
	
	/**
	 * Die zuletzt vergebene ID
	 */
	private LinkedList<Long> threadeeID;

	
	
	
	
	/**
	 * Initialisert die Hashsets mit einem Long auf 0
	 */
	public Sekretariat() {
		this.lagerMID=new LinkedList<Long>();
		this.lagerMID.add(0l);
		
		this.lieferantenID=new LinkedList<Long>();
		this.lieferantenID.add(0l);
		
		this.monteurID=new LinkedList<Long>();
		this.monteurID.add(0l);
		
		this.threadeeID=new LinkedList<Long>();
		this.threadeeID.add(0l);
	}

	
	
	
	/**
	 * 
	 * @return gibt eine neue einzigartige ID fuer Mitarbeiter zurueck
	 */
	public synchronized LinkedList<Long> getLagerMID() {
		if(this.lagerMID.getLast()>=9223372036854775807l){ //Ist die maximale groesse eines Longs erreicht wird ein neuer Listeneintrag erstellt
			this.lagerMID.add(0l);
			return (LinkedList<Long>) lagerMID.clone(); // Konvertiert und klont die LinkedList in ein HashSet 
		}
		this.lagerMID.set(this.lagerMID.size()-1,this.lagerMID.getLast()+1);
		return (LinkedList<Long>) lagerMID.clone(); // Konvertiert und klont die LinkedList in ein HashSet 
	}

	/**
	 * 
	 * @return gibt eine neue einzigartige ID fuer Lieferanten zurueck
	 */
	public synchronized LinkedList<Long> getLieferantenID() {
		if(this.lieferantenID.getLast()>=9223372036854775807l){ //Ist die maximale groesse eines Longs erreicht wird ein neuer Listeneintrag erstellt
			this.lieferantenID.add(0l);
			return (LinkedList<Long>) lieferantenID.clone(); // Konvertiert und klont die LinkedList in ein HashSet 
		}
		this.lieferantenID.set(this.lieferantenID.size()-1,this.lieferantenID.getLast()+1);
		return (LinkedList<Long>) lieferantenID.clone(); // Konvertiert und klont die LinkedList in ein HashSet 
	}
	
	/**
	 * 
	 * @return gibt eine neue einzigartige ID fuer Monteure zurueck
	 */
	public synchronized LinkedList<Long> getMonteurID() {
		if(this.monteurID.getLast()>=9223372036854775807l){ //Ist die maximale groesse eines Longs erreicht wird ein neuer Listeneintrag erstellt
			this.monteurID.add(0l);
			return (LinkedList<Long>) monteurID.clone(); // Konvertiert und klont die LinkedList in ein HashSet 
		}
		this.monteurID.set(this.monteurID.size()-1,this.monteurID.getLast()+1);
		return (LinkedList<Long>) monteurID.clone(); // Konvertiert und klont die LinkedList in ein HashSet 
	}
	
	/**
	 * 
	 * @return gibt eine neue einzigartige ID fuer Threadees zurueck
	 */
	public synchronized LinkedList<Long> getThreadeeID() {
		if(this.threadeeID.getLast()>=9223372036854775807l){ //Ist die maximale groesse eines Longs erreicht wird ein neuer Listeneintrag erstellt
			this.threadeeID.add(0l);
			return (LinkedList<Long>) threadeeID.clone(); // Konvertiert und klont die LinkedList in ein HashSet 
		}
		this.threadeeID.set(this.threadeeID.size()-1,this.threadeeID.getLast()+1);
		return (LinkedList<Long>) threadeeID.clone(); // Konvertiert und klont die LinkedList in ein HashSet 
	}

}
