package models;

import java.util.ArrayList;

public class ClasseJson {
	private String intitule;
	private int niveau;
	@Override
	public String toString() {
		return "ClasseJson [intitule=" + intitule + ", niveau=" + niveau + ", id=" + id + ", matieres=" + matieres
				+ "]";
	}
	private int id;
	private ArrayList<MatiereJSON> matieres;
	private ArrayList<CoursJSON> edt;
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
	public ArrayList<CoursJSON> getEdt() {
		return edt;
	}
	public void setEdt(ArrayList<CoursJSON> edt) {
		this.edt = edt;
	}
	
}
