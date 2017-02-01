package fournisseur;

import java.util.ArrayList;

import models.Classe;
import models.Niveau;
import models.Professeur;
import models.Salle;

public class FournisseurData implements FournisseurInterface {

	int nbJour;
	int nbHeure;

	private ArrayList<Niveau> niveaux;
	private ArrayList<Classe> classes;
	private ArrayList<Professeur> professeurs;
	private ArrayList<Salle> salles;

	public FournisseurData(int nbJour, int nbHeure) {
		this.nbJour = nbJour;
		this.nbHeure = nbHeure;
	}

	public void addNiveau(Niveau niveau) {
		niveaux.add(niveau);
	}

	public void addProfesseur(Professeur professeur) {
		professeurs.add(professeur);
	}

	public void addSalle(Salle salle) {
		salles.add(salle);
	}

	public void addClasse(Classe classe) {
		classes.add(classe);
	}

	@Override
	public ArrayList<Classe> getClasses() {
		return classes;
	}

	@Override
	public ArrayList<Professeur> getProfesseur() {
		return professeurs;
	}

	@Override
	public ArrayList<Salle> getSalles() {
		return salles;
	}

	public ArrayList<Niveau> getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(ArrayList<Niveau> niveaux) {
		this.niveaux = niveaux;
	}

}
