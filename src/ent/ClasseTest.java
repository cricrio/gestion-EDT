package ent;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClasseTest {
	int h = 3;
	int j = 2;
	int h1 = 1;
	int j1 = 1;
	Matiere m1 = new Matiere("français",1);
	Professeur p1 = new Professeur();
	Classe cls1 = new Classe();
	Classe cls2 = new Classe();
	
	@Before
	public void setUp() throws Exception {
		cls1.initilize(4, 4);
		cls2.initilize(4, 4);
		p1.initilize(4, 4);
		m1.setProfesseur(p1);
		}

	@Test
	public void testInitialize(){
		assertEquals(9, p1.edt.countCours());
		assertEquals(9, cls1.edt.countCours());
	}
	
	@Test
	public void testGetDisponibiliteMatiere() {
		cls1.addCours(j, h , m1);
		cls2.addCours(j1,h1,m1);
		int s = cls1.edt.countCours();
		assertEquals(s-2,cls1.getDisponibilite(m1).size());
	}
	
	@Test
	public void testGetDisponibiliteClasse() {
		int s = cls1.edt.countCours();
		cls1.addCours(j,h,m1);
		assertEquals(s-1,cls1.getDisponibilite().size());
	}
	@Test
	public void testGetDisponibiliteProfesseur() {
		int s = cls1.edt.countCours();
		cls1.addCours(j,h,m1);
		assertEquals(s-1,m1.getProfesseur().getDisponibilite().size());
	}

	@Test
	public void testAddCours() {
		cls1.addCours(j,h,m1);
		assertEquals(cls1.getCours(j, h).getProf(),p1);
	}

}
