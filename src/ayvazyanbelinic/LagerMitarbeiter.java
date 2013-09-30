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
	 * @return das angeforderte Bestandteil, kann mit instanceof zugeordnet werden. Gibt null zurueck wenn das angeforderte Teil nicht vorhanden ist, oder ein 
	 */
	public synchronized Bestandteil getBestandteil(String bestandteilname) {
		if(bestandteilname.equalsIgnoreCase("Arm")){
			File f=new File(lagerVerzeichnis+File.pathSeparator+"arme.csv");
			try{
				Scanner fileScanner = new Scanner(f);
				if(!fileScanner.hasNext()){
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
	        } catch (IOException e)
	        {
	            System.out.println("Error: "+e);
	        }
		}
		if(bestandteilname.equalsIgnoreCase("Rumpf")){
			File f=new File(lagerVerzeichnis+File.pathSeparator+"rumpf.csv");
		}
		if(bestandteilname.equalsIgnoreCase("Auge")){
			File f=new File(lagerVerzeichnis+File.pathSeparator+"augen.csv");
		}
		if(bestandteilname.equalsIgnoreCase("Kettenantrieb")){
			File f=new File(lagerVerzeichnis+File.pathSeparator+"kettenantrieb.csv");
		}
		return null;
	}
	


}
