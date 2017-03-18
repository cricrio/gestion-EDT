package main.java.importExport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import main.java.models.Classe;
import main.java.models.ClasseJson;
import main.java.models.Matiere;
import main.java.models.MatiereJSON;
import main.java.models.Niveau;
import main.java.models.Professeur;
import main.java.models.Salle;

public class ImportData {
	private Gson gson;
	private ArrayList<ClasseJson> classeJsons;
	private ArrayList<Classe> classes;
	private ArrayList<Salle> salles;
	private ArrayList<Niveau> niveaux;
	private ArrayList<Professeur> professeurs;
	private String folderpath;

	private int nbJours = 8;
	private int nbHeures = 5;

	public ImportData(String folderpath) {
		setFolderpath(folderpath);
		gson = new GsonBuilder().setPrettyPrinting().create();
		importNiveaux();
		importProfesseurs();
		importSalles();
		importClassesJson();
		setClasses();
		initializeData();
		showNombresImport();
	}

	private void showNombresImport() {
		System.out.println("Importation faite");
		System.out.println("classes ajoutées : " + classeJsons.size());
		System.out.println("professeurs ajoutés : " + professeurs.size());
		System.out.println("salles ajoutées : " + salles.size());
		System.out.println();

	}
	
	private void initializeData() {
		try {
			
			for (Classe classe : classes) {
				//
				classe.initialize(nbJours, nbHeures);
			}
			for (Professeur professeur : professeurs) {
				professeur.initialize(nbJours, nbHeures);
			}
			for (Salle salle : salles) {
				salle.initialize(nbJours, nbHeures);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void setClasses() {
		classes = new ArrayList<>();
		for (ClasseJson classeJson : getClasseJsons()) {
			classes.add(transformClasseJson(classeJson));
		}
	}

	private Professeur findProfesseurById(int id) {
		for (Professeur professeur : professeurs) {
			if (professeur.getId() == id) {
				return professeur;
			}
		}
		return null;
	}

	private Classe transformClasseJson(ClasseJson cJson) {
		Classe classe = new Classe("vgf");
		ArrayList<MatiereJSON> matiereJSONs = cJson.getMatieres();
		ArrayList<Matiere> matieres = new ArrayList<>();
		Niveau niveau = niveaux.get(niveaux.indexOf(new Niveau("", cJson.getNiveau())));
		classe.setNiveau(niveau);
		classe.setMatieresAPlacer(matieres);
		for (MatiereJSON mJson : cJson.getMatieres()) {
			Matiere matiere = niveau.findMatiereById(mJson.getIdMatiere());
			matiere.setProfesseur(findProfesseurById(mJson.getIdProfesseur()));
			matieres.add(matiere);
		}
		return classe;
	}

	private ArrayList<ClasseJson> importClassesJson() {
		setClasseJsons(new ArrayList<>());
		ClasseJson classe;
		String nameFolder = folderpath + "/classes/";
		for (String name : getFileFromFolder(nameFolder)) {

			try {
				classe = gson.fromJson(new FileReader(nameFolder + name), ClasseJson.class);
				getClasseJsons().add(classe);
			} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return getClasseJsons();
	}

	private ArrayList<Niveau> importNiveaux() {
		niveaux = new ArrayList<>();
		Niveau niveau;
		String nameFolder = folderpath + "/niveaux/";
		for (String name : getFileFromFolder(nameFolder)) {

			try {
				niveau = gson.fromJson(new FileReader(nameFolder + name), Niveau.class);
				niveaux.add(niveau);
			} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return niveaux;
	}

	private ArrayList<Professeur> importProfesseurs() {
		professeurs = new ArrayList<>();
		Professeur prof;
		String nameFolder = folderpath + "/professeurs/";
		for (String name : getFileFromFolder(nameFolder)) {

			try {
				prof = gson.fromJson(new FileReader(nameFolder + name), Professeur.class);
				professeurs.add(prof);
			} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return professeurs;
	}

	private ArrayList<Salle> importSalles() {
		salles = new ArrayList<>();
		Salle salle;
		String nameFolder = folderpath + "/salles/";
		for (String name : getFileFromFolder(nameFolder)) {

			try {
				salle = gson.fromJson(new FileReader(nameFolder + name), Salle.class);
				salles.add(salle);
			} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return salles;
	}

	private String[] getFileFromFolder(String name) {
		File folder = new File(name);
		for (String dq : folder.list()) {
		}
		return folder.list();
	}

	public String getFolderpath() {
		return folderpath;
	}

	public void setFolderpath(String folderpath) {
		this.folderpath = folderpath;
	}

	public ArrayList<Salle> getSalles() {
		return salles;
	}

	public void setSalles(ArrayList<Salle> salles) {
		this.salles = salles;
	}

	public ArrayList<Niveau> getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(ArrayList<Niveau> niveaux) {
		this.niveaux = niveaux;
	}

	public ArrayList<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(ArrayList<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

	private ArrayList<ClasseJson> getClasseJsons() {
		return classeJsons;
	}

	private void setClasseJsons(ArrayList<ClasseJson> classeJsons) {
		this.classeJsons = classeJsons;
	}

	public ArrayList<Classe> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<Classe> classes) {
		this.classes = classes;
	}
}
