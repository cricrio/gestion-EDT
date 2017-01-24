package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ent.Classe;
import ent.Generator;
import ent.Professeur;

public class GeneratorTest {
	Generator generator;
	@Before
	public void setUp() throws Exception {
		 generator = new Generator();
		try {
			generator.initialize(8, 5);
			generator.placerCours();
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
	
	

}
