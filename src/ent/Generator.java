package ent;

import java.util.ArrayList;

public class Generator {
	private ArrayList<Classe> classes = new ArrayList<Classe>();
	private ArrayList<Salle> salles = new ArrayList<Salle>();
	private ArrayList<Professeur> professeurs = new ArrayList<Professeur>();

	public void initialize(int nbJours, int nbHeures) throws Exception {
		Professeur profFrancais = new Professeur("franceP");
		Professeur profMath = new Professeur("mathP");
		Professeur profAnglais = new Professeur("angilasP");

		getProfesseurs().add(profFrancais);
		getProfesseurs().add(profAnglais);
		getProfesseurs().add(profMath);

		getClasses().add(new Classe("classe1"));
		getClasses().add(new Classe("classe2"));
		getClasses().add(new Classe("classe3"));

		getSalles().add(new Salle("IO1"));
		// getSalles().add(new Salle("IO2"));
		// getSalles().add(new Salle("IO3"));

		getClasses().get(0).setSalles(getSalles());
		Matiere francais = new Matiere("francais", 3);
		Matiere math = new Matiere("math", 3);
		Matiere anglais = new Matiere("anglais", 3);

		francais.setProfesseur(profFrancais);
		anglais.setProfesseur(profAnglais);
		math.setProfesseur(profMath);

		for (Classe classe : getClasses()) {
			classe.initialize(nbJours, nbHeures, getClasses().size());
			classe.ajouterMatiere(math);
			classe.ajouterMatiere(anglais);
			classe.ajouterMatiere(francais);
		}
		for (Professeur professeur : getProfesseurs()) {
			professeur.initialize(nbJours, nbHeures);
		}
		for (Salle salle : getSalles()) {
			salle.initialize(nbJours, nbHeures);
		}
	}

	private boolean isFinish() {
		return getClasses().get(0).nbClasse == 0;
	}

	public void placerCours() throws Exception {
		int i = 0;
		while (!isFinish()) {
			for (Classe classe : getClasses()) {
				if (!classe.toutLesCoursPlacer()) {
					classe.placerRandomCours();
				}
			}
		}
		for (Classe classe : getClasses()) {
			System.out.println(classe.getAllCours());
		}
	}

	public ArrayList<Classe> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<Classe> classes) {
		this.classes = classes;
	}

	public ArrayList<Salle> getSalles() {
		return salles;
	}

	public void setSalles(ArrayList<Salle> salles) {
		this.salles = salles;
	}

	public ArrayList<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(ArrayList<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

}
