package ent;

import java.util.ArrayList;

import models.Classe;
import models.Matiere;
import models.Professeur;
import models.Salle;

/**
 * Réalise la génération de l'emploi du temps pour les classes, salles et professeurs fournis 
 *  @author christo
 *
 */
public class GeneratorEDTs {
	private ArrayList<Classe> classes = new ArrayList<Classe>();
	private ArrayList<Salle> salles = new ArrayList<Salle>();
	private ArrayList<Professeur> professeurs = new ArrayList<Professeur>();

	/**
	 * @return true quand le générateur à placer les cours de toutes les classes
	 */
	private boolean isFinish() {
		return getClasses().get(0).nbClasse == 0;
	}

	/**
	 * Place aléatoirement les cours pour chaque classes
	 * @throws Exception
	 */
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
