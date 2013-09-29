package ayvazyanbelinic.test;

import static org.junit.Assert.*;
import org.junit.Test;
import ayvazyanbelinic.*;

/**
 * Testet alle Methoden der Klasse Bestandteile.
 * Arbeitet mit den erbenden Klassen, da diese alle keine weiteren Methoden implementieren,
 * und dadurch alle Methoden, und auch alle Konstruktoren getestet werden.
 * @author Vennesa Belinic
 * @version 2013-09-24
 */
public class TestBestandteil {

	
	//Attribut(e)
	
	/**
	 * Attribut um alle Methoden testen zu können.
	 */
	private Bestandteil teil;
	
	
	
	//Methode(n)
	
	/**
	 * Testet den Konstruktor mit normalen Werten.
	 * Da keine weiteren Fälle auftreten können, gibt es für den Konstruktor nur diese Testfall.
	 * (Begründung: Dokumentation von Bestandteil)
	 */
	@Test
	public void testBestandteil_1() {
		int[] s = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		teil = new Auge(s);
		assertNotNull(teil);
	}
	
	/**
	 * Testet die toString-Methode
	 */
	@Test
	public void testToString_1() {
		int[] s = {6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7};
		teil = new Auge(s);
		assertEquals("Auge,6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7", teil.toString());
	}
	
	/**
	 * Testet die toString-Methode
	 */
	@Test
	public void testToString_2() {
		int[] sortiert = {0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100};
		teil = new Kettenantrieb(sortiert);
		assertEquals("Kettenantrieb,0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100", teil.toString());
	}
	
	/*
	 * Ich teste die sortieren Methode nicht mit mehr als 20 Zahlen, es immer 20 Zahlen sind.
	 * Begründung: Dokumentation Bestandteil.
	 */
	
	/**
	 * Testet die sortieren Methode mit 20 Zahlen, die unsortiert sind(zufällige Reihenfolge)
	 */
	@Test
	public void testSortieren_1() {
		int[] s = {6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7};
		int[] sortiert = {0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100};
		teil = new Arm(s);
		teil.sortieren();
		assertEquals("Arm,0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100", teil.toString());
	}
	
	/**
	 * Testet die sortieren Methode mit 20 Zahlen, die sortiert sind.
	 */
	@Test
	public void testSortieren_2() {
		int[] sortiert = {0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100};
		teil = new Rumpf(sortiert);
		teil.sortieren();
		assertEquals("Rumpf,0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100", teil.toString());
	}
	
	/**
	 * Testet die sortieren Methode mit 20 Zahlen, die unsortiert sind(verkehrte Reihnfolge)
	 */
	@Test
	public void testSortieren_3() {
		int[] s = {100,99,98,61,57,52,33,31,20,19,18,14,11,10,7,6,5,2,1,0};
		int[] sortiert = {0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100};
		teil = new Rumpf(s);
		teil.sortieren();
		assertEquals("Rumpf,0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100" , teil.toString());
	}

}
