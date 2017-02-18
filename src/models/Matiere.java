package models;

import java.util.concurrent.atomic.AtomicInteger;

public class Matiere {

	private static final AtomicInteger COUNTER = new AtomicInteger();
	private final int id;
	private String intitule;
	private int nbHeure;
	private int duree;
	private Professeur professeur;

	public Matiere(String nom, int nbHeure, int duree,int id) {
		this.id= id;
		setIntitule(nom);
		setNbHeure(nbHeure);
		setDuree(duree);
	}
	public Matiere(String nom, int nbHeure) {
		this.id= COUNTER.incrementAndGet();
		setIntitule(nom);
		setNbHeure(nbHeure);

	}
	public Matiere(String nom, int nbHeure, int duree) {
		this.id= COUNTER.incrementAndGet();
		setIntitule(nom);
		setNbHeure(nbHeure);
		setDuree(duree);
	}
	
	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public void decremanter() {
		setNbHeure(getNbHeure() - 1);
	}

	public boolean toutLesCoursPlacer() {
		return (getNbHeure() <= 0);
	}

	@Override
	public String toString() {
		return "Matiere [intitule=" + getIntitule() + ", nbAPlacer=" + getNbHeure() + ", professeur=" + professeur
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((intitule == null) ? 0 : intitule.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matiere other = (Matiere) obj;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		return true;
	}

	public int getNbHeure() {
		return nbHeure;
	}

	public void setNbHeure(int nbHeure) {
		this.nbHeure = nbHeure;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getId() {
		return id;
	}

}
