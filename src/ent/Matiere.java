package ent;

public class Matiere {
	private String intitule;
	private int nbAPlacer;
	private Professeur professeur;
	
	public Matiere(String nom, int nb) {
		intitule = nom;
		nbAPlacer = nb;
	}
	public Professeur getProfesseur() {
		return professeur;
	}
	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
	@Override
	public String toString() {
		return "Matiere [intitule=" + intitule + ", nbAPlacer=" + nbAPlacer + ", professeur=" + professeur + "]";
	}
	
}
