package ent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class EDT {
	
	ArrayList<Cours> coursList;
	private static int nbJours = 0;
	private static int nbHeures = 0;
	
	public EDT() {

	}
	public void initialize() throws Exception{
		if(nbHeures==0 || nbJours == 0){
			throw new Exception("nbHeures or nbJours not set");
		}
		coursList = new ArrayList<Cours>();
		for(int j = 0; j< nbJours; j++){
			for(int h = 0; h < nbHeures ;h++){
				coursList.add(new Cours(j,h));
			}
		}
	}
	
	public ArrayList<Cours> getCrenauxLibre(){
		return (ArrayList<Cours>) coursList.stream().filter(c ->
			c.getProf() == null 
			&& c.getClasse() == null
			&& c.getSalle() ==null
			).collect(Collectors.toList());
	}
	
	
	public static int getNbHeures() {
		return nbHeures;
	}

	public static void setNbHeures(int nbHeures) {
		EDT.nbHeures = nbHeures;
	}

	public static int getNbJours() {
		return nbJours;
	}

	public static void setNbJours(int nbJours) {
		EDT.nbJours = nbJours;
	}

}
