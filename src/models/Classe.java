package models;

import java.util.ArrayList;

import exception.AucuneSalleLibreException;
import exception.DispoNonCommuneExeption;

public class Classe extends SuperClass {
	private ArrayList<Matiere> matieresAPlacer = new ArrayList<Matiere>();
	private Niveau niveau;

	public Classe(String nom) {
		this.nom = nom;
	}

	public Classe(String nom, Niveau niveau) {
		this.nom = nom;
		this.setNiveau(niveau); 
		setMatieresAPlacer(niveau.getMatieres());
	}
		
	public void ajouterMatiere(Matiere matiere) {
		// effectuer une copie de la matiere pour quel ne sois pas partager
		// entre les différentes places
		Matiere m = new Matiere(matiere.getIntitule(), matiere.getNbHeure());
		m.setProfesseur(matiere.getProfesseur());
		getMatieresAPlacer().add(m);
	}

	public Matiere getRandomMatiere() {
		int index = (int) (Math.random() * getMatieresAPlacer().size());
		return getMatieresAPlacer().get(index);
	}


	public boolean toutLesCoursPlacer() {
		return getMatieresAPlacer().isEmpty();
	}

	/**
	 * @param matiere
	 * @return les diponibilitées communes du profeseur attribué à la matière et de la classe
	 * @throws DispoNonCommuneExeption 
	 */
	public ArrayList<Disponibilite> getDisponibilite(Matiere matiere) throws DispoNonCommuneExeption  {
		ArrayList<Disponibilite> disponibiliteProf = matiere.getProfesseur().getDisponibilite();
		return super.getSharedDisponibilite(disponibiliteProf);
	}

	@Override
	public void placerCours(Cours cours) {
		super.placerCours(cours);
		Matiere matiere = cours.getMatiere();
		matiere.decremanter();
		if (matiere.toutLesCoursPlacer()) {
			getMatieresAPlacer().remove(matiere);			
		}
	}


	public ArrayList<Matiere> getMatieresAPlacer() {
		return matieresAPlacer;
	}

	public void setMatieresAPlacer(ArrayList<Matiere> matieresAPlacer) {
		this.matieresAPlacer = matieresAPlacer;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
}
