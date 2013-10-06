/**
 * 
 */
package tgm.sew.hit.roboterfabrik.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import tgm.sew.hit.roboterfabrik.*;

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
		augen[1] = new Auge(s2);
		Arm[] arme = new Arm[2];
		arme[0] = new Arm(s3);
		arme[1] = new Arm(s4);
		LinkedList<Long> id = new LinkedList<Long>();
		id.add(1l);
		assertNotNull(new Threadee(id,id, augen, new Rumpf(s5), new Kettenantrieb(s6), arme, new Antenne(s1), new Greifer[]{new Greifer(s2),new Greifer(s3)}));
	}
	
	/**
	 * Testet die getID-Methode
	 */
	@Test
	public void testGetID() {
		Integer[] s1 = {6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7};
		Integer[] s2 = {0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100};
		Integer[] s3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		Integer[] s4 = {1,2,0,3,4,56,7,8,9,10,11,12,23,14,52,16,71,18,19,29};
		Integer[] s5 = {0,1,2,5,6,7,10,11,198,18,19,20,31,33,52,57,61,98,99,100};
		Integer[] s6 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,972,17,18,19,20};
		Auge[] augen = new Auge[2];
		augen[0] = new Auge(s1);
		augen[1] = new Auge(s2);
		Arm[] arme = new Arm[2];
		arme[0] = new Arm(s3);
		arme[1] = new Arm(s4);
		LinkedList<Long> id = new LinkedList<Long>();
		id.add(1l);
		Threadee t = new Threadee(id,id, augen, new Rumpf(s5), new Kettenantrieb(s6), arme, new Antenne(s1), new Greifer[]{new Greifer(s2),new Greifer(s3)});
		assertEquals(id, t.getID());
	}
	
	/**
	 * Testet die setMID-Methode
	 */
	@Test
	public void testSetMID() {
		Integer[] s1 = {6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7};
		Integer[] s2 = {0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100};
		Integer[] s3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		Integer[] s4 = {1,2,0,3,4,56,7,8,9,10,11,12,23,14,52,16,71,18,19,29};
		Integer[] s5 = {0,1,2,5,6,7,10,11,198,18,19,20,31,33,52,57,61,98,99,100};
		Integer[] s6 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,972,17,18,19,20};
		Auge[] augen = new Auge[2];
		augen[0] = new Auge(s1);
		augen[1] = new Auge(s2);
		Arm[] arme = new Arm[2];
		arme[0] = new Arm(s3);
		arme[1] = new Arm(s4);
		LinkedList<Long> id = new LinkedList<Long>();
		id.add(1l);
		Threadee t = new Threadee(id,id, augen, new Rumpf(s5), new Kettenantrieb(s6), arme, new Antenne(s1), new Greifer[]{new Greifer(s2),new Greifer(s3)});
		t.setMID(id);
		assertEquals(id, t.getMID());
	}
	
	/**
	 * Testet die toString-Methode
	 */
	@Test
	public void testToString() {
		Integer[] s1 = {6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7};
		Integer[] s2 = {0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100};
		Integer[] s3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		Integer[] s4 = {1,2,0,3,4,56,7,8,9,10,11,12,23,14,52,16,71,18,19,29};
		Integer[] s5 = {0,1,2,5,6,7,10,11,198,18,19,20,31,33,52,57,61,98,99,100};
		Integer[] s6 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,972,17,18,19,20};
		Auge[] augen = new Auge[2];
		augen[0] = new Auge(s1);
		augen[1] = new Auge(s2);
		Arm[] arme = new Arm[2];
		arme[0] = new Arm(s3);
		arme[1] = new Arm(s4);
		LinkedList<Long> id = new LinkedList<Long>();
		id.add(1l);
		Threadee t = new Threadee(id,id, augen, new Rumpf(s5), new Kettenantrieb(s6), arme, new Antenne(s1), new Greifer[]{new Greifer(s2),new Greifer(s3)});
		t.setMID(id);
		assertEquals("Threadee:1;Monteur:1;Auge,6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7;"
				+ "Auge,0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100;Rumpf,0,1,2,5,6,7,10,11,198,18,19,20,31,33,52,57,61,98,99,100;"
				+ "Kettenantrieb,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,972,17,18,19,20;Arm,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20;"
				+ "Arm,1,2,0,3,4,56,7,8,9,10,11,12,23,14,52,16,71,18,19,29;Antenne,6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7;"
				+ "Greifer,0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100;Greifer,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20", t.toString());
	}
	

}
