package models;

public class Matiere {
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

	private String intitule;
	private int nbHeure;
	private Professeur professeur;

	public Matiere(String nom, int nb) {
		setIntitule(nom);
		setNbHeure(nb);
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public void decremanter() {
		System.out.println(getNbHeure());
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

}
