package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ent.Generator;

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
	public void test() {
		assertEquals(false, generator.deuxCoursMemeEntiteMemeHeure());
	}

}
