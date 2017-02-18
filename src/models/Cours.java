package models;

public class Cours {
	private int jourDebut;
	private int heureDebut;
	private int duree;
	private Matiere matiere;
	private Professeur prof;
	private Classe classe;
	private Salle salle;
	
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
		return "Cours [jour=" + jourDebut + ", heure=" + heureDebut + ", prof=" + getProf() + ", classe=" + getClasse() + ", salle=" + getSalle()
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

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Professeur getProf() {
		return prof;
	}

	public void setProf(Professeur prof) {
		this.prof = prof;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
}
