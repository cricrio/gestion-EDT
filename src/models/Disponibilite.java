package models;

import exception.DispoNonCommuneExeption;
import exception.DispoPasMemeJourException;

public class Disponibilite {
	private int heureDebut;

	private int heureFin;
	private int jour;

	public Disponibilite getShareDiponibilte(Disponibilite source) throws DispoNonCommuneExeption,DispoPasMemeJourException {
		Disponibilite result = new Disponibilite();
		if (source.getJour() != getJour()) {
			throw new DispoPasMemeJourException();
		} else if (source.getHeureFin() < getHeureDebut() || source.getHeureDebut() > getHeureFin()) {
			throw new DispoNonCommuneExeption();
		}
		int heureDebut = source.getHeureDebut() > getHeureDebut() ? source.getHeureDebut() : getHeureDebut();
		int heureFin = source.getHeureFin() < getHeureFin() ? source.getHeureFin() : getHeureFin();
		result.setHeureDebut(heureDebut);
		result.setHeureFin(heureFin);
		result.setJour(source.getJour());
		return result;
	}

	public boolean containsCours(Cours cours) {
		return getJour() == cours.getJour() && cours.getHeureDebut() >= getHeureDebut() && cours.getHeureDebut() <= getHeureFin();
	}
	public void avancer(int duree){
		heureDebut =+ duree;
	}
	public void diminuer(int duree){
		heureFin = heureFin - duree;
	}
	public int getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(int heureDebut) {
		this.heureDebut = heureDebut;
	}

	public int getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(int heureFin) {
		this.heureFin = heureFin;
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getDuree() {
		return getHeureFin() - getHeureDebut();
	}
}
