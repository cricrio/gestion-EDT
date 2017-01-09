package ent;

public class Cours {
	private int jour;
	private int heure;
	private SuperClass prof;
	private SuperClass classe;
	private SuperClass salle;
	
	public Cours() {
		
	}
	
	public Cours(int j, int h) {
		jour = j;
		heure =h;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getHeure();
		result = prime * result + getJour();
		return result;
	}
	@Override
	public String toString() {
		return "Cours [jour=" + jour + ", heure=" + heure + ", prof=" + prof + ", classe=" + classe + ", salle=" + salle
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
		if (getHeure() != other.getHeure())
			return false;
		if (getJour() != other.getJour())
			return false;
		return true;
	}
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
	}
	public int getHeure() {
		return heure;
	}
	public void setHeure(int heure) {
		this.heure = heure;
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
}
