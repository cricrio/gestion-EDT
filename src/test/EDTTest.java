package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.models.Cours;
import main.java.models.EDT;

public class EDTTest {
	EDT edt;
	int nbJours = 1;
	int nbHours = 6;

	@Before
	public void setUp() throws Exception {
		edt = new EDT();
		edt.initialize(nbJours, nbHours);
	}

	@Test
	public void testInitialize() {
		assertEquals(1, edt.getDisponibilites().size());
	}

	@Test
	public void testPlacerCoursMilieuDisponibilite() {
		Cours cours = new Cours();
		int jour = 0;
		int debut = 1;
		int duree = 1;
		cours.setJour(jour);
		cours.setHeureDebut(debut);
		cours.setDuree(duree);
		edt.placerCours(cours);
		assertEquals(2, edt.getDisponibilites().size());
		//avant
		assertEquals(0,edt.getDisponibilites().get(0).getHeureDebut());
		assertEquals(debut, edt.getDisponibilites().get(0).getHeureFin());
		//apres
		assertEquals(debut+duree,edt.getDisponibilites().get(1).getHeureDebut());
		assertEquals(nbHours-1, edt.getDisponibilites().get(1).getHeureFin());
		
	}

	@Test
	public void testPlacerCoursFinDisponibilite() {
		Cours cours = new Cours();
		int jour = 0;
		int debut = nbHours-1;
		int duree = 1;
		cours.setJour(jour);
		cours.setHeureDebut(debut);
		cours.setDuree(duree);
		edt.placerCours(cours);
		assertEquals(1, edt.getDisponibilites().size());
		assertEquals(0,edt.getDisponibilites().get(0).getHeureDebut());
		assertEquals(debut, edt.getDisponibilites().get(0).getHeureFin());
	}

	@Test
	public void testPlacerCoursDebutDisponibilite() {
		Cours cours = new Cours();
		cours.setJour(0);
		cours.setHeureDebut(0);
		cours.setDuree(1);
		edt.placerCours(cours);
		assertEquals(1, edt.getDisponibilites().size());
	}
	@Test
	public void testCheckIntegriteDonneIncorrect(){
		Cours cours = new Cours();
		cours.setJour(0);
		cours.setHeureDebut(0);
		cours.setDuree(1);
		Cours cours1 = new Cours();
		cours1.setJour(0);
		cours1.setHeureDebut(0);
		cours1.setDuree(1);
		edt.getCoursList().add(cours1);
		edt.getCoursList().add(cours);
		assertEquals(false, edt.checkIntegrite());
	}
	@Test
	public void testCheckIntegriteDonneCorrect(){
		Cours cours = new Cours();
		cours.setJour(0);
		cours.setHeureDebut(0);
		cours.setDuree(1);
		Cours cours1 = new Cours();
		cours1.setJour(4);
		cours1.setHeureDebut(0);
		cours1.setDuree(1);
		edt.getCoursList().add(cours1);
		edt.getCoursList().add(cours);
		assertEquals(true, edt.checkIntegrite());
	}
}
