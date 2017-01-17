package ent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class EDT {
	private ArrayList<Disponibilite> disponibilites = new ArrayList<Disponibilite>();
	ArrayList<Cours> coursList;
	private static int nbJours = 0;
	private static int nbHeures = 0;

	public EDT() {

	}

	public void initialize(int nbJours, int nbHeures) {
		setNbJours(nbJours);
		setNbHeures(nbHeures);

		Disponibilite disponibilite;
		for (int i = 0; i < nbJours; i++) {
			// création des plages dispo
			disponibilite = new Disponibilite();
			disponibilite.setJour(i);
			disponibilite.setHeureDebut(0);
			disponibilite.setHeureFin(getNbHeures());
			// insertion
			getDisponibilites().add(disponibilite);
		}

	}

	private Disponibilite getDisponibilite(Cours cours) throws Exception {
		for (Disponibilite disponibilite : disponibilites) {
			if (disponibilite.containsCours(cours)) {
				return disponibilite;
			}
		}
		throw new Exception("Non inclus");
	}

	public void changeDisponibilite(Cours cours) {
		try {
			Disponibilite disponibilite = getDisponibilite(cours);
			if (disponibilite.getHeureDebut() == cours.getHeureDebut()) {
				disponibilite.avancer(cours.getDuree());
			} else if (disponibilite.getHeureFin() == cours.getHeureDebut()) {
				disponibilite.diminuer(cours.getDuree());
			} else {
				Disponibilite d1 = new Disponibilite();
				d1.setHeureDebut(disponibilite.getHeureDebut());
				d1.setHeureFin(cours.getHeureDebut());
				d1.setJour(disponibilite.getJour());

				Disponibilite d2 = new Disponibilite();
				d2.setHeureDebut(cours.getHeureFin());
				d2.setHeureFin(disponibilite.getHeureFin());
				d2.setJour(disponibilite.getJour());
				disponibilites.remove(disponibilite);
				disponibilites.add(d1);
				disponibilites.add(d2);

			}
		} catch (Exception e) {
			//e.printStackTrace();
		}

	}

	public void placerCours(Cours cours) {
		coursList.add(cours);
		changeDisponibilite(cours);
	}

	public Cours getCours(int j, int h) {
		return coursList.get(coursList.indexOf(new Cours(j, h, 1)));
	}

	public Cours getCours(Cours c) {
		return coursList.get(coursList.indexOf(c));
	}

	public int countCours() {
		return coursList.size();
	}

	public static int getNbHeures() {
		return nbHeures;
	}

	public static void setNbHeures(int nbHeures) {
		EDT.nbHeures = nbHeures;
	}

	public static int getNbJours() {
		return nbJours;
	}

	public static void setNbJours(int nbJours) {
		EDT.nbJours = nbJours;
	}

	public ArrayList<Disponibilite> getDisponibilites() {
		return disponibilites;
	}

	public void setDisponibilites(ArrayList<Disponibilite> disponibilites) {
		this.disponibilites = disponibilites;
	}

}
