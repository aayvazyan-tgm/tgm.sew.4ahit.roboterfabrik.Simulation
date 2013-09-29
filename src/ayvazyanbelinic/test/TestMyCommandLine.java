package ayvazyanbelinic.test;

import static org.junit.Assert.*;
import org.apache.commons.cli2.OptionException;
import org.junit.Test;
import ayvazyanbelinic.MyCommandLine;


/**
 * Testet alle Methoden und Konstruktoren der Klasse MyCommandLine.
 * @author Vennesa Belinic
 * @version 2013-09-27
 */
public class TestMyCommandLine {	
	
	
	//Methode(n)
	
	/**
	 * Testet den Konstruktor.
	 * Normalfall(alle verpflichtenden Optionen vorhanden mit gueltigen Werten der Argumente)
	 */
	@Test
	public void testMyCommandLine_1() {
		String[] args = {"--lager", "/roboterfabrik/lager/", "--logs", "/roboterfabrik/logs/", 
				"--lieferanten", "100", "--monteure", "100", "--laufzeit", "10000"};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			cli = null;
		}
	}
	
	/**
	 * Testet den Konstruktor.
	 * Normalfall(alle möglichen Optionen vorhanden mit gueltigen Werten der Argumente)
	 */
	@Test
	public void testMyCommandLine_2() {
		String[] args = {"--lager", "/roboterfabrik/lager/", "--logs", "/roboterfabrik/logs/", 
				"--lieferanten", "100", "--monteure", "100", "--laufzeit", "10000", "--lagermitarbeiter", "100"};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			cli = null;
		}
	}
	
	/**
	 * Testet den Konstruktor.
	 * Fehlerfall(alle möglichen Optionen vorhanden, mit ungueltigen Werten der Argumente(bei --lieferant))
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testMyCommandLine_3() {
		String[] args = {"--lager", "/roboterfabrik/lager/", "--logs", "/roboterfabrik/logs/", 
				"--lieferanten", "0", "--monteure", "100", "--laufzeit", "10000", "--lagermitarbeiter", "100"};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Testet den Konstruktor.
	 * Fehlerfall(alle möglichen Optionen vorhanden, mit ungueltigen Werten der Argumente(bei --monteur))
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testMyCommandLine_4() {
		String[] args = {"--lager", "/roboterfabrik/lager/", "--logs", "/roboterfabrik/logs/", 
				"--lieferanten", "10", "--monteure", "0", "--laufzeit", "10000", "--lagermitarbeiter", "100"};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Testet den Konstruktor.
	 * Fehlerfall(alle möglichen Optionen vorhanden, mit ungueltigen Werten der Argumente(bei --laufzeit))
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testMyCommandLine_5() {
		String[] args = {"--lager", "/roboterfabrik/lager/", "--logs", "/roboterfabrik/logs/", 
				"--lieferanten", "10", "--monteure", "10", "--laufzeit", "100", "--lagermitarbeiter", "100"};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Testet den Konstruktor.
	 * Fehlerfall(alle möglichen Optionen vorhanden, mit ungueltigen Werten der Argumente(bei --lagermitarbeiter))
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testMyCommandLine_6() {
		String[] args = {"--lager", "/roboterfabrik/lager/", "--logs", "/roboterfabrik/logs/", 
				"--lieferanten", "10", "--monteure", "10", "--laufzeit", "1000", "--lagermitarbeiter", "0"};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Testet den Konstruktor.
	 * Fehlerfall(alle möglichen Optionen fehlen)
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testMyCommandLine_7() {
		String[] args = {};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Testet den Konstruktor.
	 * Fehlerfall(alle möglichen Optionen vorhanden, mit ungueltigen Werten der Argumente(bei --lieferant))
	 */
	@Test
	public void testMyCommandLine_8() {
		String[] args = {"--lager", "/roboterfabrik/lager/", "--logs", "/roboterfabrik/logs/", 
				"--lieferanten", "blala", "--monteure", "100", "--laufzeit", "10000", "--lagermitarbeiter", "100"};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Testet den Konstruktor.
	 * Fehlerfall(alle möglichen Optionen vorhanden, mit ungueltigen Werten der Argumente(bei --monteur))
	 */
	@Test
	public void testMyCommandLine_9() {
		String[] args = {"--lager", "/roboterfabrik/lager/", "--logs", "/roboterfabrik/logs/", 
				"--lieferanten", "10", "--monteure", "blala", "--laufzeit", "10000", "--lagermitarbeiter", "100"};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Testet den Konstruktor.
	 * Fehlerfall(alle möglichen Optionen vorhanden, mit ungueltigen Werten der Argumente(bei --laufzeit))
	 */
	@Test
	public void testMyCommandLine_10() {
		String[] args = {"--lager", "/roboterfabrik/lager/", "--logs", "/roboterfabrik/logs/", 
				"--lieferanten", "10", "--monteure", "10", "--laufzeit", "blala", "--lagermitarbeiter", "100"};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Testet den Konstruktor.
	 * Fehlerfall(alle möglichen Optionen vorhanden, mit ungueltigen Werten der Argumente(bei --lagermitarbeiter))
	 */
	@Test
	public void testMyCommandLine_11() {
		String[] args = {"--lager", "/roboterfabrik/lager/", "--logs", "/roboterfabrik/logs/", 
				"--lieferanten", "10", "--monteure", "10", "--laufzeit", "1000", "--lagermitarbeiter", "blalaa"};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Testet die getLagerVerzeichnis-Methode
	 */
	@Test
	public void testGetLagerVerzeichnis() {
		String[] args = {"--lager", "/roboterfabrik/lager/", "--logs", "/roboterfabrik/logs/", 
				"--lieferanten", "100", "--monteure", "100", "--laufzeit", "10000"};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			cli = null;
		}
		assertEquals("/roboterfabrik/lager/", cli.getLagerVerzeichnis());
	}

	/**
	 * Testet die getLogVerzeichnis-Methode
	 */
	@Test
	public void testGetLogVerzeichnis() {
		String[] args = {"--lager", "/roboterfabrik/lager/", "--logs", "/roboterfabrik/logs/", 
				"--lieferanten", "100", "--monteure", "100", "--laufzeit", "10000"};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			cli = null;
		}
		assertEquals("/roboterfabrik/logs/", cli.getLogVerzeichnis());
	}

	/**
	 * Testet die getLieferantenAnzahl-Methode
	 */
	@Test
	public void testGetLieferantenAnzahl() {
		String[] args = {"--lager", "/roboterfabrik/lager/", "--logs", "/roboterfabrik/logs/", 
				"--lieferanten", "101", "--monteure", "102", "--laufzeit", "10003"};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			cli = null;
		}
		assertEquals(101, cli.getLieferantenAnzahl());
	}

	/**
	 * Testet die getMonteurAnzahl-Methode
	 */
	@Test
	public void testGetMonteurAnzahl() {
		String[] args = {"--lager", "/roboterfabrik/lager/", "--logs", "/roboterfabrik/logs/", 
				"--lieferanten", "101", "--monteure", "102", "--laufzeit", "10003"};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			cli = null;
		}
		assertEquals(102, cli.getMonteurAnzahl());
	}

	/**
	 * Testet die getLagerMitarbeiterAnzahl-Methode
	 */
	@Test
	public void testGetLagerMitarbeiterAnzahl() {
		String[] args = {"--lager", "/roboterfabrik/lager/", "--logs", "/roboterfabrik/logs/", 
				"--lieferanten", "101", "--monteure", "102", "--laufzeit", "10003", "--lagermitarbeiter", "104"};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			cli = null;
		}
		assertEquals(104, cli.getLagerMitarbeiterAnzahl());
	}

	/**
	 * Testet die getLaufzeit-Methode
	 */
	@Test
	public void testGetLaufzeit() {
		String[] args = {"--lager", "/roboterfabrik/lager/", "--logs", "/roboterfabrik/logs/", 
				"--lieferanten", "101", "--monteure", "102", "--laufzeit", "10003", "--lagermitarbeiter", "104"};
		MyCommandLine cli;
		try {
			assertNotNull(cli = new MyCommandLine(args));
		} catch (OptionException e) {
			cli = null;
		}
		assertEquals(10003, cli.getLaufzeit());
	}

}
