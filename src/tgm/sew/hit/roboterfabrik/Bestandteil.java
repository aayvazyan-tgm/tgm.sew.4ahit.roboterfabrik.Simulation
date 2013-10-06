package tgm.sew.hit.roboterfabrik;


/**
 * Stellt ein Bestandteil des Roboters da.
 * Der Bestandteil wird vom Monteuer erzeugt wenn er den Roboter zusammen baut.
 * Den Namen und die Seriennummer werden aus dem File vom Monteur ausgelesen.
 * @author Vennesa Belinic, Ari Ayvazyan
 * @version 2013-10-01
 */
public abstract class Bestandteil {

	
	//Attribut(e)
	
	/**
	 * Der Name des Bestandteiles.
	 * Auge, Kettenantrieb, Rumpf, Arm
	 */
	private String name;
	
	/**
	 * Die Seriennummer, in Form von 20 ganzstelligen zufaelligen Zahlen(mit max 3 Stellen).
	 */
	private Integer[] snr;

	
	
	//Konstruktor(en)
	
	/**
	 * Konstruktor mir Parameter
	 * @param name Wert fuer das Attribut name
	 * @param snr Werte fuer das Attribut snr[]
	 */
	public Bestandteil(String name, Integer[] snr) {
		this.name = name;			//Hier ist keine Ueberpruefung noetig da, der name und die snr aus
		this.snr = snr;				//dem File ausgelesen werden, wenn der Monteur die Roboter zusammen baut.
	}
	
	
	
	
	/**
	 * Sortiert die Zahlen im Seriennumern-Array, mit dem Bubbel-Sort Algorithmus
	 */
	public void sortieren() {
		int laenge = snr.length;
        int temp;
        
        for(int counter = 0; counter < laenge-1; counter++) {		//Bubble-Sort Algorithmus
            for(int i = 0; i < laenge-1; i++) {
                if(snr[i] > snr[i+1]) {					//Wenn die aktuelle zahl snr[i] groesser ist 
                    temp = snr[i];						//als die naechste, werden sie vertauscht.
                    snr[i] = snr[i+1];
                    snr[i+1] = temp;
                }
            }
        }
	}

	/**
	 * Gibt den Bestandteil als String zurueck, wie er dann sp√§ter im File steht
	 */
	@Override
	public String toString() {
		String temp = name;
		
		for(int i = 0; i < snr.length; i++)		//wird dann in dieser Form ausgegeben:
			temp += "," + snr[i];				//Beispiel: Auge,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
			
		return temp;
	}


	/**
	 * Gegenteilige funktion von toString. 
	 * Hier wird anhand eines von toString erstellten Strings ein vom Bestandteil erbendes Objekt erzeugt.
	 * @param eingelesen ist im selbem for mat wie die toString methode
	 * @return gibt das bestandteil zu dem eingelesenen String zurueck, das bestandteil kann mit 
	 * instanceof Auge, Rumpf und co zugeordnet werden. Wenn etwas beim Verarbeiten schief laeuft 
	 * wird null zur¸ckgegeben.
	 */
	public static Bestandteil getBestandTeil(String bestandTeilString) {
		String [] teil = bestandTeilString.split(",");
		String name = teil[0];
		Integer[] snr = new Integer[20];
		
		for(int i = 1; i < teil.length; i++) {		//Die Zahlen werden in die Seriennummer gespeichert.
			try {
				snr[i-1] = Integer.parseInt(teil[i]);
			} catch(NumberFormatException e) {		//Wenn die Strings keine Zahlen sind wird eine Fehlermeldung zur¸ckgegeben
				name = "";							//und der Name auf "" gesetzt damit null returned wird.
				System.out.println("Es ist ein Fehler beim Auslesen der Bestanteile entstanden");
			}
		}
		
		Bestandteil temp = null;		//Wird mit null initialisiert damit wenn Fehler auftreten
										//null zur¸ckgegeben wird.
		if(name.equals("Auge"))
			temp = new Auge(snr);
		
		if(name.equals("Rumpf"))
			temp = new Rumpf(snr);
		
		if(name.equals("Kettenantrieb"))
			temp = new Kettenantrieb(snr);
		
		if(name.equals("Arm"))
			temp = new Arm(snr);
		
		if(name.equals("Antenne"))
			temp = new Antenne(snr);
		
		if(name.equals("Greifer"))
			temp = new Greifer(snr);
		
		return temp;
	}

}
