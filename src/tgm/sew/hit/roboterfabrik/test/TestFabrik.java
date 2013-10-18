package tgm.sew.hit.roboterfabrik.test;

import static org.junit.Assert.*;

import org.junit.Test;

import tgm.sew.hit.roboterfabrik.Fabrik;

public class TestFabrik {

	@Test
	public void testFabrik() {
		new Fabrik("", 1, 1, 1, 100);
	}

}
