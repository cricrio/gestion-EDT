package ent;

import java.util.ArrayList;

public class Generator {
	ArrayList<Classe> classes = new ArrayList<Classe>();
	ArrayList<Salle> salles = new ArrayList<Salle>();
	ArrayList<Professeur> professeurs = new ArrayList<Professeur>();

	public void initialize(int nbJours, int nbHeures) throws Exception {
		Professeur profFrancais = new Professeur("franceP");
		Professeur profMath = new Professeur("mathP");
		Professeur profAnglais = new Professeur("angilasP");

		professeurs.add(profFrancais);
		professeurs.add(profAnglais);
		professeurs.add(profMath);

		classes.add(new Classe("classe1"));
		classes.add(new Classe("classe2"));
		classes.add(new Classe("classe3"));

		Matiere francais = new Matiere("francais", 3);
		Matiere math = new Matiere("math", 3);
		Matiere anglais = new Matiere("anglais", 3);

		francais.setProfesseur(profFrancais);
		anglais.setProfesseur(profAnglais);
		math.setProfesseur(profMath);

		for (Classe classe : classes) {
			classe.initialize(nbJours, nbHeures, classes.size());
			classe.ajouterMatiere(math);
			classe.ajouterMatiere(anglais);
			classe.ajouterMatiere(francais);
		}
		for (Professeur professeur : professeurs) {
			professeur.initialize(nbJours, nbHeures);
		}
	}

	private boolean isFinish() {
		return classes.get(0).nbClasse == 0;
	}

	public void placerCours() throws Exception {
		int i = 0;
		while (!isFinish()) {
			for (Classe classe : classes) {
				if (!classe.toutLesCoursPlacer()) {
					System.out.println(i++);
					classe.placerRandomCours();
				}
			}
		}
		for(Classe classe : classes){
			System.out.println(classe.getAllCours());
		}
	}
	
	
	
	
	public boolean deuxCoursMemeEntiteMemeHeure(){
		for(Professeur professeur : professeurs){
			for(Cours coursP : professeur.getAllCours()){
				for(Classe classe : classes){
					if(!classe.equals(coursP.getClasse())){
						if(classe.getAllCours().contains(coursP)){
							return true;
						}
					}
				}
			}
		}
		for(Classe classe : classes){
			for(Cours coursC : classe.getAllCours()){
				for(Professeur professeur : professeurs){
					if(!professeur.equals(coursC.getClasse())){
						if(classe.getAllCours().contains(coursC)){
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
