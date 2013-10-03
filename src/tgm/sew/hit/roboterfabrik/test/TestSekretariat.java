package tgm.sew.hit.roboterfabrik.test;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Test;
import tgm.sew.hit.roboterfabrik.*;

/**
 * Testet die Klasse Threadee
 * @author Ari Ayvazyan
 * @version 03.10.2013
 */
public class TestSekretariat {

	/**
	 * Testet den Konstruktor()
	 */
	@Test
	public void testThreadee() {
		assertNotNull(new Sekretariat());
	}
	
	/**
	 * Testet die ID generatoren
	 */
	@Test
	public void testIDs() {
		Sekretariat s = new Sekretariat();
		s.getLagerMID();
		assertFalse(s.getLagerMID().getFirst()==s.getLagerMID().getFirst());
		assertFalse(s.getLieferantenID().getFirst()==s.getLieferantenID().getFirst());
		assertFalse(s.getMonteurID().getFirst()==s.getMonteurID().getFirst());
		assertFalse(s.getThreadeeID().getFirst()==s.getThreadeeID().getFirst());
		Integer[] bauteilID1=s.getBauTeilID();
		Integer[] bauteilID2=s.getBauTeilID();
		assertTrue(bauteilID1==bauteilID2);//beide bauteile sollten gleichviele stellen haben.
		assertNotSame(bauteilID1, bauteilID2);
	}
	/**
	 * Testet Die IDtoSting methode
	 */
	@Test
	public void testIDtoString() {
		LinkedList<Long> ll=new LinkedList<Long>();
		ll.add(11l);
		ll.add(6l);
		ll.add(14l);
		ll.add(6l);
		assertTrue("11-6-15-6".equals(Sekretariat.idToString(ll)));
	}

}
