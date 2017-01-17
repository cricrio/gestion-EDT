package ent;

public class Cours {
	private int jourDebut;
	private int heureDebut;
	private int duree;
	private SuperClass prof;
	private SuperClass classe;
	private SuperClass salle;
	
	public Cours() {
		
	}
	
	public Cours(int j, int h,int d) {
		jourDebut = j;
		heureDebut = h;
		duree = d;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getHeureDebut();
		result = prime * result + getJour();
		return result;
	}
	@Override
	public String toString() {
		return "Cours [jour=" + jourDebut + ", heure=" + heureDebut + ", prof=" + prof + ", classe=" + classe + ", salle=" + salle
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cours other = (Cours) obj;
		if (getHeureDebut() != other.getHeureDebut())
			return false;
		if (getJour() != other.getJour())
			return false;
		return true;
	}
	public int getJour() {
		return jourDebut;
	}
	public void setJour(int jour) {
		this.jourDebut = jour;
	}
	public int getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(int heure) {
		this.heureDebut = heure;
	}
	public int getHeureFin() {
		return heureDebut + duree;
	}
	public SuperClass getProf() {
		return prof;
	}
	public void setProf(SuperClass prof) {
		this.prof = prof;
	}
	public SuperClass getClasse() {
		return classe;
	}
	public void setClasse(SuperClass classe) {
		this.classe = classe;
	}
	public SuperClass getSalle() {
		return salle;
	}
	public void setSalle(SuperClass salle) {
		this.salle = salle;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}
}
