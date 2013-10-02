package tgm.sew.hit.roboterfabrik;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;


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
	 * Eine liste sämtlicher vergebener Ids fuer die Bauteile
	 */
	private HashSet<HashSet<Integer>> bauteilIDs;
	
	
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
		
		this.bauteilIDs=new HashSet<HashSet<Integer>>();
	}

	
	
	
	/**
	 * 
	 * @return gibt eine neue einzigartige ID fuer Mitarbeiter zurueck
	 */
	public synchronized LinkedList<Long> getLagerMID() {
		if(this.lagerMID.getLast()>=9223372036854775807l){ //Ist die maximale groesse eines Longs erreicht wird ein neuer Listeneintrag erstellt
			this.lagerMID.add(0l);
			return (LinkedList<Long>) lagerMID.clone(); //Klont die Liste
		}
		this.lagerMID.set(this.lagerMID.size()-1,this.lagerMID.getLast()+1);
		return (LinkedList<Long>) lagerMID.clone(); //Klont die Liste
	}

	/**
	 * 
	 * @return gibt eine neue einzigartige ID fuer Lieferanten zurueck
	 */
	public synchronized LinkedList<Long> getLieferantenID() {
		if(this.lieferantenID.getLast()>=9223372036854775807l){ //Ist die maximale groesse eines Longs erreicht wird ein neuer Listeneintrag erstellt
			this.lieferantenID.add(0l);
			return (LinkedList<Long>) lieferantenID.clone(); //Klont die Liste
		}
		this.lieferantenID.set(this.lieferantenID.size()-1,this.lieferantenID.getLast()+1);
		return (LinkedList<Long>) lieferantenID.clone(); //Klont die Liste
	}
	
	/**
	 * 
	 * @return gibt eine neue einzigartige ID fuer Monteure zurueck
	 */
	public synchronized LinkedList<Long> getMonteurID() {
		if(this.monteurID.getLast()>=9223372036854775807l){ //Ist die maximale groesse eines Longs erreicht wird ein neuer Listeneintrag erstellt
			this.monteurID.add(0l);
			return (LinkedList<Long>) monteurID.clone(); //Klont die Liste
		}
		this.monteurID.set(this.monteurID.size()-1,this.monteurID.getLast()+1);
		return (LinkedList<Long>) monteurID.clone(); //Klont die Liste
	}
	
	/**
	 * 
	 * @return gibt eine neue einzigartige ID fuer Threadees zurueck
	 */
	public synchronized LinkedList<Long> getThreadeeID() {
		if(this.threadeeID.getLast()>=9223372036854775807l){ //Ist die maximale groesse eines Longs erreicht wird ein neuer Listeneintrag erstellt
			this.threadeeID.add(0l);
			return (LinkedList<Long>) threadeeID.clone(); //Klont die Liste
		}
		this.threadeeID.set(this.threadeeID.size()-1,this.threadeeID.getLast()+1);
		return (LinkedList<Long>) threadeeID.clone(); //Klont die Liste
	}
	/**
	 * generiert eine neue einzigartige ID
	 * @return gibt eine neue BauteilID zurueck
	 */
	public synchronized Integer[] getBauTeilID() {
		boolean erfolg=true;
		Random r=new Random(/*this.seed*/);
		HashSet<Integer> neueID;
		do{
			neueID=new HashSet<Integer>();
			for(int i=0;i<20;i++){
				boolean erfolg2=true;
				do{
					erfolg2=neueID.add(r.nextInt(1000));
				}while(!erfolg2);
			}
			erfolg=this.bauteilIDs.add(neueID);
		}while(!erfolg);
		Integer[] returnedArray=new Integer[neueID.size()];
		int i=0;
		for(Integer tmp:neueID){
			returnedArray[i]=tmp;
			i++;
		}
		return returnedArray; //Klont die Liste
	}
	/**
	 * Wandelt eine LinkedList aus longs in einen ID string um
	 * @param id die umzuwandelnde ID
	 * @return ein String in bindestrich getrenntem Format. zb(9999999-414)
	 */
	public static String idToString(LinkedList<Long> id) {
		String erg="";
		boolean first=true;
		for(long l:id){
			if(!first)erg+="-";
			erg+=l;
		}
		return erg;
		
	}
}
