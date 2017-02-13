package models;

public class Professeur extends SuperClass {
	private String matiereEnseigne;
	
	public Professeur(){
		
	};
	public Professeur(String nom) {
		this.nom = nom;
	}
	public Professeur(String nom,String matiereEnseigne) {
		this.nom = nom;
		setMatiereEnseigne(matiereEnseigne);
	}
	public String getMatiereEnseigne() {
		return matiereEnseigne;
	}
	public void setMatiereEnseigne(String matiereEnseigne) {
		this.matiereEnseigne = matiereEnseigne;
	}
}
