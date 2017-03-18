package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.ent.GeneratorEDTs;
import main.java.executeur.MainDump;
import main.java.models.Classe;
import main.java.models.Professeur;
import main.java.models.Salle;

public class GeneratorTest {
	GeneratorEDTs generator;
	@Before
	public void setUp() throws Exception {
		 generator = new GeneratorEDTs();
		try {
			MainDump ms = new MainDump();
			ms.initialize(5, 10);
			generator.genererEmploiDuTemps();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("work done !");
	}
	

	@Test
	public void integriteProfesseurs() {
		for(Professeur p : generator.getProfesseurs()){
			assertEquals(true, p.checkIntegrite());
		}
	}
	@Test
	public void integriteClasses() {
		for(Classe c : generator.getClasses()){
			
			assertEquals(true, c.checkIntegrite());
		}
	}
	@Test
	public void integriteSalles() {
		for(Salle s : generator.getSalles()){
			
			assertEquals(true, s.checkIntegrite());
		}
	}
	
	

}
