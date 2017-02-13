package models;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Il s'agit de la représentation du niveau de la classe(terminal,première...).
 * Contient son intitulé et les matiere correspondant au niveaux
 * @author christo
 *
 */
public class Niveau {
	private static final AtomicInteger COUNTER = new AtomicInteger();
	private final int id;
	private String intitule;
	private ArrayList<Matiere> matieres;
	
	public Niveau(String intitule,int id){
		this.id = id;
		this.setIntitule(intitule);
	}
	public Niveau(String intitule){
		this.id = COUNTER.incrementAndGet(); 
		this.setIntitule(intitule);
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public ArrayList<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(ArrayList<Matiere> matieres) {
		this.matieres = matieres;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Niveau [id=" + id + ", intitule=" + intitule + ", matieres=" + matieres + "]";
	}

}


