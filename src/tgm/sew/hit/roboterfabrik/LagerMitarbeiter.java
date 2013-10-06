package tgm.sew.hit.roboterfabrik;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.LinkedList;
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
			File f=new File(lagerVerzeichnis+File.separator+"arme.csv");
			return getBestandTeilvonFile(f);
		}
		if(bestandteilname.equalsIgnoreCase("Rumpf")){
			File f=new File(lagerVerzeichnis+File.separator+"rumpf.csv");
			return getBestandTeilvonFile(f);
		}
		if(bestandteilname.equalsIgnoreCase("Auge")){
			File f=new File(lagerVerzeichnis+File.separator+"augen.csv");
			return getBestandTeilvonFile(f);
		}
		if(bestandteilname.equalsIgnoreCase("Kettenantrieb")){
			File f=new File(lagerVerzeichnis+File.separator+"kettenantriebe.csv");
			return getBestandTeilvonFile(f);
		}
		if(bestandteilname.equalsIgnoreCase("Antenne")){
			File f=new File(lagerVerzeichnis+File.separator+"antenne.csv");
			return getBestandTeilvonFile(f);
		}
		if(bestandteilname.equalsIgnoreCase("Greifer")){
			File f=new File(lagerVerzeichnis+File.separator+"greifer.csv");
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
	private synchronized Bestandteil getBestandTeilvonFile(File f) {
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
			    if(next.equals("\n")) out.newLine(); //eig. nicht noetig, trotzdem zur fehlertolleranz eingebunden
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
	 * @return gibt zurueck ob die funktion erfolgreich ausgefuehrt wurde.
	 */
	public synchronized boolean einlagern(Bestandteil bestandteil) {
		Logger logger=Logger.getLogger("Arbeitsverlauf");
		File f=new File("");
		if(bestandteil instanceof Arm){
			f=new File(lagerVerzeichnis+File.separator+"arme.csv");
		}
		if(bestandteil instanceof Rumpf){
			f=new File(lagerVerzeichnis+File.separator+"rumpf.csv");
		}
		if(bestandteil instanceof Auge){
			f=new File(lagerVerzeichnis+File.separator+"augen.csv");
		}
		if(bestandteil instanceof Kettenantrieb){
			f=new File(lagerVerzeichnis+File.separator+"kettenantriebe.csv");
		}
		if(bestandteil instanceof Antenne){
			f=new File(lagerVerzeichnis+File.separator+"antenne.csv");
		}
		if(bestandteil instanceof Greifer){
			f=new File(lagerVerzeichnis+File.separator+"greifer.csv");
		}
		try{
			//Inhalt auslesen und abspeichern
			//Inhalt auslesen und abspeichern
			Scanner fileScanner = new Scanner(f);
			LinkedList<String> fileData=new LinkedList<String>();
			while(fileScanner.hasNextLine()) { //einlesen vor dem hinzufuegen
			    String next = fileScanner.nextLine();
			    fileData.add(next);
			}
			fileScanner.close();
			FileWriter fileStream = new FileWriter(f);
			BufferedWriter out = new BufferedWriter(fileStream);
			//Bestandteil am begin des files hinzufuegen
			out.write(bestandteil.toString());
			out.newLine();
			for(String output:fileData){
				out.write(output);
				out.newLine();
			}
			out.close(); //ressourcen freigeben
			fileStream.close();
		}catch(Exception e){
			logger.log(Level.INFO, "Konnte ein bestandteil nicht einlagern");
			return false;
		}
		logger.log(Level.INFO, "Bestandteil eingelagert: "+bestandteil.toString());
		return true;
	}
	
	/**
	 *  Lagert einen Threadee in ein File ein
	 * @param thradee der einzulagernde Threadee
	 * @return gibt bei erfolgreichem schreiben true zurueck
	 */
	public synchronized boolean einlagern(Threadee threadee) {
		Logger logger=Logger.getLogger("Arbeitsverlauf");
		File f=new File("");
		f=new File(lagerVerzeichnis+File.separator+"threadees.csv");
		try{
			//Inhalt auslesen und abspeichern
			Scanner fileScanner = new Scanner(f);
			LinkedList<String> fileData=new LinkedList<String>();
			while(fileScanner.hasNextLine()) { //einlesen vor dem hinzufuegen
			    String next = fileScanner.nextLine();
			    fileData.add(next);
			}
			fileScanner.close();
			FileWriter fileStream = new FileWriter(f);
			BufferedWriter out = new BufferedWriter(fileStream);
			//Threadee am begin des files hinzufuegen
			out.write(threadee.toString());
			out.newLine();
			for(String output:fileData){
				out.write(output);
				out.newLine();
			}
			out.close(); //ressourcen freigeben
			fileStream.close();
		}catch(Exception e){
			logger.log(Level.INFO, "Konnte ein threadee nicht einlagern");
			return false;
		}
		logger.log(Level.INFO, "Threadee eingelagert: "+threadee.toString());
		return true;
	}


}
