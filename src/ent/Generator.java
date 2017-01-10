package ent;

import java.util.ArrayList;

public class Generator {
	ArrayList<Classe> classes;
	ArrayList<Salle> salles;
	ArrayList<Professeur> professeur;
	
	public void initialize(int nbJours,int nbHeures ){
		Professeur profFrancais = new Professeur();
		Professeur profMath = new Professeur();
		Professeur profAnglais = new Professeur();
		
		Classe classe1 = new Classe();
		Classe classe2 = new Classe();
		Classe classe3 = new Classe();
		
		Matiere francais = new Matiere("francais", 3);
		Matiere math = new Matiere("math", 3);
		Matiere anglais = new Matiere("anglais", 3);
		
		francais.setProfesseur(profFrancais);
		anglais.setProfesseur(profAnglais);
		math.setProfesseur(profMath);
		
		
		 
	}
	
}
