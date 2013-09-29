package ayvazyanbelinic;

import java.util.LinkedList;


/**
 * 
 * @author Ari Ayvazyan
 *
 *
 */
public class Watchdog implements Runnable {
	private long laufzeit;
	private LinkedList<Stoppable> toWatch;
	
	/**
	 * 
	 * @param laufzeit gibt an wie lange toStop ausgefuehrt werden soll bis es mit stop() beendet wird (sollte die aktion nicht schon abgeschlossen sein).
	 * @param toStop sind die Anzuhaltenden Runnables in einer LinkedList.
	 */
	public Watchdog(int laufzeit, LinkedList<Stoppable> toStop) {
		this.laufzeit=laufzeit;
		this.toWatch=toStop;
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
		for(Stoppable toStop:this.toWatch){//Sende ein Stop an sämtliche Stoppables in toWatch
			toStop.stop();
		}
	}

}
