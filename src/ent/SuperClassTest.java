package ent;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SuperClassTest {
	SuperClass prof;
	SuperClass salle;
	SuperClass classe;
	Cours cours;
	@Before
	public void setUp() throws Exception {
		prof = new SuperClass();
		salle = new SuperClass();
		classe = new SuperClass();
		cours = new Cours();
		cours.setClasse(classe);
		cours.setHeure(0);
		cours.setJour(1);
		cours.setProf(prof);
		cours.setSalle(salle);
		classe.ajouterCours(cours);
	}

	@Test
	public void test() {
		cours = new Cours();
		cours.setClasse(classe);
		cours.setHeure(0);
		cours.setJour(1);
		cours.setProf(prof);
		cours.setSalle(salle);
		classe.ajouterCours(cours);
		
		assertEquals(false,classe.checkDispo(cours));
		assertEquals(false,prof.checkDispo(cours));
	}

}
