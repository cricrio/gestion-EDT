package main.java.executeur;

import java.util.ArrayList;

import main.java.ent.GeneratorEDTs;
import main.java.importExport.ExportData;
import main.java.importExport.ImportData;
import main.java.models.Classe;
import main.java.models.Professeur;
import main.java.models.Salle;

public class Main {
	private ArrayList<Classe> classes;
	private ArrayList<Salle> salles; 
	private ArrayList<Professeur> professeurs; 

	public void  importData(String path) {
		ImportData importData = new ImportData(path);

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
	public void exportData(String path) {
		ExportData exportData = new ExportData(path);
		exportData.exportClasses(classes);
		exportData.exportProfs(professeurs);
		exportData.exportSalles(salles);
	}
	
	public static void main(String[] args) {
		String importPath = "config";
		String exportPath = "export";
		
		if(args.length == 2){
			
			importPath = args[0] +"/";
			exportPath = args[1]+ "/";
		}else{
			System.out.println("working with default");
		}
		
		
		Main main = new Main();
		GeneratorEDTs generator = new GeneratorEDTs();
		main.importData(importPath);
		generator.setProfesseurs(main.getProfesseurs());
		generator.setClasses(main.getClasses());
		generator.setSalles(main.getSalles());
		try {
			generator.genererEmploiDuTemps();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		main.exportData(exportPath);
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
