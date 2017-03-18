package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.models.Disponibilite;

public class DisponibiliteTest {
	Disponibilite dispo1;
	Disponibilite dispo2;

	@Before
	public void setUp() throws Exception {
		dispo1 = new Disponibilite();
		dispo1.setHeureDebut(0);
		dispo1.setHeureFin(5);
		dispo1.setJour(4);

		dispo2 = new Disponibilite();
		dispo2.setHeureDebut(2);
		dispo2.setHeureFin(3);
		dispo2.setJour(4);
	}

	@Test
	public void testGetShareDiponibilte() throws Exception {
		Disponibilite dispoTest = dispo1.getShareDiponibilte(dispo2);
		assertEquals(2, dispoTest.getHeureDebut());
		assertEquals(3, dispoTest.getHeureFin());
	}

	@Test
	public void testAvancer() {
		int duree = 2;
		int before = dispo1.getHeureDebut();
		dispo1.avancer(duree);
		assertEquals(before + duree, dispo1.getHeureDebut());
	}

	@Test
	public void testDiminuer() {
		int duree = 2;
		int before = dispo1.getHeureFin();
		dispo1.diminuer(duree);
		assertEquals(before - duree, dispo1.getHeureFin());
	}
}
