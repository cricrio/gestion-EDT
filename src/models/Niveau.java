package models;

import java.util.ArrayList;

/**
 * Il s'agit de la représentation du niveau de la classe(terminal,première...).
 * Contient son intitulé et les matiere correspondant au niveaux
 * @author christo
 *
 */
public class Niveau {
	
	private String intitule;
	private ArrayList<Matiere> matieres;
	public Niveau(String intitule){
		this.intitule = intitule;
	}

}


