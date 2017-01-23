package ent;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EDTTest {
	EDT edt;
	int nbJours = 1;
	int nbHours = 6;
	
	@Before
	public void setUp() throws Exception {
		edt =new EDT();
		edt.initialize(nbJours, nbHours);
	}

	@Test
	public void testInitialize() {
		assertEquals(1, edt.getDisponibilites().size());
	}
	@Test
	public void testPlacerCoursMilieuDisponibilite(){
		Cours cours = new Cours();
		cours.setJour(0);
		cours.setHeureDebut(1);
		cours.setDuree(1);
		edt.placerCours(cours);
		assertEquals(2, edt.getDisponibilites().size());
	}
	@Test
	public void testPlacerCoursFinDisponibilite(){
		Cours cours = new Cours();
		cours.setJour(0);
		cours.setHeureDebut(nbHours-1);
		cours.setDuree(1);
		edt.placerCours(cours);
		assertEquals(2, edt.getDisponibilites().size());
	}
	@Test
	public void testPlacerCoursDebutDisponibilite(){
		Cours cours = new Cours();
		cours.setJour(0);
		cours.setHeureDebut(0);
		cours.setDuree(1);
		edt.placerCours(cours);
		assertEquals(1, edt.getDisponibilites().size());
	}
	

}
