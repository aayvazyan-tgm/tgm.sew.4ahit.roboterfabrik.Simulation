package ayvazyanbelinic;


/**
 * Stellt ein Bestandteil des Roboters da.
 * Der Bestandteil wird vom Monteuer erzeugt wenn er den Roboter zusammen baut.
 * Den Namen und die Seriennummer werden aus dem File vom Monteur ausgelesen.
 * @author Vennesa Belinic
 * @version 2013-09-24
 */
public abstract class Bestandteil {

	
	//Attribut(e)
	
	/**
	 * Der Name des Bestandteiles.
	 * Auge, Kettenantrieb, Rumpf, Arm
	 */
	private String name;
	
	/**
	 * Die Seriennummer, in Form von 20 ganzstelligen zufälligen Zahlen(mit max 3 Stellen).
	 */
	private Integer[] snr;

	
	
	//Konstruktor(en)
	
	/**
	 * Konstruktor mir Parameter
	 * @param name Wert für das Attribut name
	 * @param snr Werte für das Attribut snr[]
	 */
	public Bestandteil(String name, Integer[] snr) {
		this.name = name;			//Hier ist keine Überprüfung nötig da, der name und die snr aus
		this.snr = snr;				//dem File ausgelesen werden, wenn der Monteur die Roboter zusammen baut.
	}
	
	
	
	//Methode(n)
	
	/**
	 * Sortiert die Zahlen im Seriennumern-Array, mit dem Bubbel-Sort Algorithmus
	 */
	public void sortieren() {
		int laenge = snr.length;
        int temp;
        
        for(int counter = 0; counter < laenge-1; counter++) {		//Bubble-Sort Algorithmus
            for(int i = 0; i < laenge-1; i++) {
                if(snr[i] > snr[i+1]) {					//Wenn die aktuelle zahl snr[i] größer ist 
                    temp = snr[i];						//als die nächste, werden sie vertauscht.
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
		
		for(int i = 0; i < snr.length; i++)		//wird dann in dieser Form ausgegeben:
			temp += "," + snr[i];				//Beispiel: Auge,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
			
		return temp;
	}

}
