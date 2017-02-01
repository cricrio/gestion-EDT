package models;

import java.util.ArrayList;
import java.util.HashMap;

import exception.AucuneSalleLibreException;

public class Classe extends SuperClass {
	private ArrayList<Matiere> matieresAPlacer = new ArrayList<Matiere>();
	public static ArrayList<Salle> salles;
	public static int nbClasse;

	public Classe(String nom) {
		this.nom = nom;
	}

	public Classe(String nom, Niveau niveau) {
		this.nom = nom;
	}

	public void initialize(int nbj, int nbh, int nbClasse) throws Exception {
		this.nbClasse = nbClasse;
		initialize(nbj, nbh);
	}

	public void ajouterMatiere(Matiere matiere) {
		// effectuer une copie de la matiere pour quel ne sois pas partager
		// entre les différentes places
		Matiere m = new Matiere(matiere.getIntitule(), matiere.getNbHeure());
		m.setProfesseur(matiere.getProfesseur());
		matieresAPlacer.add(m);
	}

	private Matiere getRandomMatiere() {
		int index = (int) (Math.random() * matieresAPlacer.size());
		return matieresAPlacer.get(index);
	}

	public void placerRandomCours() throws Exception {
		Matiere matiere = getRandomMatiere();
		Cours cours = getCours(matiere);
		placerCoursInAll(cours, matiere);
	}

	private Cours getCours(Matiere matiere) throws Exception {
		boolean notFound = true;
		int duree = 1;
		int index = 0;
		ArrayList<Disponibilite> disponibilites = getDisponibilite(matiere);
		SalleAndDispo salleAndDispo = findSalleLibre(disponibilites, duree);
		Cours cours = new Cours(salleAndDispo.dispos.getJour(), salleAndDispo.dispos.getHeureDebut(), duree);
		cours.setSalle(salleAndDispo.salle);
		return cours;
	}

	public boolean toutLesCoursPlacer() {
		System.out.println(nom + " matieres à placer :" + matieresAPlacer.size());
		return matieresAPlacer.isEmpty();
	}

	public ArrayList<Disponibilite> getDisponibilite(Matiere matiere) throws Exception {
		ArrayList<Disponibilite> disponibiliteProf = matiere.getProfesseur().getDisponibilite();
		return super.getSharedDisponibilite(disponibiliteProf);
	}

	public void placerCoursInAll(Cours cours, Matiere matiere) {
		cours.setProf(matiere.getProfesseur());
		cours.setClasse(this);
		cours.getSalle().placerCours(cours);
		placerCours(cours);
		matiere.getProfesseur().placerCours(cours);
		matiere.decremanter();
		if (matiere.toutLesCoursPlacer()) {
			matieresAPlacer.remove(matiere);
			if (matieresAPlacer.isEmpty()) {
				nbClasse--;
			}
		}
	}

	public void placerCours(int j, int h, Matiere matiere) {
		this.getCours(j, h).setProf(matiere.getProfesseur());
		matiere.getProfesseur().getCours(j, h).setClasse(this);
		matiere.decremanter();
		if (matiere.toutLesCoursPlacer()) {
			matieresAPlacer.remove(matiere);
		}

	}

	public SalleAndDispo findSalleLibre(ArrayList<Disponibilite> dispoClasseProf, int duree)
			throws AucuneSalleLibreException {
		for (Salle salle : salles) {
			try {
				ArrayList<Disponibilite> dispoSalle = salle.getSharedDisponibilite(dispoClasseProf);
				for (Disponibilite dispo : dispoSalle) {
					if (dispo.getDuree() >= duree) {
						return new SalleAndDispo(salle, dispo);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
		throw new AucuneSalleLibreException();
	}

	public static void setSalles(ArrayList<Salle> s) {
		salles = s;
	}

	/**
	 * Attribut un prof à toute les matieres ayant un intitule identique à celle
	 * passé en paramètre
	 * 
	 * @param prof
	 * @param matiere
	 */
	public void attribuerProfesseurAUneMatiere(Professeur prof, Matiere matiere) {
		for (Matiere m : matieresAPlacer) {
			if (m.equals(matiere)) {
				m.setProfesseur(prof);
			}
		}
	}
}
