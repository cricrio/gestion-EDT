package executeur;

import java.util.ArrayList;

import ent.GeneratorEDTs;
import importExport.ExportData;
import importExport.ImportData;
import models.Classe;
import models.Professeur;
import models.Salle;

public class Main {
	private ArrayList<Classe> classes;
	private ArrayList<Salle> salles; 
	private ArrayList<Professeur> professeurs; 

	public void  importData() {
		ImportData importData = new ImportData("config");

		setClasses(importData.getClasses());
		setProfesseurs(importData.getProfesseurs());
		setSalles(importData.getSalles());
	}

	/**
	 * @return false s'il y a plusieurs cours à la même heure
	 */
	public boolean checkIntegrite() {
		for(Classe classe : classes) {
			if(classe.checkIntegrite() == false ) {
				return false;
			}
		}
		return true;
	}
	public void exportData() {
		ExportData exportData = new ExportData("exports/");
		exportData.exportClasses(classes);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		GeneratorEDTs generator = new GeneratorEDTs();
		main.importData();
		generator.setProfesseurs(main.getProfesseurs());
		generator.setClasses(main.getClasses());
		generator.setSalles(main.getSalles());
		try {
			generator.genererEmploiDuTemps();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		main.exportData();
	}

	public ArrayList<Classe> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<Classe> classes) {
		this.classes = classes;
	}

	public ArrayList<Salle> getSalles() {
		return salles;
	}

	public void setSalles(ArrayList<Salle> salles) {
		this.salles = salles;
	}

	public ArrayList<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(ArrayList<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

}
