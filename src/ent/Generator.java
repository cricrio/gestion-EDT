package ent;

import java.util.ArrayList;

public class Generator {
	ArrayList<Classe> classes = new ArrayList<Classe>();
	ArrayList<Salle> salles = new ArrayList<Salle>();
	ArrayList<Professeur> professeurs = new ArrayList<Professeur>();
	
	public void initialize(int nbJours,int nbHeures ) throws Exception{
		Professeur profFrancais = new Professeur();
		Professeur profMath = new Professeur();
		Professeur profAnglais = new Professeur();
		
		professeurs.add(profFrancais);
		professeurs.add(profAnglais);
		professeurs.add(profMath);
		
		classes.add(new Classe());
		classes.add(new Classe());
		classes.add(new Classe());

		
		Matiere francais = new Matiere("francais", 3);
		Matiere math = new Matiere("math", 3);
		Matiere anglais = new Matiere("anglais", 3);
		
		francais.setProfesseur(profFrancais);
		anglais.setProfesseur(profAnglais);
		math.setProfesseur(profMath);
		
		for(Classe classe : classes){
			classe.initialize(nbJours, nbHeures,classes.size());
			classe.ajouterMatiere(math);
			classe.ajouterMatiere(anglais);
			classe.ajouterMatiere(francais);
		}
		for(Professeur professeur : professeurs){
			professeur.initialize(nbJours, nbHeures);
		}
	}
	private boolean finish(){
		//System.out.println("FINISH :: "+ classes.get(0).nbClasse);
		return classes.get(0).nbClasse == 0;
	}
	public void placerCours(){
		while(! finish()){
		for(Classe classe : classes){
			if(! classe.toutLesCoursPlacer()){
				classe.placerRandomCours();
			}
		}
		}
	}
	
	
}
