/**
 * 
 */
package ayvazyanbelinic.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;
import ayvazyanbelinic.*;

/**
 * Testet die Klasse Threadee
 * @author Vennesa Belinic
 * @version 2013-09-25
 */
public class TestThreadee {

	/**
	 * Testet den Konstruktor(weitere Testfälle sind nicht nötig Grund siehe Dokumentation Threadee)
	 */
	@Test
	public void testThreadee() {
		Integer[] s1 = {6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7};
		Integer[] s2 = {0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100};
		Integer[] s3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		Integer[] s4 = {1,2,0,3,4,56,7,8,9,10,11,12,23,14,52,16,71,18,19,29};
		Integer[] s5 = {0,1,2,5,6,7,10,11,198,18,19,20,31,33,52,57,61,98,99,100};
		Integer[] s6 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,972,17,18,19,20};
		Auge[] augen = new Auge[2];
		augen[0] = new Auge(s1);
		augen[0] = new Auge(s2);
		Arm[] arme = new Arm[2];
		arme[0] = new Arm(s3);
		arme[0] = new Arm(s4);
		HashSet<Long> id = new HashSet<Long>();
		id.add(1l);
		assertNotNull(new Threadee(id, augen, new Rumpf(s5), new Kettenantrieb(s6), arme));
	}

}
