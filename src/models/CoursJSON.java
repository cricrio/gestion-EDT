package models;

public class CoursJSON {
	private int jourDebut;
	private int heureDebut;
	private int duree;
	private int idprof;
	private int idclasse;
	private int idsalle;

	public int getIdprof() {
		return idprof;
	}

	public void setIdprof(int idprof) {
		this.idprof = idprof;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(int heureDebut) {
		this.heureDebut = heureDebut;
	}

	public int getJourDebut() {
		return jourDebut;
	}

	public void setJourDebut(int jourDebut) {
		this.jourDebut = jourDebut;
	}

	public int getIdclasse() {
		return idclasse;
	}

	public void setIdclasse(int idclasse) {
		this.idclasse = idclasse;
	}

	public int getIdsalle() {
		return idsalle;
	}

	public void setIdsalle(int idsalle) {
		this.idsalle = idsalle;
	}
}
