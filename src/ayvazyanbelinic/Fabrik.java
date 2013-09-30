/**
 * Fabrik erstellt mitarbeiter und fuegt sie dem watchdog hinzu.
 */
package ayvazyanbelinic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @author Ari Ayvazyan
 * @version 29.09.2013
 */
public class Fabrik {

	
	/**
	 * Threadpool fuer die Lagermitarbeiter
	 */
	private ThreadPoolExecutor lagerMitarbeiterPool;
	/**
	 *  Der Lagermitarbeiter
	 */
	private LagerMitarbeiter lagermitarbeiter;
	
	/**
	 * Threadpool fuer die lieferanten
	 */
	private ThreadPoolExecutor lieferantenPool;
	
	/**
	 *  Threadpool fuer die monteure
	 */
	private ThreadPoolExecutor monteurPool;
	
	/**
	 *  Das Sektretariat wird für die ID vergabe verwendet
	 */
	private Sekretariat sekretariat;
	
	
	/**
	 * 
	 * @param lagerVerz ist das Verzeichniss das fuer das lager zu verwenden ist
	 * @param lieferantenAnz ist die zu erstellende anzahl an lieferanten
	 * @param monteurAnz ist die zu erstellende anzahl an lieferanten
	 * @param lagerMAnz ist die zu erstellende anzahl an lieferanten
	 * @param laufzeit ist die laufzeit nach der die fabrik den mitarbeitern stop() mitteilt
	 */
	public Fabrik(String lagerVerz, int lieferantenAnz, int monteurAnz, int lagerMAnz, int laufzeit) {
		//erstellen des Sektritariats
		this.sekretariat=new Sekretariat();
		LinkedList<Stoppable> toWatch=new LinkedList<Stoppable>();
		/* LagerMitarbeiter */
		
		//erstellen des ThreadpoolExecutors und der zugehoerigen blockingqueue
		//BlockingQueue<Runnable> lagerMitarbeiterWorkQueue = new ArrayBlockingQueue<Runnable>(lagerMAnz/*Die kapazitaet*/) { /*Die blocking queque für den Threadpoolexecutor*/
		//};
		
		//this.lagerMitarbeiterPool=new ThreadPoolExecutor(lagerMAnz, lagerMAnz, 1, TimeUnit.SECONDS, lagerMitarbeiterWorkQueue);
		//erstellung der Mitarbeiter
		
		//for(int i=0;i<lagerMAnz;i++){ /*auskommentiert da im moment nur ein lagermitarbeiter unterstuetzt wird*/
		{
			LagerMitarbeiter lg=new LagerMitarbeiter(sekretariat.getLagerMID(), lagerVerz);
			//this.lagerMitarbeiterPool.execute(lg);
			this.lagermitarbeiter=lg;
			//toWatch.add(lg); // Hinzufuegen zu der liste fuer den Watchdog
		}
		//}
		
		
		/* Lieferanten */
		
		//erstellen des ThreadpoolExecutors und der zugehoerigen blockingqueue
		BlockingQueue<Runnable> lieferantenWorkQueue = new ArrayBlockingQueue<Runnable>(lieferantenAnz/*Die kapazitaet*/) { /*Die blocking queque für den Threadpoolexecutor*/
		};
		
		this.lieferantenPool=new ThreadPoolExecutor(lieferantenAnz, lieferantenAnz, 5, TimeUnit.SECONDS, lieferantenWorkQueue);
		
		//erstellung der Mitarbeiter
		for(int i=0;i<lieferantenAnz;i++){
			Lieferant lf=new Lieferant(sekretariat.getLieferantenID(), lagerVerz, this.lagermitarbeiter, sekretariat);
			this.lieferantenPool.execute(lf);
			toWatch.add(lf); // Hinzufuegen zu der liste fuer den Watchdog
		}
		
		
		/* Monteure */
		
		//erstellen des ThreadpoolExecutors und der zugehoerigen blockingqueue
		BlockingQueue<Runnable> monteureWorkQueue = new ArrayBlockingQueue<Runnable>(monteurAnz/*Die kapazitaet*/) { /*Die blocking queque für den Threadpoolexecutor*/
		};
		
		this.monteurPool=new ThreadPoolExecutor(monteurAnz, monteurAnz, 5, TimeUnit.SECONDS, monteureWorkQueue);
		//erstellung der Mitarbeiter
		for(int i=0;i<lieferantenAnz;i++){
			Monteur m=new Monteur(sekretariat.getMonteurID(), this.lagermitarbeiter);
			this.monteurPool.execute(m);
			toWatch.add(m); // Hinzufuegen zu der liste fuer den Watchdog
		}
		
		
		new Thread(new Watchdog(laufzeit, toWatch)).start(); //Startet den Watchdog in eimen neuem Thread.
	}
}
