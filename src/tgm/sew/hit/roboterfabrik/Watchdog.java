package tgm.sew.hit.roboterfabrik;

import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/**
 * 
 * @author Ari Ayvazyan
 *
 *
 */
public class Watchdog implements Runnable {
	private long laufzeit;
	private LinkedList<Stoppable> toWatch;
	private LinkedList<ThreadPoolExecutor> executors;
	
	/**
	 * 
	 * @param laufzeit gibt an wie lange toStop ausgefuehrt werden soll bis es mit stop() beendet wird (sollte die aktion nicht schon abgeschlossen sein).
	 * @param toStop sind die Anzuhaltenden Runnables in einer LinkedList.
	 * @param threadPoolExecutors 
	 */
	public Watchdog(int laufzeit, LinkedList<Stoppable> toStop, LinkedList<ThreadPoolExecutor> threadPoolExecutors) {
		this.laufzeit=laufzeit;
		this.toWatch=toStop;
		this.executors=threadPoolExecutors;
	}

	/**
	 * Der Watchdog wird gestartet und fuehrt stop() aus sobald die angegebene laufzeit abgelaufen ist.
	 * Run fuehrt die runnable nicht aus!
	 */
	public void run() {
		try {
			Thread.sleep(this.laufzeit);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Logger lg=Logger.getLogger("Arbeitsverlauf");
		lg.log(Level.INFO, "Der Betrieb wird wieder eingestellt.");
		for(Stoppable toStop:this.toWatch){//Sende ein Stop an sämtliche Stoppables in toWatch
			toStop.stop();
		}
		for(ThreadPoolExecutor ex:this.executors){
			ex.shutdown(); //schliesst den Executorpool und laesst laufende klassen noch zu ende laufen
		}
	}

}
