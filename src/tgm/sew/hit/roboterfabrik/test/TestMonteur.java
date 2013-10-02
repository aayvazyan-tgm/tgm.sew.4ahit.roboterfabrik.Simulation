/**
 * 
 */
package tgm.sew.hit.roboterfabrik.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import tgm.sew.hit.roboterfabrik.LagerMitarbeiter;
import tgm.sew.hit.roboterfabrik.Monteur;
import tgm.sew.hit.roboterfabrik.Sekretariat;

/**
 * @author User
 *
 */
public class TestMonteur extends Monteur {

	public TestMonteur(LinkedList<Long> id, LagerMitarbeiter lagerM, Sekretariat sekretariat) {
		super(id, lagerM, sekretariat);
	}

	/**
	 * Test method for {@link tgm.sew.hit.roboterfabrik.Monteur#Monteur(java.util.LinkedList, tgm.sew.hit.roboterfabrik.LagerMitarbeiter, tgm.sew.hit.roboterfabrik.Sekretariat)}.
	 */
	@Test
	public void testMonteur() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link tgm.sew.hit.roboterfabrik.Monteur#zusammenbauen(tgm.sew.hit.roboterfabrik.Auge, tgm.sew.hit.roboterfabrik.Auge, tgm.sew.hit.roboterfabrik.Rumpf, tgm.sew.hit.roboterfabrik.Kettenantrieb, tgm.sew.hit.roboterfabrik.Arm, tgm.sew.hit.roboterfabrik.Arm)}.
	 */
	@Test
	public void testZusammenbauen() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link tgm.sew.hit.roboterfabrik.Monteur#stop()}.
	 */
	@Test
	public void testStop() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link tgm.sew.hit.roboterfabrik.Monteur#run()}.
	 */
	@Test
	public void testRun() {
		fail("Not yet implemented");
	}

}
