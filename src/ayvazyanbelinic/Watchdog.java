package ayvazyanbelinic;


/**
 * 
 * @author Ari Ayvazyan
 *
 *
 */
public class Watchdog implements Runnable {
	private long laufzeit;
	private Stoppable toWatch;
	
	/**
	 * 
	 * @param laufzeit gibt an wie lange toStop ausgefuehrt werden soll bis es mit stop() beendet wird (sollte die aktion nicht schon abgeschlossen sein).
	 * @param toStop ist die Anzuhaltende Runnable.
	 */
	public Watchdog(int laufzeit, Stoppable toStop) {
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
		this.toWatch.stop();
	}

}
