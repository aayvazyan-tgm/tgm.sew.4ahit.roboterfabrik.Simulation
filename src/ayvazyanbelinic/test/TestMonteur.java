/**
 * 
 */
package ayvazyanbelinic.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import ayvazyanbelinic.LagerMitarbeiter;
import ayvazyanbelinic.Monteur;
import ayvazyanbelinic.Sekretariat;

/**
 * @author User
 *
 */
public class TestMonteur extends Monteur {

	public TestMonteur(LinkedList<Long> id, LagerMitarbeiter lagerM, Sekretariat sekretariat) {
		super(id, lagerM, sekretariat);
	}

	/**
	 * Test method for {@link ayvazyanbelinic.Monteur#Monteur(java.util.LinkedList, ayvazyanbelinic.LagerMitarbeiter, ayvazyanbelinic.Sekretariat)}.
	 */
	@Test
	public void testMonteur() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ayvazyanbelinic.Monteur#zusammenbauen(ayvazyanbelinic.Auge, ayvazyanbelinic.Auge, ayvazyanbelinic.Rumpf, ayvazyanbelinic.Kettenantrieb, ayvazyanbelinic.Arm, ayvazyanbelinic.Arm)}.
	 */
	@Test
	public void testZusammenbauen() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ayvazyanbelinic.Monteur#stop()}.
	 */
	@Test
	public void testStop() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ayvazyanbelinic.Monteur#run()}.
	 */
	@Test
	public void testRun() {
		fail("Not yet implemented");
	}

}
