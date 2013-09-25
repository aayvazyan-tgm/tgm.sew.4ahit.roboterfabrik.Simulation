/**
 * 
 */
package ayvazyanbelinic.test;

import static org.junit.Assert.*;
import org.junit.Test;
import ayvazyanbelinic.Bestandteil;
import ayvazyanbelinic.Threadee;

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
		int[] s1 = {6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7};
		int[] s2 = {0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100};
		int[] s3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int[] s4 = {1,2,0,3,4,56,7,8,9,10,11,12,23,14,52,16,71,18,19,29};
		int[] s5 = {0,1,2,5,6,7,10,11,198,18,19,20,31,33,52,57,61,98,99,100};
		int[] s6 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,972,17,18,19,20};
		Bestandteil[] teil = {new Bestandteil("Auge", s1), new Bestandteil("Auge", s2), 
				new Bestandteil("Rumpf", s3), new Bestandteil("Kettenantrieb", s4), 
				new Bestandteil("Arm", s5), new Bestandteil("Arm", s6)};
		assertNotNull(new Threadee(123, teil));
	}

}
