package ayvazyanbelinic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.RandomAccess;
import java.util.Scanner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/**
 * Die Klasse LagerMitarbeiter kuemmert sich um Dateizugriffe
 *
 * @author Ari Ayvazyan
 * @version 30.09.2013
 */
public class LagerMitarbeiter{

	
	
	/** Die id. */
	private LinkedList<Long> id;
	
	/** Das lager Verzeichnis. */
	private String lagerVerzeichnis;
	
	
	
	/**
	 * Erstellt einen neuen LagerMitarbeiter
	 *
	 * @param id the id
	 * @param lagerVerzeichnis the lager verzeichnis
	 */
	public LagerMitarbeiter(LinkedList<Long> id, String lagerVerzeichnis) {
		this.id=id;
		this.lagerVerzeichnis=lagerVerzeichnis;
	}
	
	
	
	
	
	/**
	 * @param bestandteilname gibt ein Bestandteil des gewuenschten typs zurueck. Auge, Kettenantrieb, Rumpf, Arm
	 *
	 * @return das angeforderte Bestandteil, kann mit instanceof zugeordnet werden. Gibt null zurueck wenn das angeforderte Teil nicht vorhanden ist, oder ein fehler aufgetreten ist.
	 */
	public synchronized Bestandteil getBestandteil(String bestandteilname) {
		if(bestandteilname.equalsIgnoreCase("Arm")){
			File f=new File(lagerVerzeichnis+File.pathSeparator+"arme.csv");
			return getBestandTeilvonFile(f);
		}
		if(bestandteilname.equalsIgnoreCase("Rumpf")){
			File f=new File(lagerVerzeichnis+File.pathSeparator+"rumpf.csv");
			return getBestandTeilvonFile(f);
		}
		if(bestandteilname.equalsIgnoreCase("Auge")){
			File f=new File(lagerVerzeichnis+File.pathSeparator+"augen.csv");
			return getBestandTeilvonFile(f);
		}
		if(bestandteilname.equalsIgnoreCase("Kettenantrieb")){
			File f=new File(lagerVerzeichnis+File.pathSeparator+"kettenantrieb.csv");
			return getBestandTeilvonFile(f);
		}
		return null; //gibt null zurueck falls der bestandteilname nicht gefunden wird
	}
	/**
	 * nimmt sich aus dem gegebenem pfad ein bestandteil, entfernt ihn aus der Datei und gibt ihn als parameter zurueck. 
	 * Tritt ein fehler auf oder ist kein eintrag vorhanden wird null zurueckgegeben.
	 * @param f - ist der pfad aus dem der Bestandteil hergeleitet werden soll
	 * @return gibt den Bestandteil aus dem pfad zurueck
	 */
	private static Bestandteil getBestandTeilvonFile(File f) {
		try{
			Scanner fileScanner = new Scanner(f);
			if(!fileScanner.hasNext()){ //Sollte kein bestandteil vorhanden sein wird null zurueckgegeben
				fileScanner.close(); //filescanner vor dem return wieder freigeben
				return null;
			}
			String eingelesen=fileScanner.nextLine(); //Die gelesene Zeile
			FileWriter fileStream = new FileWriter(f);
			BufferedWriter out = new BufferedWriter(fileStream);
			while(fileScanner.hasNextLine()) { //schreibe die Datei ohne den bestandteil neu
			    String next = fileScanner.nextLine();
			    if(next.equals("\n")) out.newLine();
			    else out.write(next);
			    out.newLine();   
			}
			out.close(); //ressourcen freigeben
			fileScanner.close();
			fileStream.close();
			
			return Bestandteil.getBestandTeil(eingelesen); //wandelt den String aus dem file in ein Bestandteil objekt um.
        } catch (FileNotFoundException e){
            System.out.println("Error: "+e);
        } catch (Exception e)
        {
            System.out.println("Error: "+e);
        }
		return null; //bei auftreten eines fehlers wird null zurueckgegeben
	}





	/**
	 * 
	 * @param bestandteil das einzulagernde Bestandteil
	 * @return 
	 */
	public synchronized boolean einlagern(Bestandteil bestandteil) {
		Logger logger=Logger.getLogger("Arbeitsverlauf");
		logger.log(Level.INFO, "Bestandteil eingelagert: "+bestandteil.toString());
		return true;
	}
	
	/**
	 * 
	 * @param roboter
	 * @return
	 */
	public boolean einlagern(Threadee roboter) {
		return true;
	}


}
