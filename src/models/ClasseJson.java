package models;

import java.util.ArrayList;

public class ClasseJson {
	private String intitule;
	private int niveau;
	private int id;
	private ArrayList<MatiereJSON> matieres;
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<MatiereJSON> getMatieres() {
		return matieres;
	}
	public void setMatieres(ArrayList<MatiereJSON> matieres) {
		this.matieres = matieres;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
}
