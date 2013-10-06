/**
 * 
 */
package tgm.sew.hit.roboterfabrik.test;

import static org.junit.Assert.*;

import org.junit.Test;

import tgm.sew.hit.roboterfabrik.*;

/**
 * Die Monteur Klasse dirket wird nicht getestet, sondern ihr Inhalt(mit fix vergebenen Werten)
 * @author Vennesa Belinic
 * @version 2013-10-03
 */
public class TestMonteur {
	
	private Threadee temp;

	/**
	 * Testet den Konstruktor
	 */
	@Test
	public void testMonteur() {
		assertNotNull(new Monteur(null, null, null));
	}
	
	/**
	 * Code der in der zusammenfassen-Methode enthalten ist wird hier mit fixen Werten getestet
	 */
	@Test
	public void testZusammenbauen_1() {
		Integer[] s1 = {6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7};
		Integer[] s2 = {0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100};
		Integer[] s3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		Integer[] s4 = {1,2,0,3,4,56,7,8,9,10,11,12,23,14,52,16,71,18,19,29};
		Integer[] s5 = {0,1,2,5,6,7,10,11,198,18,19,20,31,33,52,57,61,98,99,100};
		Integer[] s6 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,972,17,18,19,20};
		Auge auge1 = new Auge(s1);
		Auge auge2 = new Auge(s2);
		Rumpf rumpf = new Rumpf(s3);
		Kettenantrieb antrieb = new Kettenantrieb(s4);
		Arm arm1 = new Arm(s5);
		Arm arm2 = new Arm(s6);
		Antenne antenne = new Antenne(s1);
		Greifer greifer1 = new Greifer(s2);
		Greifer greifer2 = new Greifer(s3);
		if(auge1 != null && auge2 != null && rumpf != null && antrieb != null && arm1 != null 
				&& arm2 != null && antenne != null && greifer1 != null && greifer2 != null) {		
			auge1.sortieren();																							//wenn keines der Teile null ist
			auge2.sortieren();																							//wird der Roboter zusammengebaut
			rumpf.sortieren();																							//(sortieren der Seriennummer)
			antrieb.sortieren();
			arm1.sortieren();
			arm2.sortieren();
			antenne.sortieren();
			greifer1.sortieren();
			greifer2.sortieren();
			
			Auge[] augen = {auge1, auge2};
			Arm[] arme = {arm1, arm2};
			Greifer[] greifer = {greifer1, greifer2};
			
			temp = new Threadee(null,null, augen, rumpf, antrieb, arme, antenne, greifer);
		} else {
			temp = null;
		}
		assertNotNull(temp);
	}
	
	/**
	 * Code der in der zusammenfassen-Methode enthalten ist wird hier mit fixen Werten getestet
	 */
	@Test
	public void testZusammenbauen_2() {
		Integer[] s1 = {6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7};
		Integer[] s2 = {0,1,2,5,6,7,10,11,14,18,19,20,31,33,52,57,61,98,99,100};
		Integer[] s3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		Integer[] s4 = {1,2,0,3,4,56,7,8,9,10,11,12,23,14,52,16,71,18,19,29};
		Integer[] s5 = {0,1,2,5,6,7,10,11,198,18,19,20,31,33,52,57,61,98,99,100};
		Integer[] s6 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,972,17,18,19,20};
		Auge auge1 = null;
		Auge auge2 = new Auge(s2);
		Rumpf rumpf = new Rumpf(s3);
		Kettenantrieb antrieb = new Kettenantrieb(s4);
		Arm arm1 = new Arm(s5);
		Arm arm2 = new Arm(s6);
		Antenne antenne = new Antenne(s1);
		Greifer greifer1 = new Greifer(s2);
		Greifer greifer2 = new Greifer(s3);
		if(auge1 != null && auge2 != null && rumpf != null && antrieb != null && arm1 != null 
				&& arm2 != null && antenne != null && greifer1 != null && greifer2 != null) {		
			auge1.sortieren();																							//wenn keines der Teile null ist
			auge2.sortieren();																							//wird der Roboter zusammengebaut
			rumpf.sortieren();																							//(sortieren der Seriennummer)
			antrieb.sortieren();
			arm1.sortieren();
			arm2.sortieren();
			antenne.sortieren();
			greifer1.sortieren();
			greifer2.sortieren();
			
			Auge[] augen = {auge1, auge2};
			Arm[] arme = {arm1, arm2};
			Greifer[] greifer = {greifer1, greifer2};
			
			temp = new Threadee(null,null, augen, rumpf, antrieb, arme, antenne, greifer);
		} else {
			temp = null;
		}
		assertNull(temp);
	}

	/**
	 * Testet die stop-Methode
	 */
	@Test
	public void testStop() {
		Monteur m = new Monteur(null,null,null);
		m.stop();
		assertTrue(m.getStop());
	}
	
	/**
	 * Wird zum testen der run-Methode benötigt
	 */
	public void testZusammenbauen(Auge auge1, Auge auge2, Rumpf rumpf, Kettenantrieb antrieb, Arm arm1, Arm arm2, Antenne antenne, Greifer greifer1, Greifer greifer2) {
		if(auge1 != null && auge2 != null && rumpf != null && antrieb != null && arm1 != null 
				&& arm2 != null && antenne != null && greifer1 != null && greifer2 != null) {		
			auge1.sortieren();																							//wenn keines der Teile null ist
			auge2.sortieren();																							//wird der Roboter zusammengebaut
			rumpf.sortieren();																							//(sortieren der Seriennummer)
			antrieb.sortieren();
			arm1.sortieren();
			arm2.sortieren();
			antenne.sortieren();
			greifer1.sortieren();
			greifer2.sortieren();
			
			Auge[] augen = {auge1, auge2};
			Arm[] arme = {arm1, arm2};
			Greifer[] greifer = {greifer1, greifer2};
			
			temp = new Threadee(null,null, augen, rumpf, antrieb, arme, antenne, greifer);
		} else {
			temp = null;
		}
	}

	/**
	 * Code der in der run-Methode enthalten ist wird hier mit fixen Werten getestet
	 */
	@Test
	public void testRun_1() {
		Auge auge1 = null, auge2 = null;
		Rumpf rumpf = null;
		Kettenantrieb antrieb = null;
		Arm arm1 = null, arm2 = null;
		Antenne antenne = null;
		Greifer greifer1 = null, greifer2 = null;
		
		Bestandteil temp1 = new Auge(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp1 != null && temp1 instanceof  Auge) {
			auge1 = (Auge) temp1;
		} else {}
			//loggen									
		Bestandteil temp2 = new Auge(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp2 != null && temp2 instanceof  Auge) {
			auge2 = (Auge) temp2;
		} else {}
			//loggen
		Bestandteil temp3 = new Rumpf(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp3 != null && temp3 instanceof  Rumpf) {
			rumpf = (Rumpf) temp3;
		} else {}
			//loggen
		Bestandteil temp4 = new Kettenantrieb(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp4 != null && temp4 instanceof  Kettenantrieb) {
			antrieb = (Kettenantrieb) temp4;
		} else {}
			//loggen
		Bestandteil temp5 = new Arm(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp5 != null && temp5 instanceof  Arm) {
			arm1 = (Arm) temp5;
		} else {}
			//loggen	
		Bestandteil temp6 = new Arm(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp6 != null && temp6 instanceof  Arm) {
			arm2 = (Arm) temp6;
		} else {}
			//loggen
		Bestandteil temp7 = new Antenne(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp7 != null && temp7 instanceof  Antenne) {
			antenne = (Antenne) temp7;
		} else {}
			//loggen
		Bestandteil temp8 = new Greifer(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp8 != null && temp8 instanceof  Greifer) {
			greifer1 = (Greifer) temp8;
		} else {}
			//loggen
		Bestandteil temp9 = new Greifer(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp9 != null && temp9 instanceof  Greifer) {
			greifer2 = (Greifer) temp9;
		} else {}
			//loggen
		testZusammenbauen(auge1, auge2, rumpf, antrieb, arm1, arm2, antenne, greifer1, greifer2);
		assertNotNull(temp);
	}
	
	/**
	 * Code der in der run-Methode enthalten ist wird hier mit fixen Werten getestet
	 */
	@Test
	public void testRun_2() {
		Auge auge1 = null, auge2 = null;
		Rumpf rumpf = null;
		Kettenantrieb antrieb = null;
		Arm arm1 = null, arm2 = null;
		Antenne antenne = null;
		Greifer greifer1 = null, greifer2 = null;
		
		Bestandteil temp1 = new Auge(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp1 != null && temp1 instanceof  Auge) {
			auge1 = (Auge) temp1;
		} else {}
			//loggen									
		Bestandteil temp2 = new Auge(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp2 != null && temp2 instanceof  Auge) {
			auge2 = (Auge) temp2;
		} else {}
			//loggen
		Bestandteil temp3 = new Rumpf(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp3 != null && temp3 instanceof  Rumpf) {
			rumpf = (Rumpf) temp3;
		} else {}
			//loggen
		Bestandteil temp4 = new Arm(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp4 != null && temp4 instanceof  Kettenantrieb) {
			antrieb = (Kettenantrieb) temp4;
		} else {}
			//loggen
		Bestandteil temp5 = new Arm(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp5 != null && temp5 instanceof  Arm) {
			arm1 = (Arm) temp5;
		} else {}
			//loggen	
		Bestandteil temp6 = new Arm(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp6 != null && temp6 instanceof  Arm) {
			arm2 = (Arm) temp6;
		} else {}
			//loggen
		Bestandteil temp7 = new Antenne(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp7 != null && temp7 instanceof  Antenne) {
			antenne = (Antenne) temp7;
		} else {}
			//loggen
		Bestandteil temp8 = new Greifer(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp8 != null && temp8 instanceof  Greifer) {
			greifer1 = (Greifer) temp8;
		} else {}
			//loggen
		Bestandteil temp9 = new Greifer(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp9 != null && temp9 instanceof  Greifer) {
			greifer2 = (Greifer) temp9;
		} else {}
			//loggen
		testZusammenbauen(auge1, auge2, rumpf, antrieb, arm1, arm2, antenne, greifer1, greifer2);		assertNull(temp);
	}
	
	/**
	 * Code der in der run-Methode enthalten ist wird hier mit fixen Werten getestet
	 */
	@Test
	public void testRun_3() {
		Auge auge1 = null, auge2 = null;
		Rumpf rumpf = null;
		Kettenantrieb antrieb = null;
		Arm arm1 = null, arm2 = null;
		Antenne antenne = null;
		Greifer greifer1 = null, greifer2 = null;
		
		Bestandteil temp1 = new Auge(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp1 != null && temp1 instanceof  Auge) {
			auge1 = (Auge) temp1;
		} else {}
			//loggen									
		Bestandteil temp2 = null;
		if(temp2 != null && temp2 instanceof  Auge) {
			auge2 = (Auge) temp2;
		} else {}
			//loggen
		Bestandteil temp3 = new Rumpf(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp3 != null && temp3 instanceof  Rumpf) {
			rumpf = (Rumpf) temp3;
		} else {}
			//loggen
		Bestandteil temp4 = new Kettenantrieb(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp4 != null && temp4 instanceof  Kettenantrieb) {
			antrieb = (Kettenantrieb) temp4;
		} else {}
			//loggen
		Bestandteil temp5 = new Arm(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp5 != null && temp5 instanceof  Arm) {
			arm1 = (Arm) temp5;
		} else {}
			//loggen	
		Bestandteil temp6 = new Arm(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp6 != null && temp6 instanceof  Arm) {
			arm2 = (Arm) temp6;
		} else {}
			//loggen
		Bestandteil temp7 = new Antenne(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp7 != null && temp7 instanceof  Antenne) {
			antenne = (Antenne) temp7;
		} else {}
			//loggen
		Bestandteil temp8 = new Greifer(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp8 != null && temp8 instanceof  Greifer) {
			greifer1 = (Greifer) temp8;
		} else {}
			//loggen
		Bestandteil temp9 = new Greifer(new Integer[]{6,0,1,57,98,2,11,20,5,10,19,33,31,61,99,100,52,18,14,7});
		if(temp9 != null && temp9 instanceof  Greifer) {
			greifer2 = (Greifer) temp9;
		} else {}
			//loggen
		testZusammenbauen(auge1, auge2, rumpf, antrieb, arm1, arm2, antenne, greifer1, greifer2);
		assertNull(temp);
	}

}
