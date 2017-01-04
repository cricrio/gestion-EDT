package ent;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SuperClassTest {
	SuperClass prof;
	SuperClass salle;
	SuperClass classe;
	
	@Before
	public void setUp() throws Exception {
		prof = new SuperClass();
		salle = new SuperClass();
		classe = new SuperClass();
		Cours cours = new Cours();
		cours.setClasse(classe);
		cours.setHeure(0);
		cours.setJour(1);
		cours.setProf(prof);
		cours.setSalle(salle);
		classe.addCoursInAllIntervenants(cours);
	}
	@Test
	public void insertCoursTwiceTest(){
		Cours cours = new Cours();
		cours.setClasse(classe);
		cours.setHeure(0);
		cours.setJour(1);
		cours.setProf(prof);
		cours.setSalle(salle);
		assertEquals(false, salle.addCoursInAllIntervenants(cours));
		
	}

	@Test
	public void findDiponibilityTest() {
		Cours cours = new Cours();
		cours.setClasse(classe);
		cours.setHeure(0);
		cours.setJour(1);
		cours.setProf(prof);
		cours.setSalle(salle);
		assertEquals(false,classe.checkDispo(cours));
		assertEquals(false,prof.checkDispo(cours));
	}
	

}
