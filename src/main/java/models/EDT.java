package main.java.models;

import java.util.ArrayList;

import main.java.exception.DispoNonCommuneExeption;

public class EDT {
	private ArrayList<Disponibilite> disponibilites = new ArrayList<Disponibilite>();
	private ArrayList<Cours> coursList = new ArrayList<Cours>();
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
			disponibilite.setHeureFin(getNbHeures() - 1);
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
				disponibilite.setHeureDebut(cours.getHeureFin());
				;
			} else if (disponibilite.getHeureFin() == cours.getHeureDebut()) {
				disponibilite.setHeureFin(cours.getHeureDebut());
				;
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
			e.printStackTrace();
		}

	}

	public void placerCours(Cours cours) {
		getCoursList().add(cours);
		changeDisponibilite(cours);
	}

	public Cours getCours(int j, int h) {
		return getCoursList().get(getCoursList().indexOf(new Cours(j, h, 1)));
	}

	public Cours getCours(Cours c) {
		return getCoursList().get(getCoursList().indexOf(c));
	}

	public int countCours() {
		return getCoursList().size();
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

	public ArrayList<Disponibilite> getSharedDisponibilite(ArrayList<Disponibilite> dispoSource) throws DispoNonCommuneExeption {
		ArrayList<Disponibilite> disponibiliteBoth = new ArrayList<Disponibilite>();

		for (Disponibilite disponibiliteP : dispoSource) {
			for (Disponibilite disponibiliteC : disponibilites) {
				try {
					disponibiliteBoth.add(disponibiliteC.getShareDiponibilte(disponibiliteP));
				} catch (Exception e) {
					// e.printStackTrace();
				}
			}
		}
		if (disponibiliteBoth.isEmpty()) {
			throw new DispoNonCommuneExeption();
		}
		return disponibiliteBoth;
	}

	@Override
	public String toString() {
		String liste = "";
		for (Cours c : getCoursList()) {
			liste += c;
		}
		return liste;
	}

	/**
	 * @return false s'il y a plusieur cours à la même heure
	 */
	public boolean checkIntegrite() {
		int count = 0;
		for (Cours cours : getCoursList()) {
			count = 0;
			for (Cours cours1 : getCoursList()) {
				if (cours.equals(cours1)) {
					count++;
				}
				if (count > 1) {
					return false;
				}
			}
		}
		return true;
	}

	public ArrayList<Cours> getCoursList() {
		return coursList;
	}

	public void setCoursList(ArrayList<Cours> coursList) {
		this.coursList = coursList;
	}
}
