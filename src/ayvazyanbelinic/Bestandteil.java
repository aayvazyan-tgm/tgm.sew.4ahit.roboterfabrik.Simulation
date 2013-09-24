package ayvazyanbelinic;


/**
 * 
 * @author Vennesa Belinic
 * @version 2013-09-24
 */
public class Bestandteil {

	
	//Attribut(e)
	
	/**
	 * Der Name des Bestandteiles.
	 * Auge, Kettenantrieb, Rumpf, Arm
	 */
	public String name;
	
	/**
	 * Die Seriennummer, in Form von 20 ganzstelligen zufälligen Zahlen.
	 */
	public int[] snr;

	
	
	//Methode(n)
	
	/**
	 * Sortiert die Zahlen im Seriennumern-Array
	 */
	public void sortieren() {
		int laenge = snr.length;
        int temp;
        
        for(int counter = 0; counter < laenge-1; counter++) {		//Bubble-Sort Algorithmus
            for(int i = 0; i < laenge-1; i++) {
                if(snr[i] > snr[i+1]) {
                    temp = snr[i];
                    snr[i] = snr[i+1];
                    snr[i+1] = temp;
                }
            }
        }
	}

	/**
	 * Gibt den Bestandteil als String zurück, wie er dann später im File steht
	 */
	@Override
	public String toString() {
		String temp = name;
		
		for(int i = 0; i < snr.length; i++)
			temp += "," + snr[i];
			
		return temp;
	}

}
