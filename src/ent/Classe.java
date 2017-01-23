package ent;

import java.util.ArrayList;
import java.util.HashMap;

public class Classe extends SuperClass {
	private ArrayList<Matiere> matieresAPlacer = new ArrayList<Matiere>();
	public static int nbClasse;
	
	public Classe(String nom){
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
		ArrayList<Disponibilite> disponibilites = getDisponibilite(matiere);
		Disponibilite disponibilite;
		Cours cours = null;
		boolean notFound= true;
		int duree = 1;
		int index = 0;
		do {
			disponibilite = disponibilites.get(index);
			if (disponibilite.getDuree() >= duree) {
				cours = new Cours(disponibilite.getJour(), disponibilite.getHeureDebut(), duree);
				notFound = false;
			}
			index++;
		} while (notFound || index < disponibilites.size());
		if (cours == null) {
			throw new Exception("pas de disponilité de taille suffisante");
		} else {
			System.out.println(cours);
			return cours;
		}
	}

	public boolean toutLesCoursPlacer() {
		System.out.println("matieres à placer :" + matieresAPlacer.isEmpty());
		return matieresAPlacer.isEmpty();
	}

	
	
	public ArrayList<Disponibilite> getDisponibilite(Matiere matiere) throws Exception {
		ArrayList<Disponibilite> disponibiliteProf = matiere.getProfesseur().getDisponibilite();
		ArrayList<Disponibilite> disponibiliteBoth = new ArrayList<Disponibilite>();

		for (Disponibilite disponibiliteP : disponibiliteProf) {
			for (Disponibilite disponibiliteC : getDisponibilite()) {
				try {
					disponibiliteBoth.add(disponibiliteC.getShareDiponibilte(disponibiliteP));
				} catch (Exception e) {
//				e.printStackTrace();
				}
			}
		}
		if (disponibiliteBoth.isEmpty()) {
			throw new Exception("Pas de disponibilite commune");
		}
		return disponibiliteBoth;
	}

	
	public void placerCoursInAll(Cours cours, Matiere matiere) {
		cours.setProf(matiere.getProfesseur());
		cours.setClasse(this);
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

}
